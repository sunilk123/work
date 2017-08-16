package DAO;

import Models.AdminLoginEntity;
import Models.ParkingLotEntity;
import Models.UserLoginEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
public class Dao {

    public static Session getSessionObject(){

        String hibernatePropsFilePath = "C:\\repo\\kalakand\\CarParkWebDB\\src\\Models\\hibernate.cfg.xml";

        File hibernatePropsFile = new File(hibernatePropsFilePath);
        Configuration cg =new Configuration().configure(hibernatePropsFile);
        cg.addAnnotatedClass(AdminLoginEntity.class);
        cg.addAnnotatedClass(UserLoginEntity.class);
        cg.addAnnotatedClass(ParkingLotEntity.class);
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(cg.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        SessionFactory sf= cg.buildSessionFactory(serviceRegistry);
        Session session = sf.openSession();
        return session;
    }

    public static void main(String[] args) {
        Session session=Dao.getSessionObject();
        UserLoginEntity us=(UserLoginEntity)session.get(UserLoginEntity.class,1);
        System.out.println(us);
    }
}
