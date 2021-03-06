import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArquivo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream("20210501_172034.jpg");
            fos = new FileOutputStream("Copia.jpg");
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
            fis.close();
            fos.close();
            long end = System.currentTimeMillis();
            System.out.println("Tempo gasto para cópia:" + (end - start));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
