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
public class SendMail {

	/**
	 * Sendet eine Email &uuml;ber den vorkonfigurierten hannes-fischer.com Sender von info@kaepsele.de
	 * 
	 * @param recipientAdress Die Adresse des Empf&auml;ngers
	 * @param subject Der Betreff der Nachricht
	 * @param text Der Inhalt der Nachricht
	 */
    public void sendMail(String recipientAdress, String subject, String text) {
        sendMail("smtp.strato.de", "kaepsele@hannes-fischer.com", "Kaepse1e", "info@kaepsele.de", recipientAdress, subject, text);
    }

    /**
     * Sendet Email &uuml;ber gegebenen SMTP-Server
     * 
     * @param smtpHost Der Hostname zum Server
     * @param username Der Benutzername zum SMTP-Account
     * @param password Das Passwort zum SMTP-Account
     * @param senderAddress Die Emailadresse des Senders
     * @param recipientAddress Die Email-Adresse des Empf&auml;ngers
     * @param subject Der Betreff der Nachricht
     * @param text Die Inhalt der Nachricht
     */
    public void sendMail(String smtpHost, String username, String password, String senderAddress, String recipientAddress, String subject, String text) {
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
                    return new PasswordAuthentication(username,password);
                }
            });
        try {
        	//Nachricht zusammenbauen
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientAddress));
            message.setSubject(subject);
            message.setText(text);
            //Nachricht senden
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}