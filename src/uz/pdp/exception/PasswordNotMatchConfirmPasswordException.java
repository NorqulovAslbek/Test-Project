package uz.pdp.exception;

public class PasswordNotMatchConfirmPasswordException extends Exception {
    public PasswordNotMatchConfirmPasswordException() {
        super("Password and Confirm password don't match");
    }
}
