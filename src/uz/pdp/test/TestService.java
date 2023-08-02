package uz.pdp.test;
import java.util.ArrayList;
import java.util.List;

public class TestService implements TestServiceInterface {

    @Override
    public boolean addTest(Test test) {
        for (int i = 0; i < TestsRepository.getTestsRepository().getTests().size(); i++) {
            if (TestsRepository.getTestsRepository().getTests().get(i).getQuestions().equals(test.getQuestions())) {
                return true;
            }
        }
        TestsRepository.getTestsRepository().getTests().add(test);
        return false;
    }

    @Override
    public int numberOfCorrectAnswers(List<Test> tests, List<String> listAnswer) {
        int count = 0;
        for (int i = 0; i < listAnswer.size(); i++) {
            if (tests.get(i).getTrueAnswer().equals(listAnswer.get(i))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean editTest(int index,Test test) {
        TestsRepository.getTestsRepository().getTests().set(index,test);
        return true;
    }

    @Override
    public boolean removeTest(int index) {
        return TestsRepository.getTestsRepository().getTests().remove(index)!=null;
    }
}
