package tamanhodiretorio;

import java.io.File;
import java.util.*;

//Exemplificar a Classe File
//Calcular o tamanho de um diretório recursivamente
public class TamanhoDiretorio {
    List<File> maiores = new ArrayList<>();

    public static void main(String[] args) {
        TamanhoDiretorio obj = new TamanhoDiretorio();
        long tamanho = obj.tamanhoDiretorio(new File("."));
        System.out.println("O Tamanho calculado foi:" + tamanho);

        for (File f : obj.maiores) {
            System.out.println(f.getName() + ": " + f.length());
        }
    }

    long tamanhoDiretorio(File dir) {
        //Listar os arquivos do diretório
        long tamanho = 0;
        File[] filhos = dir.listFiles();
        for (File f : filhos) {
            if (f.isDirectory()) {
                tamanho += tamanhoDiretorio(f);
            } else {
                tamanho += f.length();
                verificaMaior(f);
            }
        }
        return tamanho;
    }

    public void verificaMaior(File f) {
        maiores.add(f);
        Collections.sort(maiores, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return (int) (o2.length() - o1.length());
            }
        });

        if (maiores.size() > 3) {
            maiores.remove(3);
        }
    }

}
