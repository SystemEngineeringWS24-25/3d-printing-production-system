import Data.OrderData;
import Data.ProductData;

import java.util.ArrayList;
import java.util.List;

public class Printing {
    private final List<Printer> printers;

    public Printing() {
        printers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Printer printer = new Printer(this, i + 1);
            printers.add(printer);
        }
    }

    public void startPrinters() {
        System.out.println("Printing: start printers");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(printers.get(i));
            thread.start();
        }
        System.out.println("Printing: printers started");
    }

    public void printFile(OrderData orderData) throws InterruptedException {
        for (Printer printer : printers) {
            if (printer.IsPrinting()) {
                System.out.println("The printer " + printer.getId() + " is printing");
            }
        }

        // TODO get free printer, printing = sleep for 10 seconds
        printers.get(0).printFile(orderData);
    }

    public void filePrinted(ProductData productData, int printerID) throws InterruptedException {
        System.out.println("Printing: printer " + printerID + " finished");
        MES.receivePrintingStatus(productData);
    }
}
