package uz.pdp.repository;

import uz.pdp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private  List<User> users=new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

}