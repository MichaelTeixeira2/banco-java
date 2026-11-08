package excecoes;

public class ContaNaoEncontradaException extends BancoException {

    private String numero;

    public ContaNaoEncontradaException(String numero) {
        super("a conta: " +numero+ " nao existe");
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
