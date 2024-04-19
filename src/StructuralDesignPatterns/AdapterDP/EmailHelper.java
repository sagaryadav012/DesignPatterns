package StructuralDesignPatterns.AdapterDP;

public class EmailHelper {
    EmailAdapter emailAdapter;
    public EmailHelper(EmailAdapter emailAdapter){
        this.emailAdapter = emailAdapter;
    }

    public void sendEmail(String from, String to, String content){
        emailAdapter.sendEmail(from, to, content);
    }
}
