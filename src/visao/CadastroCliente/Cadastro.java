package visao.CadastroCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame {

    private JTextField textNome;
    private JTextField textCpf;
    private JButton butCadastro;
    private JComboBox cbTipo;

    private DefaultListModel<String> modeloLista;
    private JList<String> listaContas;

    public Cadastro(){

        setTitle("Cadastro de cliente");
        setSize(750,620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        setLocationRelativeTo(null);

        JPanel painelDeEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));

        painelDeEntrada.add(new JLabel("Nome:"));
        textNome= new JTextField(12);
        painelDeEntrada.add(textNome);

        painelDeEntrada.add(new JLabel("Cpf:"));
        textCpf= new JTextField(12);
        painelDeEntrada.add(textCpf);

        painelDeEntrada.add(new JLabel("Tipo de conta: "));
        String[] tipos = {"Corrente", "Poupança", "Salário"};
        cbTipo = new JComboBox<>(tipos);
        painelDeEntrada.add(cbTipo);

        butCadastro = new JButton("Cadastrar");
        painelDeEntrada.add(butCadastro);

        add(painelDeEntrada, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaContas = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaContas);

        add(scrollLista, BorderLayout.CENTER);


        butCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText().trim();
                String cpf = textCpf.getText().trim();
                String tipo = (String) cbTipo.getSelectedItem();

                if(nome.isEmpty() || cpf.isEmpty()){
                    JOptionPane.showMessageDialog(Cadastro.this, "Nenhum campo pode estar vazio!!",
                            "AVISO",JOptionPane.WARNING_MESSAGE);
                }else{
                    String cadastro = nome+ " - " +cpf+ " - " +tipo;
                    modeloLista.addElement(cadastro);
                    textNome.setText("");
                    textCpf.setText("");
                    textNome.requestFocus();
                    textCpf.requestFocus();
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

}
