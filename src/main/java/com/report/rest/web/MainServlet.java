package com.report.rest.web;

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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
        switch (action) {
            case "/login":
                loginOrRegister(request, response);
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
            default:
                showLoginRegisterForm(request, response);
                break;
        }
    }

    private void showLoginRegisterForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login_register.jsp");
        dispatcher.forward(request, response);
    }

    private void loginOrRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

//        if (isAuthenticated(login, password)) {
        response.sendRedirect("/add-report-form");
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
    }

    @Override
    public void destroy() {
        System.out.println("Servlet was destroyed!");
        super.destroy();
    }


}