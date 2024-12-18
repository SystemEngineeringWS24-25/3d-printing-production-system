import Data.ProductData;

public class Logistics {
    public void pickUpPrintedProduct(ProductData productData) throws InterruptedException {
        System.out.println("Logistics: Pick up printed product");

        Thread.sleep(Const.MAGIC_WAITING_TIME);

        System.out.println("Logistics: Printed product picked up");
        MES.printedProductTransported(productData);
    }

    public void pickUpTestedProduct(ProductData productData) throws InterruptedException {
        System.out.println("Logistics: Pick up tested product");

        Thread.sleep(Const.MAGIC_WAITING_TIME);

        System.out.println("Logistics: Pick up tested product");
        MES.testedProductTransported(productData);
    }
}
