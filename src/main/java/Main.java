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
                        "<link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">" +
                        "</head>" +
                        "<body style=\"font-family: 'Roboto', sans-serif;\">" +
                        "<p>"
        );

        FileReader fileReader = new FileReader("/Users/parsahejabi/University/Term 6/CompilerDesign/Homeworks/Scanner/src/main/java/test.cpp");
        CScanner cScanner = new CScanner(fileReader);
        Symbol symbol = cScanner.CScannerFunction();
        while (symbol != null){
//            System.out.println(symbol.id);
            switch (symbol.id){
                case 1:
                    stringBuffer.append("<b style=\"color:#2196F3;\">" +
                            symbol.string +
                            "</b>");
                    break;
                case 2:
                    stringBuffer.append("<span style=\"color:#FF9800;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 3:
                    stringBuffer.append("<span style=\"color:#9C27B0;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 4:
                    stringBuffer.append("<i style=\"color:#9C27B0;\">" +
                            symbol.string +
                            "</i>");
                    break;
                case 5:
                    stringBuffer.append("<span style=\"color:#F44336;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 6:
                    stringBuffer.append("<span style=\"color:#4CAF50;\">" +
                            symbol.string +
                            "</span>");
                    break;
                case 7:
                    stringBuffer.append("<span style=\"color:#9E9E9E;\">" +
                            symbol.string +
                            "</span>");
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
                case 10:
                    stringBuffer.append("<i style=\"color:#4CAF50;\">" +
                            symbol.string +
                            "</i>");
                    break;
                case 100:
                    stringBuffer.append("<span>" +
                            symbol.string +
                            "</span>");
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