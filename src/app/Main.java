package app;

import excecoes.BancoException;
import modelo.Conta;
import servico.Banco;
import servico.GravadorDeContas;
import servico.GravadorSerializacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Banco banco = new Banco();

    public static void main(String[] args) {

        ArrayList<Conta> salvos = GravadorSerializacao.carregarContas();

        for(Conta s : salvos){
            banco.adicionar(s);
        }
        int opcao = -1;

        while (opcao != 0){


            System.out.println("====================");
            System.out.println("|| Conta Bancaria ||");
            System.out.println("====================");
            System.out.println("1- Abrir conta");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Transferir");
            System.out.println("5- Ver extrato");
            System.out.println("6- Listar contas");
            System.out.println("7- Salvar contas em arquivo");
            System.out.println("8 - Salvar contas em disco");
            System.out.println("0- Sair");
            System.out.print("opcao: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());

                switch (opcao){
                    case 1:{
                        System.out.print("numero da conta: ");
                        String numero = sc.nextLine();
                        System.out.print("nome do titular: ");
                        String nome = sc.nextLine();
                        System.out.print("saldo inicial: ");
                        double saldo = Double.parseDouble(sc.nextLine().replace(",", ".").trim());

                        Conta conta = banco.criarConta(numero,nome,saldo);
                        System.out.println("Conta criada | Numero: " +numero+ " | Nome: " +nome+ " | Saldo: "+saldo+" |");
                        break;
                    }
                    case 2:{
                        System.out.println("numero da conta: ");
                        String numero = sc.nextLine();
                        Conta conta = banco.buscarConta(numero);
                        System.out.println("Valor que deseja depositar: ");
                        double valor = Double.parseDouble(sc.nextLine().replace(",", ".").trim());
                        conta.depositar(valor);
                        System.out.println("deposito realizado com sucesso!! | Conta: " +numero+ " | Titular: " +conta.getTitular()+ " | " +
                                "saldo atual: " +conta.getSaldo()+ " |");
                        break;
                    }
                    case 3:{
                        System.out.println("numero da conta: ");
                        String numero = sc.nextLine();
                        Conta conta = banco.buscarConta(numero);
                        System.out.println("Valor que deseja sacar: ");
                        double valor = Double.parseDouble(sc.nextLine().replace(",", ".").trim());
                        conta.sacar(valor);
                        System.out.println("saque realizado com sucesso!! | Conta: " +numero+ " | Titular: " +conta.getTitular()+ " | " +
                                "saldo atual: " +conta.getSaldo()+ " |");
                        break;
                    }
                    case 4:{
                        System.out.println("Conta origem: ");
                        String origem = sc.nextLine();
                        System.out.println("Conta destino: ");
                        String destino = sc.nextLine();
                        System.out.println("valor que deseja transferir: ");
                        double valor = Double.parseDouble(sc.nextLine().replace(",", ".").trim());
                        banco.transferir(origem,destino,valor);
                        Conta contaOrigem = banco.buscarConta(origem);
                        Conta contaDestino = banco.buscarConta(destino);
                        System.out.println("transferencia realizado com sucesso!!");
                        System.out.println("| Conta origem: " +contaOrigem.getNumero()+ " | Titular: " +contaOrigem.getTitular()+ " | " +  "saldo atual: " +contaOrigem.getSaldo()+ " |");
                        System.out.println("| Conta destino: " +contaDestino.getNumero()+ " | Titular: " +contaDestino.getTitular()+ " | " +
                                "saldo atual: " +contaDestino.getSaldo()+ " |");
                        break;
                    }
                    case 5:{
                        System.out.println("numero da conta: ");
                        String numero = sc.nextLine();
                        Conta conta = banco.buscarConta(numero);
                        ArrayList<String> extrato = conta.getExtrato();
                        for(String e : extrato){
                            System.out.println(e);
                        }
                        break;
                    }
                    case 6:{
                        ArrayList<Conta> lista = banco.listarContas();
                        for(Conta l :lista){
                            System.out.println("| Numero: " +l.getNumero()+ " | Titular: " +l.getTitular()+ " | Saldo: " +l.getSaldo());
                        }
                        break;
                    }
                    case 7:{
                        GravadorDeContas.salvar(banco.listarContas());
                        System.out.println("Conta salva com sucesso!!");
                        break;
                    }
                    case 8:{
                        GravadorSerializacao.salvarContas(banco.listarContas());
                        break;
                    }
                    case 0:{
                        System.out.println("fechando conta...");
                        return;
                    }
                    default:{
                        System.out.println("opcao invalida!!");
                    }
                }
            } catch (BancoException e) {
                System.out.println(e.getMessage());;
            }
            catch (NumberFormatException e){
                System.out.println("Digite um numero valido!!");
            }
        }
    }

}


