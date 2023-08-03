package uz.pdp.frontend;

import uz.pdp.dto.UserDTO;
import uz.pdp.entity.User;
import uz.pdp.enums.UserType;
import uz.pdp.service.UserService;
import uz.pdp.service.UserServiceImpl;
import uz.pdp.test.Main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UI {
    static Scanner textScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";


    static {
        userService.create(new UserDTO("admin", "root123456", "root123456", UserType.ADMIN));
    }

    public static void main(String[] args) {

        ui();


    }

    public static void ui() {
        while (true) {
            System.out.println(YELLOW + "1-->Ro'yhatdan o'tish:" + ANSI_RESET);
            System.out.println(YELLOW + "2-->Saytga kirish:" + ANSI_RESET);
            System.out.println(YELLOW + "3-->Malumotlarni yangilash:" + ANSI_RESET);
            System.out.println(YELLOW + "4-->Ro'yhatdan o'tish:" + ANSI_RESET);
            System.out.print(YELLOW + "Tanlang:" + ANSI_RESET);
            try {
                int enter = numberScanner.nextInt();
                switch (enter) {
                    case 1 -> {
                        page1();
                    }
                    case 2 -> {
                        page2();
                    }
                    case 3 -> {
                        page3();
                    }
                    default -> {
                        System.out.println(RED + "Noto'g'ri tanlov! Iltimos, mavjud bo'lgan tanlovlardan birini tanlang." + ANSI_RESET);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Noto'g'ri formatda belgi kiritildi. Iltimos, raqam kiriting." + ANSI_RESET);
                // Qayta so'rovni tozalash uchun:
                numberScanner.nextLine();
            }
        }

    }

    public static void page1() {
        String username;
        while (true) {
            System.out.print(YELLOW + "Enter the username:" + ANSI_RESET);
            username = textScanner.next();
            if (checkUserName(username)) {
                break;
            }
            System.out.println(RED + "User name hato kiritildi!! " + ANSI_RESET + GREEN + " Misol uchun:: Aslbek yoki Aslbek12 yani 5 tadan kop bolgan harf yoki raqamlardan foydalaning." + ANSI_RESET);
        }
        String password;
        while (true) {
            System.out.print(YELLOW + "password:" + ANSI_RESET);
            password = textScanner.next();
            if (checkPassword(password)) {
                break;
            }
            System.out.println(RED+"Parol notogri formatda kirildi !! Hech bo'maganda 1 ta katta harf va 1ta kichik harf  1 ta raqam 1ta belgi va uzunligi 5 dan katta bo'lsin. "+ANSI_RESET);
        }
        System.out.print(YELLOW + "Confirm password:" + ANSI_RESET);
        String confirmPassword = textScanner.next();
        while (!password.equals(confirmPassword)) {
            System.out.println(RED + "Confirm password birhil emas!" + ANSI_RESET);
            System.out.print(YELLOW + "Confirm password:" + ANSI_RESET);
            confirmPassword = textScanner.next();
        }

        UserDTO userDTO = new UserDTO(username, password, confirmPassword);
        if (userService.create(userDTO)) {
            System.out.println(GREEN + "==========> You have successfully registered!!! <============= " + ANSI_RESET);
        } else {
            System.out.println(RED + "=======> Bunday user alla qachon mavjud <========" + ANSI_RESET);
        }
    }

    private static boolean checkPassword(String password) {
        Pattern compile = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,}$");
        return compile.matcher(password).matches();

    }

    private static boolean checkUserName(String username) {
        Pattern compile = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
        return compile.matcher(username).matches();
    }

    public static void page2() {
        Scanner page2 = new Scanner(System.in);
        System.out.print(YELLOW + "Enter the username:" + ANSI_RESET);
        String enterUser = page2.next();
        System.out.print(YELLOW + "Enter the password:" + ANSI_RESET);
        String enterPassword = page2.next();
        if (userService.get(enterUser, enterPassword).getUsername().equals("")) {
            System.out.println(RED + "Username yoki password hato kiritildi!" + ANSI_RESET);
        } else {
            Main.mainMethod(userService.get(enterUser, enterPassword).getUserType());

        }
    }

    public static void page3() {
        Scanner page3 = new Scanner(System.in);
        System.out.print(YELLOW + "Enter the username:" + ANSI_RESET);
        String enterUser = page3.next();
        System.out.print(YELLOW + "Enter the password:" + ANSI_RESET);
        String enterPassword = page3.next();
        if (userService.get(enterUser, enterPassword).getUsername().equals("")) {
            System.out.println(RED + "Bunday foydalanuvchi mavjud emas iltimos user name va password ni to'gri kiriting!" + ANSI_RESET);
        } else {
            System.out.println(BLUE + "Aniq O'zgartirmoqchimisz!!!");
            System.out.println(YELLOW + "1--> Ha:" + ANSI_RESET);
            System.out.println(YELLOW + "0--> Yo'q:" + ANSI_RESET);
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            while (true) {
                if (n == 1) {
                    System.out.print(YELLOW + "Enter the username:" + ANSI_RESET);
                    String username = textScanner.next();
                    System.out.print(YELLOW + "password:" + ANSI_RESET);
                    String password = textScanner.next();
                    System.out.print(YELLOW + "Confirm password:" + ANSI_RESET);
                    String confirmPassword = textScanner.next();
//                new UserDTO(username, password, confirmPassword);
                    if (password.equals(confirmPassword)) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setUserType(UserType.USER);
                        boolean update = userService.update(user, enterUser);
                        if (update) {
                            System.out.println(GREEN + "Malumotlar Muvofoqyatli yakunlandi👍" + ANSI_RESET);
                        }
                        break;
                    } else {
                        System.out.println(RED + "Confirm password bir hil emas!" + ANSI_RESET);
                    }

                } else if (n == 0) {
                    ui();
                }

            }

        }
    }


}

