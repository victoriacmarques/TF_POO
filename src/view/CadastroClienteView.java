package view;

import aplicacao.App;
import dados.Cliente;
import dados.Empresarial;
import dados.Individual;
import dados.Locacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class CadastroClienteView extends JPanel {
    private TreeSet<Cliente> clientes = new TreeSet<>();
    private Locacao locacao;
    private JTextField campoTexto1;
    private JTextField campoTexto2;
    private JButton botaoConfirma;
    private JButton botaoLimpa;
    private JButton botaoMostra;
    private JButton botaoFecha;
    private JTextArea area;
    private JTextField campoCPF;
    private JTextField campoAno;
    private JComboBox<String> comboBox;

    public CadastroClienteView(App app, Locacao locacao, Cliente cliente) {
        super();
        this.clientes = new TreeSet<>();
        this.locacao = locacao;

        GridLayout layout = new GridLayout(5, 2);
        this.setLayout(layout);
        JLabel dados = new JLabel("Digite os dados: ");
        JLabel lNome = new JLabel("Codigo");
        campoTexto1 = new JTextField(20);
        JLabel lId = new JLabel("Nome");
        campoTexto2 = new JTextField(20);

        JLabel tipoDeCliente = new JLabel("Tipo de Cliente");
        String[] tiposCliente = {"Individual", "Empresarial"};
        comboBox = new JComboBox<>(tiposCliente);

        JLabel lCPF = new JLabel("CPF");
        campoCPF = new JTextField(20);
        JLabel lAno = new JLabel("Ano");
        campoAno = new JTextField(20);
        campoCPF.setEnabled(true);
        campoAno.setEnabled(false);

        botaoConfirma = new JButton("Confirmar");
        botaoLimpa = new JButton("Limpar");
        botaoMostra = new JButton("Mostrar os dados");
        botaoFecha = new JButton("Fechar");

        JPanel painel = new JPanel();
        painel.add(dados);
        this.add(painel);
        JPanel painelUsuario = new JPanel(new GridLayout(4, 2));
        painelUsuario.add(lNome);
        painelUsuario.add(campoTexto1);
        painelUsuario.add(lId);
        painelUsuario.add(campoTexto2);
        painelUsuario.add(botaoConfirma);
        painelUsuario.add(botaoLimpa);
        painelUsuario.add(botaoMostra);
        painelUsuario.add(botaoFecha);
        add(painelUsuario);

        JPanel painelTipo = new JPanel(new GridLayout(4, 2));
        painelTipo.add(tipoDeCliente);
        painelTipo.add(comboBox);
        painelTipo.add(lCPF);
        painelTipo.add(campoCPF);
        painelTipo.add(lAno);
        painelTipo.add(campoAno);
        add(painelTipo);

        JPanel painelUsuario1 = new JPanel();
        area = new JTextArea(5, 50);
        painelUsuario1.add(area);
        add(painelUsuario1);

        botaoFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botaoLimpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoTexto1.setText("");
                campoTexto2.setText("");
            }
        });

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipoCliente = (String) comboBox.getSelectedItem();
                if (tipoCliente.equals("Individual")) {
                    campoCPF.setEnabled(true);
                    campoAno.setEnabled(false);
                    campoAno.setText("");
                } else if (tipoCliente.equals("Empresarial")) {
                    campoCPF.setEnabled(false);
                    campoAno.setEnabled(true);
                    campoCPF.setText("");
                }
            }
        });
        botaoConfirma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(campoTexto1.getText().trim());
                    String nome = campoTexto2.getText().trim();
                    String tipoCliente = (String) comboBox.getSelectedItem();

                    Cliente cliente = null;
                    if (tipoCliente.equals("Individual")) {
                        String cpf = campoCPF.getText().trim();
                        locacao.cadastrarCliente(new Individual(codigo,nome,cpf));
                    } else if (tipoCliente.equals("Empresarial")) {
                        int ano = Integer.parseInt(campoAno.getText().trim());
                        locacao.cadastrarCliente(new Empresarial(codigo,nome,ano));
                    } else {
                        area.setText("Erro ao cadastrar cliente");
                    }

                    if (cliente != null) {
                        locacao.cadastrarCliente(cliente);
                        area.setText("Cliente cadastrado com sucesso!");
                    }

                } catch (NumberFormatException ex) {
                    area.setText("Digite um código válido!");
                }
            }
        });
    }
}
