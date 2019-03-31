import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/parsahejabi/University/Term 6/CompilerDesign/Homeworks/Scanner/src/test.cpp");
        CScanner cScanner = new CScanner(fileReader);
        Symbol symbol = cScanner.CScannerFunction();
        while (symbol != null){
            System.out.println(symbol.string);
            symbol = cScanner.CScannerFunction();
        }
        fileReader.close();
    }
}