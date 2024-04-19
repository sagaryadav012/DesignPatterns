package StructuralDesignPatterns.AdapterDP;

import StructuralDesignPatterns.AdapterDP.Libraries.SendGrid;

public class SendGridEmailAdapter implements EmailAdapter{
    SendGrid client = new SendGrid();

    @Override
    public void sendEmail(String from, String to, String content) {
        client.sendEmail(from, to, content, null, null);
    }
}
