package org.tester;

import java.util.Date;
import org.config.HibernateUtil;
import org.entity.Student;
import org.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveTester {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		System.out.println("Sessiion Factory Created ="+sf);
		Session sess = sf.openSession();
			sess.beginTransaction();
		
		Student s = new Student();
			s.setSchoolCode("SPA002");
			s.setsName("XYZ");
			
		StudentDetails sd = new StudentDetails();
			sd.setAge(18);
			sd.setHeight(5.9);
			sd.setWeight(70);
			sd.setDob(new Date());
			
			s.setsDetails(sd);
			sd.setStudent(s);
			sess.save(s);
			sess.getTransaction().commit();
			
		System.out.println("Done");
		
	}
}
