package view;
import aplicacao.App;
import dados.Robo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioView extends JPanel{
    private Robo robo;
    private App app;
    private JButton botaoCliente;
    private JButton botaoRobo;
    private JButton botaoLocacao;
    private JButton botaoSair;

    public InicioView(App app, Robo robo) {
        super();
        botaoCliente = new JButton("Cadastrar Cliente");
        botaoRobo = new JButton("Cadastrar Robo");
        botaoLocacao = new JButton("Cadastrar Locacao");
        botaoSair = new JButton("Sair");
        GridLayout layout = new GridLayout(6,2);
        JPanel painelInicio = new JPanel();
        setLayout(layout);
        add(botaoCliente);
        add(botaoRobo);
        add(botaoLocacao);
        add(botaoSair);
        this.add(painelInicio);
        this.setSize(800, 600);
        this.setVisible(true);

        botaoRobo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(2);
            }
        });
    }


}

