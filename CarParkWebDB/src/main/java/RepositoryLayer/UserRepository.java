package RepositoryLayer;

import DAO.Dao;
import Models.UserLoginEntity;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
public class UserRepository {
    Session session= Dao.getSessionObject();

    public int getUserTable(){
        UserLoginEntity us=(UserLoginEntity) session.get("UserLoginEntity.class",1);
        return us.getUserid();
    }

}
