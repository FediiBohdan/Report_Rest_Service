package com.report.rest.db.dao.impl;

import com.report.rest.db.dao.SimpleDao;
import com.report.rest.db.dao.pool.ConnectionPool;
import com.report.rest.db.model.DailyReport;
import com.report.rest.db.model.Report;
import com.report.rest.db.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SimpleDaoImpl implements SimpleDao {
    private static final String FIND_USER_BY_ID ="Select u.id as id, l.nickname as nickname, u.name as name," +
            "u.surname as surname, u.patronymic as patronymic,u.email as email,l.password as password," +
            "u.dateoflastupdate as dateoflastupdate,u.dateofcreation as dateofcreation,u.isdeleted as isdeleted" +
            "from andersen.user u join andersen.login l on u.login_id=l.id where u.id=? and u.isdeleted=false;";
    private static final String FIND_USER_BY_NICKNAME_AND_PASSWORD ="Select u.id as id, l.nickname as nickname," +
            "u.name as name,u.surname as surname, u.patronymic as patronymic,u.email as email,l.password as password," +
            "u.dateoflastupdate as dateoflastupdate,u.dateofcreation as dateofcreation,u.isdeleted as isdeleted" +
            "from andersen.user u join andersen.login l on u.login_id=l.id where l.nickname=? and l.password=?;";
    private static final String CHECK_EMAIL_EXISTS ="Select id from andersen.user where email=?;";
    private static final String CHECK_NICKNAME_EXISTS ="Select id from andersen.login where nickname=?;";
    private static final String CREATE_LOGIN_CREDENTIALS ="Insert into andersen.login(nickname,password) values" +
            "(?,?) returning id;";
    private static final String CREATE_USER ="Insert into andersen.user(name,surname,patronymic,email,login_id" +
            "dateoflastupdate,dateofcreation,isdeleted) values (?,?,?,?,?,?,?,?) returning id;";
    private static final String UPDATE_USER ="Update andersen.user set name=? surname=? patronymic=? email=? " +
            "dateOfLastUpdate=? where id=? returning login_id";
    private static final String UPDATE_LOGIN ="Update andersen.login set nickname=? password=? where id=?";
    private static final String DELETE_USER_BY_ID ="UPDATE andersen.user SET isDeleted=TRUE WHERE id=? returning id;";
    private static final String DAILY_REPORT ="Select u.name as name, u.surname as surname, r.report as report " +
            "from andersen.report r join andersen.user u on r.user_id=u.id where dateOfReport between ? and ?;";
    private static final String CREATE_REPORT ="Insert into andersen.report(user_id,dateOfReport,report)values(?,?,?);";

    private static Connection connection;

    static {
        try {
            connection =ConnectionPool.getInstance().getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByID(long id) {
        User user =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("nickname"),
                        resultSet.getString("name"),resultSet.getString("surname"),
                        resultSet.getString("patronymic"),resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                        resultSet.getObject("dateOfCreation", LocalDateTime.class),
                        resultSet.getBoolean("isDeleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByNickAndPassword(String nickname, String password) {
        User user =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(FIND_USER_BY_NICKNAME_AND_PASSWORD);
            preparedStatement.setString(1,nickname);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("nickname"),
                        resultSet.getString("name"),resultSet.getString("surname"),
                        resultSet.getString("patronymic"),resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getObject("dateOfLastUpdate", LocalDateTime.class),
                        resultSet.getObject("dateOfCreation", LocalDateTime.class),
                        resultSet.getBoolean("isDeleted"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean emailExists(String email) {
        boolean exists =false;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(CHECK_EMAIL_EXISTS);
            preparedStatement.setString(1,email);
            exists=preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public boolean nicknameExists(String nickname) {
        boolean exists =false;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(CHECK_NICKNAME_EXISTS);
            preparedStatement.setString(1,nickname);
            exists=preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public Long createUser(User user) {
        Long user_id =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(CREATE_LOGIN_CREDENTIALS);
            preparedStatement.setString(1,user.getNickname());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSetOfLogin =preparedStatement.executeQuery();
            resultSetOfLogin.next();
            Long idret =resultSetOfLogin.getLong("id");

            preparedStatement =connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPatronymic());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setLong(5,idret);
            preparedStatement.setObject(6,user.getDateOfLastUpdate());
            preparedStatement.setObject(7,user.getDateOfCreation());
            preparedStatement.setBoolean(8,user.getDeleted());
            ResultSet resultSet =preparedStatement.executeQuery();
            resultSet.next();
            user_id =resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_id;
    }

    @Override
    public String deleteUser(long id) {
        String result ="";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1,id);
            int rowAffected =preparedStatement.executeUpdate();
            if (rowAffected>0) {
                result="success";
            } else {
                result="fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String updateUser(User user) {
        String result ="";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPatronymic());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setObject(5,user.getDateOfLastUpdate());
            preparedStatement.setLong(6,user.getId());
            ResultSet resultSetOfUpdateUser =preparedStatement.executeQuery();
            resultSetOfUpdateUser.next();
            Long login_id =resultSetOfUpdateUser.getLong("login_id");

            preparedStatement =connection.prepareStatement(UPDATE_LOGIN);
            preparedStatement.setString(1,user.getNickname());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setLong(3,login_id);
            int rowAffected =preparedStatement.executeUpdate();
            if (rowAffected>0) {
                result="success";
            } else {
                result="fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long createReport(long userId, Report report) {
        Long rep_id =null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(CREATE_REPORT);
            preparedStatement.setLong(1,userId);
            preparedStatement.setObject(2,report.getDateOfReport());
            preparedStatement.setString(3,report.getTextOfReport());
            ResultSet resultSet =preparedStatement.executeQuery();
            resultSet.next();
            rep_id =resultSet.getLong("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rep_id;
    }

    @Override
    public List<DailyReport> getDailyReport(LocalDateTime today) {
        List<DailyReport> dailyReports =new ArrayList<>();
        LocalDateTime yesterday =today.minusDays(1);
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(DAILY_REPORT);
            preparedStatement.setObject(1,yesterday);
            preparedStatement.setObject(2,today);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                dailyReports.add(new DailyReport(resultSet.getString("name"),
                        resultSet.getString("surname"),resultSet.getString("report")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return dailyReports;
    }
}
