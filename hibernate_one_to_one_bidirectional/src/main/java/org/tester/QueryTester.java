package org.tester;

import org.config.HibernateUtil;
import org.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryTester {

public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("Sessiion Factory Created ="+sf);
		Session sess = sf.openSession();
			sess.beginTransaction();
			StudentDetails s =(StudentDetails)sess.get(StudentDetails.class,new Integer(1));
			sess.delete(s);
			
			System.out.println(s.getStudent());
			
			sess.getTransaction().commit();
			
		System.out.println("Done");
	}
	
}
