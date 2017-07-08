package business_objects;

/**
 * Created by User on 08.07.2017.
 */
public class Mail {
    private static final String RECIPIENT = "dina_abdykasheva@mail.ru";
    private static final String SUBJECT = "mentoring task";
    private static final String BODY = "bodytext";

    public String getRECIPIENT() {
        return RECIPIENT;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public String getBODY() {
        return BODY;
    }
}
