package webapptask.servlets;


import webapptask.dto.User;
import webapptask.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Date currentDate = new Date();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String birthDate = req.getParameter("birthDate");
        User createduser = new User(login, password, name, birthDate, currentDate.toString(), "Пользователь");
        UserStorage storage = UserStorage.getInstance();
        storage.addUser(createduser);
    }
}
