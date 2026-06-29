class Order {

    protected int orderId;
    protected String orderDate;

    Order(int orderId, String orderDate) {

        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {

    protected String trackingNumber;

    ShippedOrder(int orderId,
                 String orderDate,
                 String trackingNumber) {

        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {

    private String deliveryDate;

    DeliveredOrder(int orderId,
                   String orderDate,
                   String trackingNumber,
                   String deliveryDate) {

        super(orderId,
              orderDate,
              trackingNumber);

        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered on " +
               deliveryDate;
    }
}

public class OrderDemo {

    public static void main(String[] args) {

        Order order =
                new Order(
                        1001,
                        "01-06-2026");

        ShippedOrder shipped =
                new ShippedOrder(
                        1002,
                        "02-06-2026",
                        "TRK123");

        DeliveredOrder delivered =
                new DeliveredOrder(
                        1003,
                        "03-06-2026",
                        "TRK456",
                        "05-06-2026");

        System.out.println(
                order.getOrderStatus());

        System.out.println(
                shipped.getOrderStatus());

        System.out.println(
                delivered.getOrderStatus());
    }
}