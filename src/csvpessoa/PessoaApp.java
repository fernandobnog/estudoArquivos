package csvpessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaApp {
    public final static String ARQUIVO_PESSOA = "Pessoa.csv";

    public static List<Pessoa> pessoaList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PessoaMenu menu = new PessoaMenu(sc);
        while(true) {
            OpcaoEnum opcao = menu.obterOpcao();
            switch (opcao) {
                case ABRIR_ARQUIVO:
                    lerArquivo();
                    break;
                case SALVAR_ARQIVO:
                    escreverArquivo();
                    break;
                case CADASTRAR_PESSOA:
                    Pessoa p = menu.entrePessoa();
                    pessoaList.add(p);
                    break;
                case EXCLUIR_PESSOA:
                    Pessoa pExcluir = menu.excluirPessoa();
                    for (Pessoa px : pessoaList) {
                        if (px.getNome().equalsIgnoreCase(pExcluir.getNome())) {
                            pessoaList.remove(px);
                            break;
                        }
                    }
                    break;
                case LISTAR_PESSOA:
                    listarPessoas();
                    break;
                case SAIR:
                    return;
            }
        }
    }

    private static void listarPessoas() {
        for (Pessoa p : pessoaList) {
            System.out.println(p.getNome());
        }
    }

    public static void escreverArquivo() throws Exception {
        FileWriter fw = new FileWriter(ARQUIVO_PESSOA, false);
        for (Pessoa p : pessoaList) {
            fw.write(PessoaAdapter.toCsv(p) + "\n");
        }
        fw.close();
    }

    public static void lerArquivo() throws Exception {
        //Imprimir todas as pessoas
        FileReader fr = new FileReader(ARQUIVO_PESSOA);
        BufferedReader br = new BufferedReader(fr);
        String line;
        pessoaList.clear();
        while ((line = br.readLine()) != null) {
            Pessoa p = PessoaAdapter.fromCsv(line);
            pessoaList.add(p);
        }
        br.close();
    }

}
