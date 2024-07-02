package view;

import aplicacao.App;
import dados.Cliente;
import dados.Locacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class CadastroClienteView2 extends JPanel {
    private TreeSet<Cliente> clientes = new TreeSet<>();
    private Cliente cliente;
    private JButton voltaButton;
    private JButton fecharButton;
    private JLabel clientesCad;
    private Locacao locacao;
    private JTextArea areaTexto;
    private JTextArea area;

    public CadastroClienteView2(App app, Cliente cliente, Locacao locacao) {
        super();
        clientes = new TreeSet<>();
        this.locacao = locacao;

        setLayout(new BorderLayout());
        JLabel clientesCad = new JLabel("Clientes cadastrados: ");
        JPanel painelTitulo = new JPanel();
        painelTitulo.add(clientesCad);
        voltaButton = new JButton("Voltar");
        fecharButton = new JButton("Fechar");
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(voltaButton);
        painelBotoes.add(fecharButton);

        JPanel painelUsuario2 = new JPanel();
        areaTexto = new JTextArea(5, 50);
        painelUsuario2.add(areaTexto);

        add(painelTitulo, BorderLayout.NORTH);
        add(areaTexto, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        voltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });

        fecharButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void listarclientes() {
        StringBuilder sb = new StringBuilder();
        TreeSet<Cliente> clientesListados = locacao.getClientes();

        if (clientesListados.isEmpty()) {
            areaTexto.setText("Nenhum cliente encontrado!");
        } else {
            for (Cliente c : clientesListados) {
                sb.append(c.toString()).append("\n");
            }
            areaTexto.setText(sb.toString());
        }
    }
}