import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArquivoBuffer {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream("20210501_172034.jpg");
            fos = new FileOutputStream("Copia.jpg");
            byte[] buffer= new byte[10000];
            int lidos;
            while ((lidos = fis.read(buffer)) != -1) {
                fos.write(buffer,0, lidos);
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
