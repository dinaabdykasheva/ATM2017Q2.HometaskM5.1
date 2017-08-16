package app.business_objects;

/**
 * Created by User on 08.07.2017.
 */
public class Mail {
    private static String recipient;
    private static String subject;
    private static String body;

    public Mail(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
