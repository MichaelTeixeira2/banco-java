package visao.CadastroCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectStreamException;

public class Cadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtCpf;
    private JComboBox<String> cbTipos;
    private JButton butCadastro;
    private JButton butRemover;

    private DefaultTableModel modeloContas;
    private JTable listaContas;

    public Cadastro(){

        setTitle("Cadastro de cliente");
        setLocationRelativeTo(null);
        setSize(700,550);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel painelCadastro = new JPanel(new FlowLayout(FlowLayout.LEFT));

        painelCadastro.add(new JLabel("Nome:"));
        txtNome = new JTextField(12);
        painelCadastro.add(txtNome);

        painelCadastro.add(new JLabel("CPF:"));
        txtCpf = new JTextField(12);
        painelCadastro.add(txtCpf);

        String[] tipos = {"Conta corrente", "Conta poupança","Conta Salário"};
        cbTipos = new JComboBox<>(tipos);
        painelCadastro.add(cbTipos);

        butCadastro = new JButton("Cadastrar");
        painelCadastro.add(butCadastro);

        butRemover = new JButton("Remover conta");
        painelCadastro.add(butRemover);

        add(painelCadastro, BorderLayout.NORTH);

        Object[] texto = {"Nome","Cpf","Tipo de conta"};
        modeloContas = new DefaultTableModel(texto,0);
        listaContas = new JTable(modeloContas);
        painelCadastro.add(listaContas);

        add(listaContas, BorderLayout.CENTER);

        JScrollPane scrollTela = new JScrollPane(listaContas);

        add(scrollTela,BorderLayout.CENTER);

        butCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String cpf = txtCpf.getText().trim();
                Object tipo = cbTipos.getSelectedItem();

                if(nome.isEmpty() || cpf.isEmpty()){
                    JOptionPane.showMessageDialog(Cadastro.this, "Nenhum campo pode estar vazio",
                            "AVISO", JOptionPane.WARNING_MESSAGE);
                }else{
                    if(tipo.equals("Conta corrente")){
                        Object[] tipos = {nome,cpf,tipo};
                        modeloContas.addRow(tipos);
                    } else if(tipo.equals("Conta Poupança")){
                        Object[] tipos = {nome,cpf,tipo};
                        modeloContas.addRow(tipos);
                    }else{
                        Object[] tipos = {nome,cpf,tipo};
                        modeloContas.addRow(tipos);
                    }

                    txtCpf.setText("");
                    txtNome.setText("");
                    txtNome.requestFocus();

                }
            }
        });

        butRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linha = listaContas.getSelectedRow();

                if(linha != -1){
                    modeloContas.removeRow(linha);
                }
                else{
                    JOptionPane.showMessageDialog(Cadastro.this, "Nenhum linha selecionada",
                            "AVISO", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

}