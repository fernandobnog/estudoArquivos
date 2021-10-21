package csvpessoa;

import java.util.Scanner;

public class PessoaMenu {
    private Scanner sc;
    PessoaMenu(Scanner sc) {
        this.sc = sc;
    }

    public Pessoa entrePessoa() {
        Pessoa p = new Pessoa();
        System.out.println("Informe o Nome:");
        p.setNome(sc.nextLine());
        System.out.println("Informe o Idade:");
        p.setIdade(sc.nextInt());
        sc.nextLine();
        System.out.println("Informe o Telefone:");
        p.setTelefone(sc.nextLine());
        return p;
    }

    public void exibePessoa(Pessoa p) {
        System.out.println("Pessoa:" + p.getNome() + "  "
                 + p.getIdade() + "  " + p.getTelefone());
    }

    public Pessoa excluirPessoa() {
        System.out.println("Informe o Nome da pessoa a Excluir:");
        Pessoa p = new Pessoa();
        p.setNome(sc.nextLine());
        return p;
    }

    public OpcaoEnum obterOpcao() {
        while (true) {
            System.out.println("Entre com a Opção:");
            System.out.println("1 - Abrir arquivo");
            System.out.println("2 - Salvar arquivo");
            System.out.println("3 - Cadastrar pessoa");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar");
            System.out.println("6 - SAIR");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1: return OpcaoEnum.ABRIR_ARQUIVO;
                case 2: return OpcaoEnum.SALVAR_ARQIVO;
                case 3: return OpcaoEnum.CADASTRAR_PESSOA;
                case 4: return OpcaoEnum.EXCLUIR_PESSOA;
                case 5: return OpcaoEnum.LISTAR_PESSOA;
                case 6: return OpcaoEnum.SAIR;
            }
        }

    }
}
