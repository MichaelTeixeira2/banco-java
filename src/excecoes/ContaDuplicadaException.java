package excecoes;

public class ContaDuplicadaException extends BancoException{

    private String numero;

    public ContaDuplicadaException(String numero) {
        super("A conta: " +numero+ " ja existe!");
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
