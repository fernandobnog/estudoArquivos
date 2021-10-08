import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArquivo {
    public static void main (String[] args){
        long ini = System.currentTimeMillis();
        FileInputStream fis;
        FileOutputStream fos;

        try{
            fis = new FileInputStream("2_48MB.jpg");
            fos = new FileOutputStream("copia.jpg");
            byte[] buffer = new byte[100000];

            int lidos;
            while((lidos = fis.read(buffer)) != -1){
                fos.write(buffer, 0, lidos);
            }
            fis.close();
            fos.close();
            long end = System.currentTimeMillis();
            System.out.println("tempo para copiar " + (end-ini) + " milisegundos");
        } catch (IOException ex){
            ex.printStackTrace();
        }finally {

        }
    }
}
