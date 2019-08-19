import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAPP {
    public static void main(String[] args) throws FileNotFoundException {

        Products products;
        File file = new File("/home/whysoserious/Desktop/Products/products.txt");
        Scanner scanner = new Scanner(file);

        List<String> productsList = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            productsList.add(line);
        }
        System.out.println(productsList);
    }
}