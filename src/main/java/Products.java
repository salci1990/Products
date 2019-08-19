import java.util.Objects;

public class Products {

    private String product_name;
    private String code;
    private double price;
    private String term_of_validity;

    public Products(String product_name, String code, double price, String term_of_validity) {
        this.product_name = product_name;
        this.code = code;
        this.price = price;
        this.term_of_validity = term_of_validity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public String getTerm_of_validity() {
        return term_of_validity;
    }

    public void setTerm_of_validity(String term_of_validity) {
        this.term_of_validity = term_of_validity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return price == products.price &&
                Objects.equals(product_name, products.product_name) &&
                Objects.equals(code, products.code) &&
                Objects.equals(term_of_validity, products.term_of_validity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product_name, code, price, term_of_validity);
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_name='" + product_name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", term_of_validity='" + term_of_validity + '\'' +
                '}';
    }
}