package aplicacao;

import view.CadastroRoboView;
import dados.Robo;
import dados.Domestico;
import dados.Industrial;
import dados.Agricola;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

public class ACMERobots extends JFrame {
    private TreeMap<Integer, Robo> robos = new TreeMap<>();

    public ACMERobots() {
        setTitle("ACMERobots - Sistema de Gerenciamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CadastroRoboView cadastroRoboView = new CadastroRoboView();
        add(cadastroRoboView);

        cadastroRoboView.getCadastrarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarRobo(cadastroRoboView);
            }
        });

        cadastroRoboView.getLimparButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos(cadastroRoboView);
            }
        });

        cadastroRoboView.getMostrarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDados(cadastroRoboView);
            }
        });

        cadastroRoboView.getFecharButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharAplicacao();
            }
        });

        cadastroRoboView.getTipoComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) cadastroRoboView.getTipoComboBox().getSelectedItem();
                if (tipo.equals("Doméstico")) {
                    cadastroRoboView.toggleFields(true, false, false);
                } else if (tipo.equals("Industrial")) {
                    cadastroRoboView.toggleFields(false, true, false);
                } else if (tipo.equals("Agrícola")) {
                    cadastroRoboView.toggleFields(false, false, true);
                } else {
                    cadastroRoboView.toggleFields(false, false, false);
                }
            }
        });

        setVisible(true);
    }

    private void cadastrarRobo(CadastroRoboView view) {
        try {
            int id = Integer.parseInt(view.getIdField().getText());
            String modelo = view.getModeloField().getText();
            double valorDiario = Double.parseDouble(view.getValorDiarioField().getText());

            if (robos.containsKey(id)) {
                view.getMessageArea().setText("Erro: Robô com este ID já existe.");
            } else {
                Robo novoRobo;
                String tipo = (String) view.getTipoComboBox().getSelectedItem();
                if (tipo.equals("Doméstico")) {
                    int nivel = Integer.parseInt(view.getNivelField().getText());
                    novoRobo = new Domestico(id, modelo, valorDiario, nivel);
                } else if (tipo.equals("Industrial")) {
                    String setor = view.getSetorField().getText();
                    novoRobo = new Industrial(id, modelo, valorDiario, setor);
                } else if (tipo.equals("Agrícola")) {
                    double area = Double.parseDouble(view.getAreaField().getText());
                    String uso = view.getUsoField().getText();
                    novoRobo = new Agricola(id, modelo, valorDiario, area, uso);
                } else {
                    view.getMessageArea().setText("Erro: Tipo de robô desconhecido.");
                    return;
                }
                robos.put(id, novoRobo);
                view.getMessageArea().setText("Robô " + tipo.toLowerCase() + " cadastrado com sucesso.\n" + novoRobo);

                // Limpa os campos de entrada após cadastrar o robô
                limparCampos(view);
                view.getCadastrarButton().setEnabled(false);  // Desativa o botão de cadastrar após limpar os campos
            }
        } catch (NumberFormatException ex) {
            view.getMessageArea().setText("Erro: Dados inválidos.");
        }
    }

    private void limparCampos(CadastroRoboView view) {
        view.getIdField().setText("");
        view.getModeloField().setText("");
        view.getValorDiarioField().setText("");
        view.getNivelField().setText("");
        view.getSetorField().setText("");
        view.getAreaField().setText("");
        view.getUsoField().setText("");
        view.getTipoComboBox().setSelectedIndex(0);
        view.toggleFields(false, false, false);
    }

    private void mostrarDados(CadastroRoboView view) {
        StringBuilder dados = new StringBuilder();
        for (Robo robo : robos.values()) {
            dados.append(getRoboType(robo)).append(": ").append(robo).append("\n");
        }
        view.getMessageArea().setText(dados.toString());
    }

    private String getRoboType(Robo robo) {
        if (robo instanceof Domestico) {
            return "Doméstico";
        } else if (robo instanceof Industrial) {
            return "Industrial";
        } else if (robo instanceof Agricola) {
            return "Agrícola";
        } else {
            return "Desconhecido";
        }
    }

    private void fecharAplicacao() {
        System.exit(0);
    }
}
