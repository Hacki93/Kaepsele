package controller;

import learning.Benutzer;

public class Workflow {

	public static void main(String[] args) {
		//Test
		Benutzer hannes = new Benutzer("hannes", "1234", "Hannes Fischer", "mail@hannes-fischer.com");
		Benutzer chris  = new Benutzer("chris", "penis", "Christoph Jachmann", "christoph.jachmann@gmail.com");
		chris.freundHinzufügen(hannes);
	}

}
