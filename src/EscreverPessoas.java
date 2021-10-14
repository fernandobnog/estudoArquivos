import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscreverPessoas {
    public static void main(String[] args) throws
            Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um Nome:");
        String nome = sc.nextLine();
        System.out.println("Idade:");
        String idade = sc.nextLine();
        System.out.println("Telefone:");
        String telefone = sc.nextLine();
        FileWriter fw =
                new FileWriter("Pessoas.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(nome + ";" + idade
                + ";" + telefone);
        pw.flush();
        pw.close();
        sc.close();
    }
}
