import Data.OrderData;
import Data.ProductData;
import Data.QualityData;

public class MES implements Runnable {
    public static MES instance;

    private Logistics logistics;
    private OrderManagement orderManagement;
    private Printing printing;
    private QualityAssurance qualityAssurance;

    public MES() {
        if (instance != null) {
            System.err.println("MES: There is already a mes started");
            return;
        }

        instance = this;

        logistics = new Logistics();
        orderManagement = new OrderManagement();
        printing = new Printing();
        qualityAssurance = new QualityAssurance();
    }

    public static void receiveOrderData(OrderData orderData) throws InterruptedException {
        System.out.println("MES: Received order data");

        instance.printing.printFile(orderData);
    }

    // TODO printing status
    public static void receivePrintingStatus(ProductData productData) throws InterruptedException {
        System.out.println("MES: Received printing status");
        instance.logistics.pickUpPrintedProduct(productData);
    }

    public static void printedProductTransported(ProductData productData) throws InterruptedException {
        System.out.println("MES: Printed product transported");
        instance.qualityAssurance.testProduct(productData);
    }

    public static void productTested(ProductData productData, QualityData qualityData) throws InterruptedException {
        System.out.println("MES: Product tested");

        // TODO handle quality data magic

        instance.logistics.pickUpTestedProduct(productData);
    }

    public static void testedProductTransported(ProductData productData) {
        System.out.println("MES: Tested Product transported");
    }

    @Override
    public void run() {
        System.out.println("MES: Start");

        printing.startPrinters();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // TODO each as thread
        //logistics
        Thread orderManagementThread = new Thread(orderManagement);
        orderManagementThread.start();
        //printing
        //qualityAssurance

        int counter = 0;
        while (counter < 10000) {
            try {
                counter++;
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("MES: Stop");
    }
}
