package classes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try{

			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Cliente.class)
					.buildSessionFactory();
		} catch (Exception e){
			e.printStackTrace();
		
}
}

	public static SessionFactory getFactory() {
		return factory;
	}
	public static void kill(){
		factory.close();
	}
}
