package controller;
import kommunikation.*;

public class Workflow {

	public static void main(String[] args) {
		new SendMail().sendMail("fischer.hannes@gmx.net", "Ihre Registrierung bei K�psele", "Sehr geehrte/r Hannes Fischer\n\nherzlich Willkommen bei K�psele.de, Deinem interaktiven Lernportal!");
	}

}
