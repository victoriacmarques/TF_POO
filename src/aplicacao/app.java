package aplicacao;

import dados.*;
import view.*;

import javax.swing.*;

public class app extends JFrame {
    private Cliente cliente;
    private Robo robo;
    private Locacao locacao;
    private InicioView inicioView;

    public app() {
        super();
        this.cliente = cliente;
        this.robo = robo;
        this.locacao = locacao;
        InicioView inicioView = new InicioView();
        this.setContentPane(inicioView);
        this.setTitle("ACMERobots - Sistema de Gerenciamento");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(800,600);
        this.setVisible(true);
    }

    public void mudaPainel(int painel){
        switch (painel){
            case 1:
                this.setContentPane(inicioView);
                this.pack();
                this.setSize(800,600);
                break;
        }
    }
}
