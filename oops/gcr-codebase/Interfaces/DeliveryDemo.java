interface FoodDelivery {

    void deliverFood();

    default void trackOrder() {
        System.out.println(
                "Tracking food delivery...");
    }

    static String generateDeliveryCode() {

        return "FD" +
                (1000 + (int)
                        (Math.random() * 9000));
    }
}

interface GroceryDelivery {

    void deliverGroceries();

    default void trackOrder() {
        System.out.println(
                "Tracking grocery delivery...");
    }
}

class DeliveryExecutive
        implements FoodDelivery,
                   GroceryDelivery {

    @Override
    public void deliverFood() {

        System.out.println(
                "Food delivered successfully");
    }

    @Override
    public void deliverGroceries() {

        System.out.println(
                "Groceries delivered successfully");
    }

    @Override
    public void trackOrder() {

        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    void processDeliveries(
            String[] customers) {

        for (String customer : customers) {

            String code =
                    FoodDelivery
                            .generateDeliveryCode();

            System.out.println(
                    "\nCustomer: " + customer);

            System.out.println(
                    "Delivery Code: " + code);

            trackOrder();

            deliverFood();
            deliverGroceries();
        }
    }
}

public class DeliveryDemo {

    public static void main(String[] args) {

        String[] customers = {
                "Mayank",
                "Rahul",
                "Aman"
        };

        DeliveryExecutive executive =
                new DeliveryExecutive();

        executive.processDeliveries(
                customers);
    }
}