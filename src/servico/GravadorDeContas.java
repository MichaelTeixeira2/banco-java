package servico;

import excecoes.PersistenciaException;
import modelo.Conta;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GravadorDeContas {

    public static final String ARQUIVO = "conta_salva.txt";

    public static void salvar(ArrayList<Conta> contas) throws PersistenciaException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))){
            String linha;

            for(Conta c : contas){
                linha = c.getNumero()+ ";" +c.getTitular()+ ";" +c.getSaldo();

                bw.write(linha);
                bw.newLine();
            }

        } catch (IOException e) {
            throw new PersistenciaException("Erro ao salvar contas: " +e.getMessage());
        }

    }

}
