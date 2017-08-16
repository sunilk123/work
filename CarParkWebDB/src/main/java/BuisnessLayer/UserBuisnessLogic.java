package BuisnessLayer;

import Models.UserLoginEntity;
import RepositoryLayer.UserRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by SUNIL PC on 28-07-2017.
 */
public class UserBuisnessLogic {

    UserRepository userrepo=new UserRepository();
    public int CheckCredentials(String username,String Password){

        return userrepo.getUserTable();

    }
}
