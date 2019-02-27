import java.io.Serializable;

final class ChatMessage implements Serializable
{
    private static final long serialVersionUID = 6898543889087L;

    // Types of messages
    static final int MESSAGE = 0, LOGOUT = 1, DM = 2, LIST = 3, TICTACTOE = 4;

    // Here is where you should implement the chat message object.
    private int     typeMsg;
    private String  message;
    private String  recipient;

    // Variables, Constructors, Methods, etc.
    public ChatMessage(int typeMsg, String message, String recipient)
    {
        this.typeMsg = typeMsg;
        this.message = message;
        this.recipient = recipient;
    }

    public int  getTypeMsg()
    {
        return typeMsg;
    }

    public String getMessage()
    {
        return message;
    }

    public String getRecipent()
    {
        return recipient;
    }
}