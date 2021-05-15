package telusko.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args ){
    	//AlienDataBase();    	
    	StudentLaptop();
    }    

    
    public static void StudentLaptop() {
    	
    	Laptop laptop= new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Student s = new Student();
    	s.setName("Kacper");
    	s.setSid(1);
    	s.setMarks(50);
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	session.save(laptop);
    	session.save(s);
    	
    	session.getTransaction().commit();
    }
    
    
    public static void AlienDataBase() {
    	
    	AlienName an=new AlienName();
    	an.setFname("Tytus");
    	an.setLname("Kacper");
    	an.setMname("Patryk");
    	
    	
    	Alien kacper = new Alien();
    	kacper.setId(51);
    	kacper.setName(an);
    	kacper.setColor("red");
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	session.save(kacper);
    	  
    	kacper=(Alien)session.get(Alien.class, 51);
    	

    
    	tx.commit();
    	
    	System.out.println(kacper);
    	
    }
    
}
