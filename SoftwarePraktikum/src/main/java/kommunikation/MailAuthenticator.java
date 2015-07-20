package kommunikation;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Hilfsklasse, die der Session in Email einen MailAuthenticator (Speicherklasse f&uuml;r benutzer und passwort) erstellt
 */
public class MailAuthenticator extends Authenticator {

        private final String benutzer;
        private final String passwort;

        /**
         * Konstruktor, erstellt einen MailAuthenticator
         * 
         * @param benutzer Benutzername des SMPT-Accounts
         * @param passwort Passwort des SMPT-Accounts
         */
        public MailAuthenticator(String benutzer, String passwort) {
            this.benutzer = benutzer;
            this.passwort = passwort;
        }
 
        /**
         * Gibt basierend auf den eingegeben Logindaten eine PasswordAuthentication zur&uuml;ck
         * @return PasswordAuthentication (Speicherklasse f&uuml;r user und password)
         */
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.benutzer, this.passwort);
        }
    }