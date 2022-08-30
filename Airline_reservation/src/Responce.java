import java.util.ArrayList;

public class Responce {
    private ArrayList<Message> _messagesList = new ArrayList<Message>();

    public boolean IsSuccessful() {
        for(Message m : _messagesList)
        {
        if(m.MessageType.equals("Exception") || m.MessageType.equals("Error"))
            return false;
        }
        return true;
    }

    public String getErrorMessagesList() {
        StringBuilder sb = new StringBuilder();
        for(Message m : _messagesList)
        {
        if(m.MessageType.equals("Exception") || m.MessageType.equals("Error"))
            sb.append(m.Description +"\n");
        }
        return sb.toString();
    }

    public void AddErrorMessage(String errorMessage) {
        addMessage(errorMessage, "Error");
    }

    public void addInformationMessage(String messageDesc) {
        addMessage(messageDesc,"Information");
    }

    private void addMessage(String messageDesc, String type) {
        Message objMessage = new Message(messageDesc,type);
        _messagesList.add(objMessage);
    }
    public class Message {
    public String MessageType;
    public String Description;

    Message(String errorMessage, String errorType) {
        MessageType = errorType;
        Description = errorMessage;
    }
}
}
