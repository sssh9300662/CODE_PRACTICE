import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

    public static void main(String[] args){
        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter("out.txt", true)));
            System.out.println("the text");
            System.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
