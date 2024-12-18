import Data.ProductData;
import Data.QualityData;

public class QualityAssurance {
    public void testProduct(ProductData productData) throws InterruptedException {
        System.out.println("Quality Assurance: testProduct");
        Thread.sleep(Const.MAGIC_WAITING_TIME);
        System.out.println("Quality Assurance: testProduct");

        QualityData qualityData = new QualityData();
        MES.productTested(productData, qualityData);
    }
}
