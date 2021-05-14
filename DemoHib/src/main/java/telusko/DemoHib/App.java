package telusko.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Alien kacper = new Alien();
    	kacper.setId(50);
    	kacper.setName("tulecso");
    	kacper.setColor("red");
    	
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	
    	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	
    	
    	SessionFactory sf=con.buildSessionFactory(reg);
    	
    	Session session=sf.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	  
    	
    	session.save(kacper);
    
    	tx.commit();
    
    }
}
