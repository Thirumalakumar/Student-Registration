package com.hibernate.mapping;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
    	Laptop laptop = new Laptop();
    	laptop.setLid(106);
    	laptop.setLname("mbjadv");
    	
    	Student student = new Student();
    	student.setRollno(5);
    	student.setName("fsdbf");
    	student.setMarks(00);
    	//student.setLaptop(laptop);
    	student.getLaptop().add(laptop);
//    	laptop.getStudent().add(student);
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
        //SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
       
        //obj = (Alien) session.get(Alien.class, 102);
        session.save(laptop);       //---- to store data
        session.save(student);
       
        //Student student = (Student) session.get(Student.class, 1);
        
//        List<Laptop> laptop = student.getLaptop();
//        for(Laptop l : laptop)
//        	System.out.println(l);
        //Laptop laptop = (Laptop) session.get(Laptop.class, 101);
        
        tx.commit();
        
        //System.out.println("the value is:"+obj);
        
    }
}
