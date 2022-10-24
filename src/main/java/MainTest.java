import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        //Test for first task
        File file = new File("test.txt");
        PhoneReader01 phoneReader01 = new PhoneReader01();
        phoneReader01.read(file);

        //Test for second task
        Rewriter.rewrite();

        //Test for third task
        Calculator calculator = new Calculator();
        calculator.calculate();
    }
}
