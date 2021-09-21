package com.report.rest.db.dao;

import com.report.rest.db.model.DailyReport;
import com.report.rest.db.model.Report;
import com.report.rest.db.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface SimpleDao {

    User findByID(long id);
    User findByNickAndPassword(String nickname,String password);
    boolean emailExists(String email);
    boolean nicknameExists(String nickname);

    //возвращает id созданного пользователя
    Long createUser(User user );
    //возвращает "success" или "fail"
    String deleteUser(long id);
    String updateUser(User user);

    Long createReport(long userId, Report report);


    List<DailyReport> getDailyReport(LocalDateTime dateTime);

}
