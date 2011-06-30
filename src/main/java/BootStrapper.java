/**
 * Created by IntelliJ IDEA.
 * User: yerinle
 * Date: 05/06/2011
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class BootStrapper {
    private static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession() {
        if(session.get() == null){
            try {
                session.set(sessionFactory.getCurrentSession());
            } catch (HibernateException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return session.get();
    }
}
