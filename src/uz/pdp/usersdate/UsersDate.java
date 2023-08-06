package uz.pdp.usersdate;

import uz.pdp.entity.User;
import uz.pdp.repository.UserRepository;

import java.util.List;

public class UsersDate {

    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void usersDate() {
        List<User> users = UserRepository.getUsers();
        int count = 1;
        System.out.println(BLUE + "------------------------------------------------------------" + ANSI_RESET);
        System.out.print(BLUE + "| "+ANSI_RESET + RED + count + ANSI_RESET +BLUE+ "  |" + ANSI_RESET + RED  + "    User name   " + ANSI_RESET + BLUE + "|" + ANSI_RESET);
        System.out.print(RED + "   Email address  " + ANSI_RESET + BLUE + "|" + ANSI_RESET);
        System.out.print(RED + "     password   " + ANSI_RESET + BLUE + "  |" + ANSI_RESET + "\n");
        System.out.print(BLUE + "------------------------------------------------------------\n" + ANSI_RESET);
        for (User user : users) {
            count++;
            System.out.print(BLUE + "|" + (count <= 9 ? (" " + RED + count + ANSI_RESET + "  ") : (git count > 9 & count < 100) ? ("|" + RED + count + ANSI_RESET + " ") : ("|" + RED + count + ANSI_RESET)) + ANSI_RESET);
            System.out.print(BLUE + "|   " + ANSI_RESET + RED + user.getUsername() + ANSI_RESET);
            for (int i = 0; i < 20 - ("|    " + user.getUsername()).length() - 2; i++) {
                System.out.print(" ");
            }
            System.out.print(BLUE + "|    " + ANSI_RESET + RED + user.getEmail() + ANSI_RESET);
            for (int i = 0; i < 20 - ("|" + user.getEmail()).length() - 5; i++) {
                System.out.print(" ");
            }
            System.out.print(BLUE + "|   " + ANSI_RESET + RED + user.getPassword() + ANSI_RESET);
            for (int i = 0; i < 20 - ("|  " + user.getPassword()).length() - 3; i++) {
                System.out.print(" ");
            }
            System.out.print(BLUE + " |\n" + ANSI_RESET);
            System.out.println(BLUE + "------------------------------------------------------------" + ANSI_RESET);

        }
    }


}
