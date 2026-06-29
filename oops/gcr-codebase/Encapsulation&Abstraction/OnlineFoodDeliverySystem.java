abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void displayItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
    }
}

class VegItem extends FoodItem {

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {

    private double serviceCharge = 50;

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {

        VegItem veg = new VegItem();
        veg.setItemName("Paneer Pizza");
        veg.setPrice(250);
        veg.setQuantity(2);

        NonVegItem nonVeg = new NonVegItem();
        nonVeg.setItemName("Chicken Burger");
        nonVeg.setPrice(180);
        nonVeg.setQuantity(2);

        veg.displayItemDetails();
        System.out.println("Total Price : ₹" +
                veg.calculateTotalPrice());

        System.out.println();

        nonVeg.displayItemDetails();
        System.out.println("Total Price : ₹" +
                nonVeg.calculateTotalPrice());
    }
}