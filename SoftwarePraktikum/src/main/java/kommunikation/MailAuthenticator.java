package kommunikation;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author Hannes
 * Hilfsklasse, die der Session in SendMail einen MailAuthenticator (Speicherklasse für user und password) erstellt
 */
public class MailAuthenticator extends Authenticator {

        private final String user;
        private final String password;

        /**
         * Konstruktor, erstellt einen MailAuthenticator
         * @param user Benutzername des SMPT-Accounts
         * @param password Passwort des SMPT-Accounts
         */
        public MailAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }
 
        /**
         * Gibt basierend auf den eingegeben Logindaten eine PasswordAuthentication zur&uuml;ck
         * @return PasswordAuthentication (Speicherklasse für user und password)
         */
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.password);
        }
    }