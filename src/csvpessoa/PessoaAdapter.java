package csvpessoa;

public class PessoaAdapter {
    public static Pessoa fromCsv(String linha) {
        String[] str = linha.split(";");
        Pessoa p = new Pessoa();
        p.setNome(str[0]);
        p.setIdade(Integer.parseInt(str[1]));
        p.setTelefone(str[2]);
        return p;
    }

    public static String toCsv(Pessoa p) {
        return p.getNome() + ";" + p.getIdade() + ";" + p.getTelefone();
    }
}
