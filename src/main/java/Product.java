
import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private String productName;
    private String code;
    private double price = 0.0;
    private LocalDate termOfValidity;

    public Product(String productName, String code, double price, String termOfValidity) {
        this.productName = productName;
        this.code = code;
        this.price = price;
        this.termOfValidity = ProductConverter.dataFormatter(termOfValidity);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getTermOfValidity() {
        return termOfValidity;
    }

    public void setTermOfValidity(LocalDate termOfValidity) {
        this.termOfValidity = termOfValidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return price == products.price &&
                Objects.equals(productName, products.productName) &&
                Objects.equals(code, products.code) &&
                Objects.equals(termOfValidity, products.termOfValidity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, code, price, termOfValidity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", termOfValidity='" + termOfValidity + '\'' +
                '}';
    }
}