package uz.pdp.test;

public class Test {
    private String trueAnswer;
    private String questions;
    private String answers1;
    private String answers2;
    private String answers3;
    private String answers4;

    public String getQuestions() {
        return questions;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }


    public Test() {
    }

    public Test(String trueAnswer, String questions, String answers1, String answers2, String answers3, String answers4) {
        this.trueAnswer = trueAnswer;
        this.questions = questions;
        this.answers1 = answers1;
        this.answers2 = answers2;
        this.answers3 = answers3;
        this.answers4 = answers4;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setAnswers1(String answers1) {
        this.answers1 = answers1;
    }

    public void setAnswers2(String answers2) {
        this.answers2 = answers2;
    }

    public void setAnswers3(String answers3) {
        this.answers3 = answers3;
    }

    public void setAnswers4(String answers4) {
        this.answers4 = answers4;
    }

    @Override
    public String toString() {
        return questions + "\n" +
                "a)" + answers1 + "\n" +
                "b)" + answers2 + "\n" +
                "c)" + answers3 + "\n" +
                "d)" + answers4 + "\n";
    }
}
