package servico;

import excecoes.BancoException;
import excecoes.ContaDuplicadaException;
import excecoes.ContaNaoEncontradaException;
import excecoes.ValorInvalidoException;
import modelo.Conta;

import java.util.ArrayList;

public class Banco{

    private ArrayList<Conta> contas = new ArrayList<>();

    public Conta criarConta(String numero, String titular, double saldo) throws BancoException {
        for(Conta c : contas){
            if(c.getNumero().equalsIgnoreCase(numero)){
                throw new ContaDuplicadaException(numero);
            }
        }
        Conta conta = new Conta (numero,titular,saldo);

        contas.add(conta);

        return conta;
    }
    
    public void adicionar(Conta conta){
        contas.add(conta);
        System.out.println("conta adiconada com sucesso!");
    }
    
    public Conta buscarConta(String numero) throws ContaNaoEncontradaException{
        for(Conta c : contas){
            if(c.getNumero().equalsIgnoreCase(numero)){
                return c;
            }
        }
        throw new ContaNaoEncontradaException(numero);
    }

    public ArrayList<Conta> listarContas(){
        return new ArrayList<> (contas);
    }

    public void transferir(String origem, String destino, double valor) throws BancoException {
        if(origem.equalsIgnoreCase(destino)){
            throw new ValorInvalidoException("nao e possivel transferir para a mesma conta");
        }

        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
    }

}
