package datenhaltung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Die Klasse Datenbank stellt die unterste Schicht der Kommunikation Portal <-> Datenbank da. Auf dieser Schicht werden die
 * direkten Quests auf der Datenbank durchgef&uuml;hrt, die vorher durch die benutzerfreundlichere Klasse "DatenbankenAbfrage"
 * zusammengestellt wurden. Die einzelnen Tabellen in der Datenbank m&uuml;ssen dabei bereits manuell erstellt worden sein.
 * @author Hannes
 *
 */
public class Datenbank {
	
	 private static SessionFactory factory; 
	   
	   /**
	    * Konstruktor, der die Schnittstelle mitsamt persistenter SessionFactory erstellt.
	    */
	   public Datenbank() {
	      try{
	         factory = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
	         //Erinnerung: addPackage("com.xyz" before add...) add package if used.
	      }catch (Throwable ex) { 
	         System.err.println("Datenhaltung:Datenbank:Datenbank: sessionFactoryObject konnte nicht erstellt werden" + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	   }
	   
	   /**
	    * F&uuml;gt der Tabelle einen weiteren Eintrag hinzu.
	    * @return Die generierte ID
	    */
	   public int eintragHinzufuegen(Object eintrag){
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
	    */
	   public List<Object> tabelleAusgeben(String tabellenName){
	      Session session = factory.openSession();
	      Transaction transaction = null;
	      List<Object> eintraege = new ArrayList<Object>();
	      try {
	         transaction = session.beginTransaction();
	         eintraege = session.createQuery("FROM "+tabellenName).list(); 
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
	    * Aktualisiert einen Eintrag der Tabelle
	    */
	   public void eintragAktualisieren(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
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
	    */
	   public void eintragEntfernen(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
}
