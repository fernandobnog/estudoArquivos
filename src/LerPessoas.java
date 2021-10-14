import java.io.BufferedReader;
import java.io.FileReader;

public class LerPessoas {
    public static void main(String[] args) throws
            Exception {
        FileReader fr = new FileReader("Pessoas.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = null;
        while ((linha = br.readLine()) != null) {
            String[] str = linha.split(";");
            String nome = str[0];
            String idade = str[1];
            String telefone = str[2];
            System.out.println("Nome:" + nome
                    + " Idade:" + idade
                    + " Telefone:" + telefone);
        }
        br.close();
    }
}
