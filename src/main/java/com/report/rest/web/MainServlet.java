package com.report.rest.web;

import com.report.rest.db.dao.impl.SimpleDaoImpl;
import com.report.rest.db.model.User;
import com.report.rest.mail.SendAttachment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    private SimpleDaoImpl dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new SimpleDaoImpl();

        SendAttachment sendAttachment = new SendAttachment();
        try {
            sendAttachment.dateOfSend();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        String login = (String) request.getSession().getAttribute("login");
        String password = (String) request.getSession().getAttribute("password");

        if (isAuthenticated(login, password)) {
            switch (action) {
                case "/add-report-form":
                    showAddReportForm(request, response);
                    break;
                case "/insert-report":
                    addReport(request, response);
                    break;
            }
        } else {
            switch (action) {
                case "/login-confirm":
                    loginConfirm(request, response);
                    break;
                case "/register":
                    showRegisterForm(request, response);
                    break;
                case "/register-confirm":
                    registerConfirm(request, response);
                    break;
                default:
                    showLoginRegisterForm(request, response);
                    break;
            }
        }


        /*switch (action) {
            case "/login-confirm":
                loginConfirm(request, response);
                break;
            case "/add-report-form":
                showAddReportForm(request, response);
                break;
            case "/insert-report":
                addReport(request, response);
                break;
            case "/register":
                showRegisterForm(request, response);
                break;
            case "/register-confirm":
                registerConfirm(request, response);
                break;
            default:
                showLoginRegisterForm(request, response);
                break;
        }*/
    }

    private void showLoginRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void loginConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("password", password);

        response.sendRedirect("add-report-form");

   /*     if (isAuthenticated(login, password)) {
            response.sendRedirect("add-report-form");
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/HTML");
            response.getWriter().write("Login failed! Or maybe you are not registered...");
        }*/
    }

    private void registerConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("password", password);

//        if (isAuthenticated(login, password)) {
        response.sendRedirect("add-report-form");
//        } else {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/HTML");
//        response.getWriter().write("Login failed! Or maybe you are not registered...");
//        }
    }

    private void showAddReportForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addReport.jsp");
        dispatcher.forward(request, response);
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    private void addReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Insert in DB
        String report = request.getParameter("message");
        System.out.println(report);

        response.sendRedirect("add-report-form");
    }

    private boolean isAuthenticated(String login, String password) {
        boolean result = false;
        if (login != null && password != null) {
            User user = dao.findByNickAndPassword(login, password);
            if (user != null) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet was destroyed!");
        super.destroy();
    }
}