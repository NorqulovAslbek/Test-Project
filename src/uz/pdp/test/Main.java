package uz.pdp.test;

import uz.pdp.enums.UserType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static TestService testService = new TestService();
    private static Scanner scanner1 = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m\t";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

//    public static void main(String[] args) {
//
//        mainMethod();
//
//    }

    public static void mainMethod(UserType userType) {
        while (true) {
//            System.out.println("1->Test savollarini tuzish:"); //1
//            System.out.println("2->Testni savollarini ishlash:");//4
//            System.out.println("3->Testni o'zgartirish:");//2
//            System.out.println("4->Testni ochirish:");//3
//            System.out.print("Tanlang:");
            if (userType.equals(UserType.ADMIN)) {
                System.out.println(CYAN+"1->Test savollarini tuzish:"+ANSI_RESET);
                System.out.println(CYAN+"2-Test savollarini o'zgartirish:"+ANSI_RESET);
                System.out.println(CYAN+"3->Testni ochirish:"+ANSI_RESET);
                System.out.println(CYAN+"0->exit"+ANSI_RESET);
            } else {
                System.out.println(BLUE+"4-Testni ishlash:"+ANSI_RESET);
                System.out.println(BLUE+"0->exit"+ANSI_RESET);
            }
            int n = scanner1.nextInt();
            if (n == 0) {
                break;
            }
            while (true) {
                if (n == 1) {
                    task1();
                    System.out.println(BLUE+"0->Bosh menyuga qaytish;"+ANSI_RESET);
                    System.out.println(BLUE+"1->Davom etish;"+ANSI_RESET);
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
                }

            }


        }
    }


    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        count++;
        System.out.print(BLUE+(count + ")Savolni kiriting:")+ANSI_RESET);
        String questions = scanner.nextLine();
        System.out.print(BLUE+"a)"+ANSI_RESET);
        String answers1 = scanner.nextLine();
        System.out.print(BLUE+"b)"+ANSI_RESET);
        String answers2 = scanner.nextLine();
        System.out.print(BLUE+"c)"+ANSI_RESET);
        String answers3 = scanner.nextLine();
        System.out.print(BLUE+"d)"+ANSI_RESET);
        String answers4 = scanner.nextLine();
        while (true) {
            System.out.print(BLUE+"To'gri javobni kiriting:"+ANSI_RESET);
            String trueAnswer = scanner.nextLine();
            if (trueAnswer.equals("a") || trueAnswer.equals("b") || trueAnswer.equals("c") || trueAnswer.equals("d")) {
                Test test = new Test(trueAnswer, questions, answers1, answers2, answers3, answers4);
                if (testService.addTest(test)) {
                    System.out.println(RED+"Bunday test savoli allaqachon mavjud!"+ANSI_RESET);
                    count--;
                }
                break;
            } else {
                System.out.println(RED+"Mavjud bo'lmagan javobni tanladingiz."+ANSI_RESET);
            }
        }
    }

    public static void task2() {
        Scanner scannerTest = new Scanner(System.in);
        List<String> listAnswer = new ArrayList<>();
        Collections.shuffle(TestsRepository.getTestsRepository().getTests());
        for (int i = 0; i < TestsRepository.getTestsRepository().getTests().size(); i++) {
            System.out.println(BLUE+"==========================================================================="+ANSI_RESET);
            System.out.print(i + 1 + ")" + TestsRepository.getTestsRepository().getTests().get(i).toString());
            while (true) {
                System.out.print(BLUE+"Javobni tanlang:"+ANSI_RESET);
                String answer = scannerTest.next();
                if (answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d")) {
                    listAnswer.add(answer);
                    break;
                } else {
                    System.out.println(RED+"Mavjud bo'lmagan javobni tanladingiz."+ANSI_RESET);
                }
            }

        }
        if (count != 0) {
            System.out.println(GREEN+("Sizning Natijangiz:" +
                    testService.numberOfCorrectAnswers(TestsRepository.getTestsRepository().getTests(), listAnswer) + " ball")+ANSI_RESET);
        } else {
            System.out.println(RED+"Hali test savollari mavjud emas!"+ANSI_RESET);
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
        int testNumber = scanner1.nextInt() - 1;
        return testNumber;
    }

    private static void task4() {
        if (testService.removeTest(getTestNumber())) {
            System.out.println("Test mufoqyatli o'chirildi!");
            count--;
        } else {
            System.out.println("O'chirilmadi.");
        }
    }


}
