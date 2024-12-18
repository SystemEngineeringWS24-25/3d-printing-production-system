import Data.OrderData;
import Data.ProductData;

public class Printer implements Runnable {
    private final Printing printing;
    private final int id;
    private Boolean isPrinting;
    private int printTime;

    public Printer(Printing printing, int id) {
        this.printing = printing;
        this.id = id;
        this.isPrinting = false;
    }

    public int getId() {
        return id;
    }

    public Boolean IsPrinting() {
        return isPrinting;
    }

    @Override
    public void run() {
        System.out.println("Printer " + id + ": Start");

        while (true) {
            try {
                if (isPrinting) {
                    System.out.println("Printer " + id + " is printing...");
                    printTime -= Const.TIME_PER_PRINT_STEP;

                    if (printTime <= 0) {
                        filePrinted();
                    }
                }

                Thread.sleep(Const.TIME_PER_PRINT_STEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printFile(OrderData orderData) throws InterruptedException {
        System.out.println("Printer " + id + ": prints");

        printTime = orderData.getPrintTime();
        isPrinting = true;
    }

    public void filePrinted() throws InterruptedException {
        printTime = 0;
        isPrinting = false;

        ProductData productData = new ProductData();
        printing.filePrinted(productData, id);

        // TODO mes
        // TODO return file
    }
}
