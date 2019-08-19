import java.io.FileNotFoundException;
import java.util.List;

public class MainAPP {
    public static void main(String[] args) throws FileNotFoundException {

        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
    }
}