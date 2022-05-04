package webapptask.dto;

public class Message {
    private final String dateAndTime;
    private final String sender;
    private final String receiver;
    private final String message;

    public Message(String dateAndTime, String sender, String receiver, String message) {
        this.dateAndTime = dateAndTime;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public void printMessage(){
        System.out.println("[" + dateAndTime + "]" + "[" + sender + "]:" + message);
    }

}
