import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
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
        String cppFilePath = new File("").getAbsolutePath();
        FileReader fileReader = new FileReader(cppFilePath + "/src/main/java/test.cpp");
        CScanner cScanner = new CScanner(fileReader);
        Symbol symbol = cScanner.CScannerFunction();
        while (symbol != null) {
            switch (symbol.id) {
                case 1:
                    stringBuilder.append("<b style=\"color:#2196F3;\">").append(symbol.string).append("</b>");
                    break;
                case 2:
                    stringBuilder.append("<span style=\"color:#FF9800;\">").append(symbol.string).append("</span>");
                    break;
                case 3:
                    stringBuilder.append("<span style=\"color:#9C27B0;\">").append(symbol.string).append("</span>");
                    break;
                case 4:
                    stringBuilder.append("<i style=\"color:#9C27B0;\">").append(symbol.string).append("</i>");
                    break;
                case 5:
                    stringBuilder.append("<span style=\"color:#F44336;\">").append(symbol.string).append("</span>");
                    break;
                case 6:
                    stringBuilder.append("<span style=\"color:#4CAF50;\">").append(symbol.string).append("</span>");
                    break;
                case 7:
                    stringBuilder.append("<span style=\"color:#9E9E9E;\">").append(symbol.string).append("</span>");
                    break;
                case 8:
                    if (symbol.string.equals("\t")) {
                        stringBuilder.append(symbol.string);
                    } else {
                        stringBuilder.append("&nbsp;");
                    }
                    break;
                case 9:
                    stringBuilder.append("<br>");
                    break;
                case 10:
                    stringBuilder.append("<i style=\"color:#4CAF50;\">").append(symbol.string).append("</i>");
                    break;
                case 100:
                    stringBuilder.append("<span>").append(symbol.string).append("</span>");
                    break;
            }
            symbol = cScanner.CScannerFunction();
        }
        fileReader.close();

        FileWriter fileWriter = new FileWriter("/Users/parsahejabi/University/Term 6/CompilerDesign/Homeworks/ComputerAssignment/Scanner/src/main/java/output.html");
        stringBuilder.append("</p>" +
                "</body>" +
                "</html>");
        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}