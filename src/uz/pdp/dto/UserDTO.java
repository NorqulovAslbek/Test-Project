package uz.pdp.dto;

import uz.pdp.enums.UserType;
import uz.pdp.exception.PasswordNotMatchConfirmPasswordException;

public record UserDTO (String username, String password, String confirmPassword, UserType userType){
    public UserDTO(String username, String password, String confirmPassword) {
        this(username, password, confirmPassword, UserType.USER);
    }

    public UserDTO {
        if (username==null||password==null||confirmPassword==null){
            throw new NullPointerException("One of the fields is null!!!");
        }else if (!password.equals(confirmPassword)){
            try {
                throw new PasswordNotMatchConfirmPasswordException();
            } catch (PasswordNotMatchConfirmPasswordException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", userType=" + userType +
                '}';
    }
}
