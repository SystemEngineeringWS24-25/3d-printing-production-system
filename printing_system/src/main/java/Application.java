import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        MES mes = new MES();

        Thread mesThread = new Thread(mes);
        mesThread.start();

        System.in.read();
    }
}
