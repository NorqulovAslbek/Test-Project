package uz.pdp.test;

import java.util.ArrayList;
import java.util.List;

public class TestsRepository {
    private static  TestsRepository testsRepository=new TestsRepository();
    private final List<Test> tests=new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public static TestsRepository getTestsRepository() {
        return testsRepository;
    }
}
