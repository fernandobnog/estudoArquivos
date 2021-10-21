import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaArquivoBufferSelectiona {
    public static void main(String[] args) {
        String arquivoEntrada = null;
        String arquivoSaida = null;
        //Seleciona a Entrada
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);
        if(ret == JFileChooser.APPROVE_OPTION) {
            // Selecionou e pressionou OK
            arquivoEntrada = fc.getSelectedFile().getAbsolutePath();
        } else {
            return;
        }

        //Seleciona a Saída
        fc = new JFileChooser();
        ret = fc.showSaveDialog(null);
        if(ret == JFileChooser.APPROVE_OPTION) {
            // Selecionou e pressionou OK
            arquivoSaida = fc.getSelectedFile().getAbsolutePath();
        } else {
            return;
        }


        long start = System.currentTimeMillis();
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream(arquivoEntrada);
            fos = new FileOutputStream(arquivoSaida);
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
