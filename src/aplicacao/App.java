package aplicacao;

import dados.*;
import view.*;

import javax.swing.*;

public class App extends JFrame {
    private Cliente cliente;
    private Robo robo;
    private App app;
    private Locacao locacao;
    private InicioView inicioView;
    private CadastroRoboView cadastroRoboView;;

    public App() {
        super();
        this.cliente = cliente;
        this.robo = robo;
        this.locacao = locacao;
        inicioView = new InicioView(this,robo);
        cadastroRoboView = new CadastroRoboView();
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
            case 2:
                this.setContentPane(cadastroRoboView);
                this.pack();
                this.setSize(800,600);
                break;
        }
    }
}
