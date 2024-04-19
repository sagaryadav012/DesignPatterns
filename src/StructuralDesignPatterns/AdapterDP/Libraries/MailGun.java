package StructuralDesignPatterns.AdapterDP.Libraries;

public class MailGun {
    public void send(String to, String from, String content, String[] cc, String[] bcc){
        System.out.println("Sending email to "+ to +" from "+ from +" via MailGun");
    }
}
