package telusko.DemoHib;

import java.util.Collection;

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
    //	StudentLaptop();
    //	AlienLaptop();
    	AlienLaptopEagerLeazy();
    	
    }    
    
    public static void AlienLaptopEagerLeazy() {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	
    	session.beginTransaction();
    
    	//Transaction tx=
    	
    	Alien a1=  (Alien) session.get(Alien.class, 51);
    	
    	
    	System.out.println(a1.getAname());
    	
    	Collection<Laptop> laps = a1.getLaps();
    			
    			for (Laptop l:laps) {
    				
    				System.out.println(l.getLname());
    			}
    	
    	session.getTransaction().commit();
    }
    
    public static void AlienLaptop() {
    
    	
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	
    	Alien an=new Alien();
    	an.setAname("Tytus");
    	an.setId(51);
    	Alien an2=new Alien();
    	an2.setAname("Kacper");
    	an2.setId(52);
    	Alien an3=new Alien();
    	an3.setAname("Patryk");
    	an3.setId(53);
    	Alien an4=new Alien();
    	an4.setAname("Cinek");
    	an4.setId(54);
    	
    	Laptop ln=new Laptop();
    	ln.setBrand("Dell");
    	ln.setLname("xxnx");
    	ln.setPrice(700);
    	ln.setLid(1);
    	ln.setAlien(an);
    	
    	Laptop ln4=new Laptop();
    	ln4.setBrand("Hp");
    	ln4.setLname("yy1");
    	ln4.setPrice(800);
    	ln4.setLid(4);
    	ln4.setAlien(an);
    	
    	Laptop ln2=new Laptop();
    	ln2.setBrand("Sony");
    	ln2.setLname("yy");
    	ln2.setPrice(800);
    	ln2.setLid(2);
    	ln2.setAlien(an2);
    	
    	Laptop ln3=new Laptop();
    	ln3.setBrand("Hp");
    	ln3.setLname("zz");
    	ln3.setPrice(900);
    	ln3.setLid(3);
    	ln3.setAlien(an3);    	
    	
    	session.save(an);
    	session.save(an3);
    	session.save(an4);
    	session.save(an2);
    	
    	session.save(ln);
    	session.save(ln2);
    	session.save(ln3);
    	session.save(ln4);
    	    	
    	session.getTransaction().commit();
    
    }
    

    
    public static void StudentLaptop() {
    	
    	Laptop laptop= new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");

    	
    	Student s = new Student();
    	s.setName("Kacper");
    	s.setSid(1);
    	s.setMarks(50);
    	s.getLaptop().add(laptop);
    	
  //  	laptop.getStudent().add(s);
    	
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
    //	kacper.setName(an);
   // 	kacper.setColor("red");
    	
    	
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
