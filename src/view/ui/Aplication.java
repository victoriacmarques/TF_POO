package view.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aplication extends JFrame implements ActionListener {
    private PanelOne panelOne;

    public Aplication() {
        panelOne = new PanelOne(this);
        panelOne.setLayout(new CardLayout());

        this.setContentPane(panelOne);
        this.setTitle("Cadastrar Locação");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(800,200);
        this.setVisible(true);
    }

    public void mudaPainel(String painel) {
        CardLayout layout = (CardLayout) panelOne.getLayout();
        layout.show(panelOne, painel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
