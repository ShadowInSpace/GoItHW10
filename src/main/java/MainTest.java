import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        File file = new File("test.txt");
        PhoneReader01 phoneReader01 = new PhoneReader01();
        phoneReader01.read(file);

        Rewriter.rewrite();

        Calculator calculator = new Calculator();
        calculator.calculate();
    }
}
