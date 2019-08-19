import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ProductTest {

    File file = new File(ProductConverter.PATH);
    File fileDoesNotExists = new File("oisdjf");
    String fileMissingName = "/home/whysoserious/Desktop/Products/products1.txt";
    String fileWrongValuePrice = "/home/whysoserious/Desktop/Products/products2.txt";
    String fileMissingPrice = "/home/whysoserious/Desktop/Products/products3.txt";
    String path = "/home/whysoserious/Desktop/Products/products1.txt";



    @Test
    public void isFileExists() {
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void isFileNotExists() {
        Assertions.assertFalse(fileDoesNotExists.exists());
    }

    @Test
    public void firstObjectFromListTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
        Assertions.assertEquals(products.get(1).toString(), ("Product{productName='Desperados', code='92837', price=4.99, termOfValidity='24-07-2019'}"));
    }

    @Test
    public void productsSizeTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(ProductConverter.PATH);
        Assertions.assertEquals(products.size(), 10);
    }

    @Test
    public void missingNameTest() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileMissingName);
        Assertions.assertEquals(products.get(0).getProductName(), "");
    }

    @Test
    public void missingPriceTest() throws FileNotFoundException {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            List<Product> products = ProductConverter.converter(fileMissingPrice);
        });
    }

    @Test
    public void wrongValuePrice1() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(1).getPrice(), 0.0);
    }

    @Test
    public void wrongValuePrice2() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(2).getPrice(), 30.50);
    }

    @Test
    public void wrongValuePrice3() throws FileNotFoundException {
        List<Product> products = ProductConverter.converter(fileWrongValuePrice);
        Assertions.assertEquals(products.get(0).getPrice(), -1.0);
    }
}