package telusko.DemoHib;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    //	AlienLaptopEagerLeazy();
    //	AlienColorCaching();
    //	AlienColorCachingExercise();
    //	StudentSQL();
    //	LaptopsStates();
    	AlienTech();
    //	Jpa();
    }    
    
    public static void Jpa() {
    	
    	EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-persistence-unit");
    	EntityManager em=emf.createEntityManager();
    	
    	AlienTech a=em.find(AlienTech.class,4);
    	
    }
    
    public static void AlienTech(){
    
	Configuration con = new Configuration().configure().addAnnotatedClass(AlienTech.class);    	
	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
	SessionFactory sf=con.buildSessionFactory(reg); 	
	Session session=sf.openSession();
	
	session.beginTransaction();
	
	AlienTech an=new AlienTech();
	an.setAname("Tytus");
	an.setTech("Java");
	an.setAid(1);
	AlienTech an2=new AlienTech();
	an2.setAname("Kacper");
	an2.setTech("SQL");
	an2.setAid(2);
	AlienTech an3=new AlienTech();
	an3.setAname("Patryk");
	an3.setTech("Hibernate");
	an3.setAid(3);
	AlienTech an4=new AlienTech();
	an4.setAname("Cinek");
	an4.setTech("Spring");
	an4.setAid(4);
	
	session.save(an);
	session.save(an2);
	session.save(an3);
	session.save(an4);
	
	session.getTransaction().commit();
    
    }
	
    public static void LaptopsStates() {
    	Configuration con = new Configuration().configure().addAnnotatedClass(LaptopStates.class);
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	LaptopStates l= (LaptopStates) session.load(LaptopStates.class, 2001);

    	
    	System.out.println(l);
    	
    	
    
    	
    	
    	
//    	Random r = new Random();
//    	
//    	for(int i=1; i<=50;i++) {
//    		LaptopStates s = new LaptopStates();
//    		s.setLid(i);
//    		s.setBrand("Brand " +i);
//    		s.setPrice(r.nextInt(3000));
//    		session.save(s);
//    		
//    	}
//		LaptopStates s = new LaptopStates();
//		s.setLid(111);
//		s.setBrand("Apple ");
//		s.setPrice(1200);
//		session.save(s);
//		
//		LaptopStates s2 = new LaptopStates();
//		s2.setLid(112);
//		s2.setBrand("Dell " );
//		s2.setPrice(0);
//		session.save(s2);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    }
    
    public static void StudentSQL() {
    	
    	Configuration con = new Configuration().configure("hibernateSQL.cfg.xml").addAnnotatedClass(StudentSQL.class);
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	 
    	// Native Queries
    	SQLQuery query = session.createSQLQuery("select name,marks from studentSQL where marks>60");
    //	query.addEntity(StudentSQL.class);
    	
    	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List<StudentSQL> students=query.list();
    	
    	for(Object o : students) {
    		
    		Map m=(Map)o;
    		System.out.println(m.get("name") + " : " + m.get("marks"));
    		
    	}
    	
    	
//    	Random r = new Random();
//    	
//    	for(int i=1; i<=50;i++) {
//    		StudentSQL s = new StudentSQL();
//    		s.setSid(i);
//    		s.setName("Name " +i);
//    		s.setMarks(r.nextInt(100));
//    		session.save(s);
//    		
//    	}
    	int b =60;
    	
    //	Query q= session.createQuery("select sum(marks) from StudentSQL s where s.marks > :b");
    //	q.setParameter("b", b);
    	//Object[] student =(Object[]) q.uniqueResult();
    //	List<StudentSQL> students=q.list();
    //	List students=(List) q.list();


    	//List<Object[]> studentsO=(List<Object[]>) q.list();
    	
//    	for(Object s:students) {
//    		System.out.println(s);
//    		//System.out.println(s[0]+" : "+s[1]+ " : "+ s[2]);
//    		//System.out.println(s);
//    	}
        
    	session.getTransaction().commit();
    	session.close();
    }

    
    
    public static void AlienColorCachingExercise() {
    	
    	AlienColor a=null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(AlienColor.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	Query q1 = session.createQuery("from alien_table where id=3");
    	q1.setCacheable(true);
    	a=(AlienColor)q1.uniqueResult();
    	
   // 	a= (AlienColor) session.get(AlienColor.class, 1);
    	
    	System.out.println(a);
    
       	session.getTransaction().commit();
       	session.close();
       	
       	Session session2=sf.openSession();
       	session2.beginTransaction();
   // 	a= (AlienColor) session2.get(AlienColor.class, 1);
    	Query q2 = session2.createQuery("from alien_table where id=3");
    	q2.setCacheable(true);

    	a=(AlienColor)q2.uniqueResult();
    
    	System.out.println(a);
    
    	session2.getTransaction().commit();
    	session2.close();
    }

    
    public static void AlienColorCaching() {
    	Configuration con = new Configuration().configure().addAnnotatedClass(AlienColor.class);    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();   	   	
    	SessionFactory sf=con.buildSessionFactory(reg); 	
    	Session session=sf.openSession();
    	
    	session.beginTransaction();
    	
    	AlienColor an=new AlienColor();
    	an.setAname("Tytus");
    	an.setColor("Green");
    	an.setId(1);
    	AlienColor an2=new AlienColor();
    	an2.setAname("Kacper");
    	an2.setColor("Green");
    	an2.setId(2);
    	AlienColor an3=new AlienColor();
    	an3.setAname("Patryk");
    	an3.setColor("Green");
    	an3.setId(3);
    	AlienColor an4=new AlienColor();
    	an4.setAname("Cinek");
    	an4.setColor("Green");
    	an4.setId(4);
    	
    	session.save(an);
    	session.save(an2);
    	session.save(an3);
    	session.save(an4);
    	
    	session.getTransaction().commit();
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
