package util;

import org.hibernate.AnnotationException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Category;
import entity.Manufacture;
import entity.Product;

public class HibernateUtil {
	private static final SessionFactory FACTORY;
	
	
	static {
		Configuration conf = new Configuration();	
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Category.class);
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Manufacture.class);
		ServiceRegistry serviceRegistry =
		new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		
		FACTORY = conf.buildSessionFactory(serviceRegistry);
		

	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}
