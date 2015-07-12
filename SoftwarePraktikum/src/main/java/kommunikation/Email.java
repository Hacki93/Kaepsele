package kommunikation;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Hannes
 *
 * Diese Klasse beinhaltet Methoden zum Senden einer Email
 */
public class Email {

	/**
	 * Sendet eine Email &uuml;ber den vorkonfigurierten hannes-fischer.com Sender von info@kaepsele.de
	 * 
	 * @param recipientAdress Die Adresse des Empf&auml;ngers
	 * @param betreff Der Betreff der Nachricht
	 * @param inhalt Der Inhalt der Nachricht
	 */
    public void senden(String recipientAdress, String betreff, String inhalt) {
//        senden("smtp.strato.de", "kaepsele@hannes-fischer.com", "Kaepse1e", "info@kaepsele.de", recipientAdress, betreff, inhalt);
    }

    /**
     * Sendet Email &uuml;ber gegebenen SMTP-Server
     * 
     * @param smtpHost Der Hostname zum Server
     * @param benutzername Der Benutzername zum SMTP-Account
     * @param passwort Das Passwort zum SMTP-Account
     * @param senderAdresse Die Emailadresse des Senders
     * @param empfaengerAdresse Die Email-Adresse des Empf&auml;ngers
     * @param betreff Der Betreff der Nachricht
     * @param inhalt Die Inhalt der Nachricht
     */
    private void senden(String smtpHost, String benutzername, String passwort, String senderAdresse, String empfaengerAdresse, String betreff, String inhalt) {
    	//SMTP-Connection konfigurieren
    	Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465"); 
        //Session zusammenbauen
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(benutzername,passwort);
                }
            });
        try {
        	//Nachricht zusammenbauen
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderAdresse));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(empfaengerAdresse));
            message.setSubject(betreff);
            message.setText(inhalt);
            //Nachricht senden
            Transport.send(message);
            System.out.println("Kommunikation:Email:senden: Email wurde versendet");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}