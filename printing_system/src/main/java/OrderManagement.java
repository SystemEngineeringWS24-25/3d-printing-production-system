import Data.OrderData;

public class OrderManagement implements Runnable {

    public OrderManagement() {

    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Order Management: Send order data");

            OrderData orderData = new OrderData(1500);
            try {
                MES.receiveOrderData(orderData);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(25000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
