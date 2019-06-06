package designpatterns.模板方法模式;

public class Test {
    public static void main(String[] args) {
        TestPaper studentA = new TestPaperA();
        studentA.TestQuestion1();
        studentA.TestQuestion2();
        studentA.TestQuestion3();

        TestPaper studentB = new TestPaperB();
        studentB.TestQuestion1();
        studentB.TestQuestion2();
        studentB.TestQuestion3();

    }
}
