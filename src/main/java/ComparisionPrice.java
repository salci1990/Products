import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class ComparisionPrice {

    public static Product minPrice() throws FileNotFoundException {

        List<Product> products = ProductConverter.converter(ProductConverter.PATH);

        return products.stream()
                .min(Comparator.comparing(p -> p.getPrice())).get();
    }

    public static Product maxPrice() throws FileNotFoundException {

        List<Product> products = ProductConverter.converter(ProductConverter.PATH);

        return products.stream()
                .max(Comparator.comparing(p -> p.getPrice())).get();
    }
}
