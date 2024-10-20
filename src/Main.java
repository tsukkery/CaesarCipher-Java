import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you want to go by entering your text or finding a file? (text/file)");
        String ans = scan.nextLine();
        if (ans.equals("text")){

            System.out.println("Write the text you want to cipher");
            String text = scan.nextLine();

            System.out.println("Write the shift not longer than alphabet");
            int shift = scan.nextInt();

            CaesarCipher.Encipher(text, shift);
        }

        else if (ans.equals("file")){

            System.out.println("Enter file path");
            String p = (scan.nextLine());
            if (Files.exists(Path.of(p))){
                Path path = Path.of(p);
                System.out.println("Write the shift not longer than alphabet");
                int shift = scan.nextInt();
                List<String> list = Files.readAllLines(path);
                for (String text : list){
                    CaesarCipher.Encipher(text, shift);
                }
            }
            else{
                System.out.println("Can't see that file");
            }

        }
        else{
            System.out.println("Error. Restart the programm");
        }
    }

}