package webapptask.servlets;

import webapptask.dto.Message;
import webapptask.dto.User;
import webapptask.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class MessageSenderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Date date = new Date();
        String dateAndTime = date.toString();
        String sender = req.getParameter("senderLogin");
        String receiver = req.getParameter("receiverLogin");
        String message = req.getParameter("message");
        Message newMessage = new Message(dateAndTime, sender, receiver, message);
        UserStorage storage = UserStorage.getInstance();

    }
}
