import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductConverter {

    public static final String PATH = "/home/whysoserious/Desktop/Products/products.txt";

    public static List<Product> converter(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        List<Product> productsList = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String splitList[] = line.split(";");
            double value = -1.0;
            if (splitList[2].length() > 0) {
                try {
                    value = Double.parseDouble(splitList[2]);
                } catch (NumberFormatException exception){
                    throw new NumberFormatException();
                }
            }
            productsList.add(new Product(splitList[0], splitList[1], value, splitList[3]));
        }
        return productsList;
    }
}