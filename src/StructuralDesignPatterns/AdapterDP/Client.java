package StructuralDesignPatterns.AdapterDP;

public class Client {
    public static void main(String[] args) {
        EmailHelper emailHelper = new EmailHelper(new SendGridEmailAdapter());
        emailHelper.sendEmail("sagar@scaler.com", "tanish@scaler.com", "Hello!");
    }
}

/*
Adapter design pattern : It helps us to connect two incompatible objects.

-> Here client wants to send mails to user, And he doesn't want to build own SMTP server instead he decides
   to use third party servers.
-> He decides to use SendGrid for mail service, written code will be looks like below

  class Client{
        SendGrid sendGrid = new SendGrid();

        public void sendEmail(String from, String to, String content){
            sendGrid.send(from, to, content);
        }
  }

-> In future, client wants to switch from SendGrid to MailGun. now he needs to re-write entire code again.
   Updated code looks like below.
   class Client{
        MailGun mailGun = new MainGun();

        public void sendEmail(String from, String to, String content){
            mailGun.sendEmail(to, from, content);
        }
  }
-> Now cons of above code are, Re-write code, It violates Dependency inversion principle.
-> DIP means no two concrete classes should not directly depend on each other, it leads to tight coupling.
-> So take interface, it has one method sendEmail. SendGridEmailAdapter and MailGunEmailAdapter will implement
   EmailAdapter interface and provide common method sendEmail, it acts as adapter for sendGrid's method and
   mailGun's method since they do have different method signature.

 */