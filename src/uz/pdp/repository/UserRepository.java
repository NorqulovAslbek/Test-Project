package uz.pdp.repository;

import uz.pdp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final List<User> users=new ArrayList<>();

//    public List<User> getUsers() {
//        return users;
//    }
    public static List<User> getUsers(){
        return users;
    }


}