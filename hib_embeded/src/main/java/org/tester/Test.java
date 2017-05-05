package org.tester;

import java.util.Date;

import org.config.HibernateUtill;
import org.entity.Address;
import org.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtill.getSessionFactory();
		System.out.println("sf created ="+sf);
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		Student student = new Student();
		student.setsName("aakash deep sharma");
		student.setSchoolCode("SPA003");
		
		Address ad = new Address();
		ad.setCity("ajmer");
		ad.setState("rajasthan");
		
		student.setAddress(ad);
		Integer id =(Integer) sess.save(student);
		student.setsId(id);
		student.setsName("XYZ");
		sess.update(student);
		sess.getTransaction().commit();
		sess.close();
		System.out.println("Done ="+id);
		
	}
}
