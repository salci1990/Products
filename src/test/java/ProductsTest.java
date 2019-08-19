import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ProductsTest {

    File file = new File("/home/whysoserious/Desktop/Products/products.txt");

    @Test
    public void isFileExists(){
        Assertions.assertTrue(file.exists());
    }
}