package webapptask.storage;

import webapptask.dto.Message;
import webapptask.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage{
    private Map<String, User> usermap = new HashMap();
    private static UserStorage INSTANCE;

    private UserStorage(){}


    public void addUser(User createdUser){
       Object check = usermap.putIfAbsent(createdUser.getLogin(), createdUser);
       if (check != null){
           throw new  IllegalArgumentException("Такой пользователь уже существует!");
       }
    }

    public boolean checkUser(String login, String password){
        User user = (User) usermap.get(login);
        String check = user.getPassword();
        if(check != null){
            if(check.equals(password)){
                return true;
            }
        } else {
            throw new IllegalArgumentException("Неверный логин или пароль!");
        }
        if(check == null){
            throw new  IllegalArgumentException("Неверный логин или пароль!");
        }
        return false;
    }

    public Message[] getMessageArray(String login){
        User user = usermap.get(login);
        return user.getMessages();
    }

    public void setMessageArray(String login, Message[] newArray){
        User user = usermap.get(login);
        user.setMessages(newArray);
    }

    public static UserStorage getInstance() {
        if(INSTANCE == null){
            INSTANCE = new UserStorage();
        }
        return INSTANCE;
    }
}
