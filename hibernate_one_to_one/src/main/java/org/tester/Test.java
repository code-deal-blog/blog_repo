package org.tester;

import java.util.Date;

import org.config.HibernateUtill;
import org.entity.Student;
import org.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtill.getSessionFactory();
		System.out.println("sf created ="+sf);
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		/*Student s = new Student();
		s.setSchoolCode("SPA001");
		s.setsName("Aakash");
		StudentDetails sd = new StudentDetails();
		sd.setAge(25);
		sd.setHeight(5.5);
		sd.setWeight(65);
		sd.setDob(new Date());
		s.setsDetails(sd);
		sd.setStudent(s);
		sess.save(s);
		sess.getTransaction().commit();*/
		
		
		/*StudentDetails sd = new StudentDetails();
		sd.setAge(40);
		sd.setHeight(7.5);
		sd.setWeight(66);
		sd.setDob(new Date());*/
		/*Student stu = (Student)sess.get(Student.class,new Integer(1));
		stu.setsDetails(sd);
		System.out.println(stu);*/
		
		StudentDetails stu = (StudentDetails)sess.get(StudentDetails.class,new Integer(1));
		System.out.println(stu.getStudent());
		sess.close();
		System.out.println("Done");
		
	}
}
