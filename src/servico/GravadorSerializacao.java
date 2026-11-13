package servico;

import modelo.Conta;

import java.io.*;
import java.util.ArrayList;

public class GravadorSerializacao implements Serializable {

    public static final String NOME = "salvar_dados.dat";

    public static void salvarContas(ArrayList<Conta> lista){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME))){
            oos.writeObject(lista);
            System.out.println("contas salvas em disco!!");
        }catch (IOException e){
            System.out.println("errro ao carregar arquivo: " +e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Conta> carregarContas(){

        File arquivo = new File(NOME);

        if(!arquivo.exists()){
            System.out.println("nenhum arquivo salvo!!");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME))){
            ArrayList<Conta> listaContas = (ArrayList<Conta>) ois.readObject();
            System.out.println("frota carregada com sucesso!!");
            return listaContas;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("erro ao ler: " +e.getMessage());
            return new ArrayList<>();
        }
    }
}
