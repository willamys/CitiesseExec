package util.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class HibernateConnection {

	private static Configuration cfg;

	private static Configuration instance() {

		if (cfg == null) {
			cfg = new Configuration();
			cfg.configure("/properties/h1b3rn4t3.cfg.xml");

			SchemaUpdate te = new SchemaUpdate(cfg);
			te.execute(true, true);
		}

		return cfg;
	}

	public static Session getSession() {
		@SuppressWarnings("deprecation")
		SessionFactory sf = instance().buildSessionFactory();
		Session session = sf.openSession();
		
		return session;
	}

}
