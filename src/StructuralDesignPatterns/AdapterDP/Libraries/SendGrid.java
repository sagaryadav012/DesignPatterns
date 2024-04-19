package StructuralDesignPatterns.AdapterDP.Libraries;

public class SendGrid {
    public void sendEmail(String from, String to, String content, String[] cc, String[] bcc){
        System.out.println("Sending email to "+ to +" from "+ from +" via SendGrid");
    }
}
