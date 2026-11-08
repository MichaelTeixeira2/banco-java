package modelo;

import excecoes.SaldoInsuficienteException;
import excecoes.ValorInvalidoException;

import java.util.ArrayList;

public class Conta {

    private String numero;
    private String titular;
    private double saldo;
    private ArrayList<String> extrato = new ArrayList<>();

    public ArrayList<String> getExtrato() {
        return extrato;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Conta(String numero, String titular, double saldo) throws ValorInvalidoException {

        if(numero == null || numero.isBlank()){
            throw new ValorInvalidoException("o numero da conta nao pode ser vazio!!");
        }
        if(titular == null || titular.isBlank()){
            throw new ValorInvalidoException("o campo nome nao pode ser vazio");
        }
        if(saldo < 0){
            throw new ValorInvalidoException("o saldo inicial nao pode ser negativo");
        }

        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        registrar("abertura de conta", saldo);
    }

    private void validarValor(double valor) throws ValorInvalidoException {
        if(valor < 0){
            throw new ValorInvalidoException("o valor nao pode ser menor do que zero!");
        }
    }

    private void registrar(String tipo, double valor){
        String linha = String.format(tipo + " | valor: " +valor+ " | saldo atual: R$ " +saldo);
        extrato.add(linha);
    }

    public void depositar(double valor) throws ValorInvalidoException{

        validarValor(valor);

        saldo += valor;
        registrar("Deposito", valor);
    }

    public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {

        validarValor(valor);

        if(valor > saldo){
            throw new SaldoInsuficienteException(saldo,valor);
        }

        saldo -= valor;
        registrar("saque",-valor);
    }
}
