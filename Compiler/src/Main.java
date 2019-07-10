import java_cup.runtime.ComplexSymbolFactory;

import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String cppFilePath = new File("").getAbsolutePath();
        try (FileReader fileReader = new FileReader(cppFilePath + "/src/test_files/test.cpp")) {
            ComplexSymbolFactory complexSymbolFactory = new ComplexSymbolFactory();
            Parser p = new Parser(new Scanner(fileReader, complexSymbolFactory), complexSymbolFactory);
//            p.debug_parse();
            p.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}