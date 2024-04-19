package StructuralDesignPatterns.AdapterDP;

import StructuralDesignPatterns.AdapterDP.Libraries.MailGun;

public class MailGunEmailAdapter implements EmailAdapter{
    MailGun client = new MailGun();

    @Override
    public void sendEmail(String from, String to, String content) {
        client.send(to, from, content, null, null);
    }
}
