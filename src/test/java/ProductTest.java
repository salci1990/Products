import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ProductTest {

    File file = new File(ProductConverter.PATH);
    File fileDoesNotExists = new File("oisdjf");
    String fileMissingNameAndCode = "/home/whysoserious/Desktop/Products/products1.txt";
    String fileWrongValuePrice = "/home/whysoserious/Desktop/Products/products2.txt";
    String fileMissingPrice = "/home/whysoserious/Desktop/Products/products3.txt";

    @Test
    public void isFileExists() {
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void isFileNotExists() {
        Assertions.assertFalse(fileDoesNotExists.exists());
    }

    @Test
    public void firstObjectFromListWithAllValuesTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
        Assertions.assertEquals(products.get(1).toString(), ("Product{productName='Desperados', code='92837', price=4.99, termOfValidity='24-07-2019'}"));
    }

    @Test
    public void productsSizeShouldHaveTenElementsTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
        Assertions.assertEquals(products.size(), 10);
    }

    @Test
    public void nameWithWrongValueTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileMissingNameAndCode);
        Assertions.assertEquals(products.get(0).getProductName(), "");
    }

    @Test
    public void priceWithWrongParametersTest() throws FileNotFoundException {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            List<Product> products = ProductConverter.converter(fileMissingPrice);
        });
    }

    @Test
    public void priceShouldHaveCorrectValueWithZeroTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(1).getPrice(), 0.0);
    }

    @Test
    public void priceShouldHaveValueLikeThirtyDotFiftyTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(2).getPrice(), 30.50);
    }

    @Test
    public void priceWithEmptyValue() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(0).getPrice(), -1.0);
    }

    @Test
    public void codeShouldHaveCorrectValueTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
        Assertions.assertEquals(products.get(0).getCode(), "87234");
    }

    @Test
    public void checkCodeWithoutValueTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileMissingNameAndCode);
        Assertions.assertEquals(products.get(0).getCode(), "");
    }
}