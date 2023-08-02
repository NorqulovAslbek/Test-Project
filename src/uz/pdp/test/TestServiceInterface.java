package uz.pdp.test;

import java.util.List;

public interface TestServiceInterface {

    boolean addTest(Test test);

    int numberOfCorrectAnswers(List<Test> tests,List<String> listAnswer);
    boolean editTest(int index,Test test);
    boolean removeTest(int index);
}
