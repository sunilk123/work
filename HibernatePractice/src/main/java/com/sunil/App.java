package com.sunil;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println(org.hibernate.Version.getVersionString());
        Student st=null;
        String hibernatePropsFilePath = "C:\\repo\\kalakand\\HibernatePractice\\src\\main\\hibernate.cfg.xml";

        File hibernatePropsFile = new File(hibernatePropsFilePath);
//        Configuration cg =new Configuration().configure(hibernatePropsFile).addAnnotatedClass(Student.class);
//        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(cg.getProperties());
//
//        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        Configuration cg= new Configuration();
        cg=cg.configure(hibernatePropsFile);
        SessionFactory sf= cg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx= ss.beginTransaction();
        st=(Student)ss.get(Student.class,1);
        System.out.println(st);
//        st=new Student();
//        st.setSId(4);
//        st.setSMarks(85);
//        st.setSName("satish");
//        ss.save(st);
        tx.commit();

    }
}
