package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAbrirConta extends JFrame {


    private JLabel lblTitulo;
    private JLabel lblNumeroConta;
    private JTextField textNumeroConta;
    private JLabel lblNome;
    private JTextField textNome;
    private JLabel lblSaldoInicial;
    private JTextField textSaldoInicial;
    private JButton btnCadastro;

    public TelaAbrirConta(){

        setTitle("Sistema Banco Michael");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lblTitulo = new JLabel("Cadastro de cliente");
        lblTitulo.setBounds(110, 20, 120, 25);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(70,60,120,25);
        textNome = new JTextField();
        textNome.setBounds(180, 60, 150,25);

        lblNumeroConta = new JLabel("Numero da conta:");
        lblNumeroConta.setBounds(70, 90, 120,25);

        textNumeroConta = new JTextField();
        textNumeroConta.setBounds(180, 90 , 150,25);

        lblSaldoInicial = new JLabel("Saldo inicial:");
        lblSaldoInicial.setBounds(70, 120,120,25);

        textSaldoInicial = new JTextField();
        textSaldoInicial.setBounds(180,120,150,25);

        btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(95, 150,140,30);

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = textNome.getText().trim();
                String numeroConta = textNumeroConta.getText().trim();
                String saldoInicial = textSaldoInicial.getText().replace(",",".").trim();

                if(nome.isEmpty() || numeroConta.isEmpty() || saldoInicial.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio", "Aviso",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {

                    double saldo = Double.parseDouble(saldoInicial);

                    if(saldo < 0){
                        JOptionPane.showMessageDialog(null, "O saldo inicial não pode ser negativo.",
                                "Aviso", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    JOptionPane.showMessageDialog(null, "Usuario: " + nome + "\nConta: " + numeroConta +
                            "\nSaldo inicial: " + saldoInicial, "Cadastro realizado com sucesso!!", JOptionPane.INFORMATION_MESSAGE);

                    textNome.setText("");
                    textNumeroConta.setText("");
                    textSaldoInicial.setText("");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Digite um valor numérico válido no saldo.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(lblTitulo);
        add(lblNome);
        add(textNome);
        add(lblNumeroConta);
        add(textNumeroConta);
        add(lblSaldoInicial);
        add(lblSaldoInicial);
        add(textSaldoInicial);
        add(btnCadastro);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaAbrirConta().setVisible(true);
            }
        });
    }

}
