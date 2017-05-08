package org.tester;

import org.config.HibernateUtil;
import org.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateTester {

public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("Sessiion Factory Created ="+sf);
		Session sess = sf.openSession();
			sess.beginTransaction();
			Student s =(Student)sess.get(Student.class,new Integer(1));
			System.out.println("Before update = "+s);
			s.setsName("XYZ");
			sess.update(s);
			System.out.println("After update = "+s);
			sess.getTransaction().commit();
			
		System.out.println("Done");
		
	}
	
}
