import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "<html>" +
                        "<head>" +
                        "<title>" +
                        "C Scanner Output" +
                        "</title>" +
                        "</head>" +
                        "<body>" +
                        "<p>"
        );

        FileReader fileReader = new FileReader("/Users/parsahejabi/University/Term 6/CompilerDesign/Homeworks/Scanner/src/main/java/test.cpp");
        CScanner cScanner = new CScanner(fileReader);
        Symbol symbol = cScanner.CScannerFunction();
        while (symbol != null){
//            System.out.println(symbol.id);
            switch (symbol.id){
                case 1:
                    stringBuffer.append("<b style=\"color:blue;\">" +
                            symbol.string +
                            "</b>");
                    break;
                case 2:
                    stringBuffer.append("<span style=\"color:orange;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 3:
                    stringBuffer.append("<span style=\"color:#9C27B0;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    if (symbol.string.equals("\t")){
                        stringBuffer.append(symbol.string);
                    }
                    else{
                        stringBuffer.append("&nbsp;");
                    }
                    break;
                case 9:
                    stringBuffer.append("<br>");
                    break;
            }
            symbol = cScanner.CScannerFunction();
        }
        fileReader.close();

        FileWriter fileWriter = new FileWriter("/Users/parsahejabi/University/Term 6/CompilerDesign/Homeworks/Scanner/src/main/java/output.html");
        stringBuffer.append("</p>" +
                "</body>" +
                "</html>");
        fileWriter.write(stringBuffer.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}