package uz.pdp.test;

import uz.pdp.entity.User;
import uz.pdp.enums.UserType;
import uz.pdp.frontend.UI;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.UserService;
import uz.pdp.usersdate.UsersDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static final TestService testService = new TestService();
    private static Scanner scanner1 = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

//    public static void main(String[] args) {
//
//        mainMethod();
//
//    }

    public static void mainMethod(String username, String password, UserService userService) {
        while (true) {

            User user = userService.get(username, password);
            if (user.getUserType() == UserType.ADMIN) {
                System.out.println(CYAN + "1->Test savollarini tuzish:" + ANSI_RESET);
                System.out.println(CYAN + "2->Test savollarini o'zgartirish:" + ANSI_RESET);
                System.out.println(CYAN + "3->Testni ochirish:" + ANSI_RESET);
                System.out.println(CYAN + "5->To'liq ro'yhatdan o'tish:" + ANSI_RESET);
                System.out.println(CYAN+"6->Sayt foydalanuvchilari malumotlari:");
                System.out.println(CYAN + "0->exit" + ANSI_RESET);
            } else {
//                System.out.println(UserRepository.getUsers());
                System.out.println(BLUE + "5->To'liq ro'yhatdan o'tish:" + ANSI_RESET);
                System.out.println(BLUE + "4->Testni ishlash:" + ANSI_RESET);
                System.out.println(BLUE + "0->exit" + ANSI_RESET);
            }
            System.out.print(RED+"Tanlang:"+ANSI_RESET);
            int n = scanner1.nextInt();
            if (n == 0) {
                break;
            }
            while (true) {
                if (n == 1) {
                    task1();
                    System.out.println(BLUE + "0->Bosh menyuga qaytish;" + ANSI_RESET);
                    System.out.println(BLUE + "1->Davom etish;" + ANSI_RESET);
                    int exit = scanner1.nextInt();
                    if (exit == 0) {
                        break;
                    }
                } else if (n == 4) {
                    task2();
                    break;
                } else if (n == 2) {
                    task3();
                    break;
                } else if (n == 3) {
                    task4();
                    break;
                } else if (n == 5) {
                    task5(username, password);
                    break;
                } else if (n==6&&user.getUserType()==UserType.ADMIN) {
                    task6();
                    break;
                }else{
                    System.out.println(RED+"Mavjud bo'lmagan raqamni kiritingiz!"+ANSI_RESET);
                    break;
                }

            }


        }
    }

    private static void task5(String username, String password) {
        List<User> users = UserRepository.getUsers();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user.getUserType() == UserType.USER) {
                    user.setUserType(UserType.USER);
                } else {
                    user.setUserType(UserType.ADMIN);
                }
                Scanner scanner1 = new Scanner(System.in);
                System.out.print(BLUE+"Usernameni kiriting: "+ANSI_RESET);
                String userName = scanner1.next();
                user.setUsername(userName);
                System.out.print(BLUE+"Passwordni kiriting:"+ANSI_RESET);
                password = scanner1.next();
                user.setPassword(password);
                System.out.print(BLUE+"Telefon raqamingizni kiriting: +998"+ANSI_RESET);
                String phoneNumber = "+998" + scanner1.next();
                user.setPhone(phoneNumber);
                System.out.print(BLUE+"Email addresingizni kiriting:"+ANSI_RESET);
                String email = scanner1.next();
                user.setEmail(email);
            }
        }
        System.out.println(GREEN+"Ish muvofoqyatli yakunlani!!"+ANSI_RESET);
        UI.ui();
    }


    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        count++;
        System.out.print(BLUE + (count + ")Savolni kiriting:") + ANSI_RESET);
        String questions = scanner.nextLine();
        System.out.print(BLUE + "a)" + ANSI_RESET);
        String answers1 = scanner.nextLine();
        System.out.print(BLUE + "b)" + ANSI_RESET);
        String answers2 = scanner.nextLine();
        System.out.print(BLUE + "c)" + ANSI_RESET);
        String answers3 = scanner.nextLine();
        System.out.print(BLUE + "d)" + ANSI_RESET);
        String answers4 = scanner.nextLine();
        while (true) {
            System.out.print(BLUE + "To'gri javobni kiriting:" + ANSI_RESET);
            String trueAnswer = scanner.nextLine();
            if (trueAnswer.equals("a") || trueAnswer.equals("b") || trueAnswer.equals("c") || trueAnswer.equals("d")) {
                Test test = new Test(trueAnswer, questions, answers1, answers2, answers3, answers4);
                if (testService.addTest(test)) {
                    System.out.println(RED + "Bunday test savoli allaqachon mavjud!" + ANSI_RESET);
                    count--;
                }
                break;
            } else {
                System.out.println(RED + "Mavjud bo'lmagan javobni tanladingiz." + ANSI_RESET);
            }
        }
    }

    public static void task2() {
        Scanner scannerTest = new Scanner(System.in);
        List<String> listAnswer = new ArrayList<>();
        Collections.shuffle(TestsRepository.getTestsRepository().getTests());
        for (int i = 0; i < TestsRepository.getTestsRepository().getTests().size(); i++) {
            System.out.println(BLUE + "===========================================================================" + ANSI_RESET);
            System.out.print(i + 1 + ")" + TestsRepository.getTestsRepository().getTests().get(i).toString());
            while (true) {
                System.out.print(BLUE + "Javobni tanlang:" + ANSI_RESET);
                String answer = scannerTest.next();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d")) {
                    listAnswer.add(answer);
                    break;
                } else {
                    System.out.println(RED + "Mavjud bo'lmagan javobni tanladingiz." + ANSI_RESET);
                }
            }

        }
        if (count != 0) {
            System.out.println(GREEN + ("Sizning Natijangiz:" +
                    testService.numberOfCorrectAnswers(TestsRepository.getTestsRepository().getTests(), listAnswer) + " ball") + ANSI_RESET);
        } else {
            System.out.println(RED + "Hali test savollari mavjud emas!" + ANSI_RESET);
        }
    }

    public static void task3() {
        int testNumber = getTestNumber();

        Scanner scanner = new Scanner(System.in);
        Scanner scannerAnswer = new Scanner(System.in);
        System.out.print("Yangi savolni kiriting:");
        String questions = scanner.nextLine();
        System.out.print("a)");
        String answers1 = scannerAnswer.nextLine();
        System.out.print("b)");
        String answers2 = scannerAnswer.nextLine();
        System.out.print("c)");
        String answers3 = scannerAnswer.nextLine();
        System.out.print("d)");
        String answers4 = scannerAnswer.nextLine();
        while (true) {
            System.out.print("To'gri javobni kiriting:");
            String trueAnswer = scanner.next();
            if (trueAnswer.equals("a") || trueAnswer.equals("b") || trueAnswer.equals("c") || trueAnswer.equals("d")) {
                Test test = new Test(trueAnswer, questions, answers1, answers2, answers3, answers4);
                testService.editTest(testNumber, test);
                System.out.println("Test muvofoqyatli O'zgartirildi!");
                break;
            } else {
                System.out.println("Mavjud bo'lmagan javobni tanladingiz.");
            }
        }
    }

    private static int getTestNumber() {
        List<Test> element = TestsRepository.getTestsRepository().getTests();
        for (int i = 0; i < element.size(); i++) {
            System.out.println((i + 1) + ")" + element.get(i).toString());
        }
        System.out.print("Test raqamini kiriting:");
        scanner1 = new Scanner(System.in);
//        int testNumber = scanner1.nextInt() - 1;
//        return testNumber;
        return scanner1.nextInt() - 1;
    }

    private static void task4() {
        if (testService.removeTest(getTestNumber())) {
            System.out.println("Test mufoqyatli o'chirildi!");
            count--;
        } else {
            System.out.println("O'chirilmadi.");
        }
    }
    private static void task6(){
        UsersDate.usersDate();
    }


}
