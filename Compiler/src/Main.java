import java_cup.runtime.ComplexSymbolFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String cppFilePath = new File("").getAbsolutePath();
        FileReader fileReader = new FileReader(cppFilePath + "/src/test.cpp");
        try {
            ComplexSymbolFactory complexSymbolFactory = new ComplexSymbolFactory();
            parser p = new parser(new CScanner(fileReader, complexSymbolFactory));
            Object result = p.parse().value;
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileReader.close();
    }
}