import ASTNodes.Program;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;

import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String cppFilePath = new File("").getAbsolutePath();
        try (FileReader fileReader = new FileReader(cppFilePath + "/src/test_files/test.cpp")) {
            ComplexSymbolFactory complexSymbolFactory = new ComplexSymbolFactory();
            Parser p = new Parser(new Scanner(fileReader, complexSymbolFactory), complexSymbolFactory);
//            p.debug_parse();
            Symbol symbol = p.parse();
            Program debug = (Program) symbol.value;
            System.out.println(debug);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}