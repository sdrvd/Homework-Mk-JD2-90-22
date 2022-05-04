package webapptask.dto;

public class User {
    private final String login;
    private final String password;
    private final String name;
    private final String birthDate;
    private final String registerDate;
    private String role;
    private Message messages[] = new Message[1];

    public User(String login, String password, String name, String birthDate, String registerDate, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthDate;
    }

    public String getRegisterdate() {
        return registerDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
