package datenhaltung;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Die Klasse Datenbank stellt die &uuml;ber der Session die n&auml;chste Schicht der Kommunikation Portal <-> Datenbank da. 
 * Auf dieser Schicht werden die direkten Quests auf der Datenbank durchgef&uuml;hrt. Pro Klassenobjekt wird dabei eine Datenbank
 * incl SessionFactory erstellt, die w&auml;hrend des gesamten Lebenszyklus der Software erhalten bleibt. Datenbanken werden auf
 * der n&auml;chsth&ouml;heren Schicht "DatenbankenVerwaltung" zusammengefasst, verwaltet und angesprochen.
 * @author Hannes
 */
@SuppressWarnings("deprecation")
public class Tabelle {
	
	private SessionFactory factory; 
	private Class klasse;
	
	   /**
	    * Konstruktor, der die Schnittstelle mitsamt persistenter SessionFactory erstellt
	    */
	public Tabelle(Class klasse, SessionFactory factory) {
		   this.klasse = klasse;
		   this.factory = factory;
		   System.out.println("Datenbank wird erstellt für "+klasse.getName());
	   }
	   
	   /**
	    * F&uuml;gt der Tabelle einen weiteren Eintrag hinzu.
	    * @return Die generierte ID
	    */
	   public int eintragHinzufuegen(Object eintrag){
		  System.out.println("Befehl zum Hinzufügen wird auf Datenbank ausgeführt");
	      Session session = factory.openSession();
	      Transaction transaction = null;
	      int id = 0;
	      try{
	         transaction = session.beginTransaction();
	         id = (int) session.save(eintrag); 
	         transaction.commit();
	      }catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return id;
	   }
	   
	   /**
	    * Gibt alle Eintraege aus der Tabelle zur&uuml;ck
	    * @return Alle Eintr&auml;ge der tabelle
	    */
	   public List<Object> tabelleAusgeben(){
	      Session session = factory.openSession();
	      Transaction transaction = null;
	      List<Object> eintraege = new ArrayList<Object>();
	      try {
	         transaction = session.beginTransaction();
	         eintraege = session.createQuery("FROM "+klasse.getName()).list(); 
	         transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction!=null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return eintraege;
	   }
	   
	   /**
	    * Gibt einen Eintrag zur&uuml;ck
	    * @param id Die ID des Eintrags
	    * @return Der Eintrag
	    */
	   public Object eintragAusgeben(int id) {
		   Session session = factory.openSession();
		      Transaction tx = null;
		      Object obj = new Object();
		      try{
		         tx = session.beginTransaction();
		         obj = session.get(klasse, id); 
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		        return obj;
		   }

	   
	   /**
	    * Aktualisiert einen Eintrag der Tabelle
	    * @param obj Der aktualisierte Eintrag
	    */
	   public void eintragAktualisieren(Object obj ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
			 session.update(obj); 
			 System.out.println("Objekt aktualisiert");
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   
	   /**
	    * Entfernt einen Eintrag aus der Tabelle
	    * @param id Die ID des zu entfernenden Eintrags
	    */
	   public void eintragEntfernen(Integer id){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Object obj = session.get(klasse, id); 
	         session.delete(obj); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
}
