package uz.pdp.service;

import uz.pdp.dto.UserDTO;
import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepository();

    @Override
    public boolean create(UserDTO userDTO) {
        if (checkUsername(userDTO.username())) {
            return false;
        }
        User user = new User();
        user.setUsername(userDTO.username());
        user.setPassword(userDTO.password());
        user.setUserType(userDTO.userType());
        userRepository.getUsers().add(user);
        return true;
    }

    @Override
    public User get(String username, String password) {
        for (User user : userRepository.getUsers()) {
            if (user.getPassword().equals(password) && user.getUsername().equals(username)) {
                return user;
            }
        }
        User user = new User();
        user.setUsername("");
        return user ;
    }

    @Override
    public boolean update(User user,String userName) {
        for (int i = 0; i < userRepository.getUsers().size(); i++) {
            if(userRepository.getUsers().get(i).getUsername().equals(userName)){
                userRepository.getUsers().set(i,user);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    private boolean checkUsername(String username) {
        for (User user : userRepository.getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword(String password) {
        for (User user : userRepository.getUsers()) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
