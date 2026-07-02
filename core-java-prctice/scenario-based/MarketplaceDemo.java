import java.util.*;

class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Product<T> {

    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " Price : " + price;
    }
}

public class MarketplaceDemo {

    public static <T extends Product<?>> void applyDiscount(T product, double percent) {

        product.price -= product.price * percent / 100;
    }

    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Book", 500, new BookCategory());

        applyDiscount(book, 20);

        System.out.println(book);
    }
}