package view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CadastroRoboView extends JPanel {
    private JTextField idField, modeloField, valorDiarioField, nivelField, setorField, areaField, usoField;
    private JTextArea messageArea;
    private JButton cadastrarButton, limparButton, mostrarButton, fecharButton;
    private JLabel welcomeLabel;
    private JComboBox<String> tipoComboBox;

    public CadastroRoboView() {
        setLayout(new BorderLayout(10, 10));

        // Painel de Cadastro
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        fieldsPanel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        idField = new JTextField(20);
        fieldsPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        fieldsPanel.add(new JLabel("Modelo:"), gbc);

        gbc.gridx = 1;
        modeloField = new JTextField(20);
        fieldsPanel.add(modeloField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(new JLabel("Valor Diário:"), gbc);

        gbc.gridx = 1;
        valorDiarioField = new JTextField(20);
        fieldsPanel.add(valorDiarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        fieldsPanel.add(new JLabel("Tipo de Robô:"), gbc);

        gbc.gridx = 1;
        String[] tipos = {"Doméstico", "Industrial", "Agrícola"};
        tipoComboBox = new JComboBox<>(tipos);
        fieldsPanel.add(tipoComboBox, gbc);

        // Campos específicos de robôs
        gbc.gridx = 0;
        gbc.gridy = 4;
        fieldsPanel.add(new JLabel("Nível (Doméstico):"), gbc);

        gbc.gridx = 1;
        nivelField = new JTextField(20);
        fieldsPanel.add(nivelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        fieldsPanel.add(new JLabel("Setor (Industrial):"), gbc);

        gbc.gridx = 1;
        setorField = new JTextField(20);
        fieldsPanel.add(setorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        fieldsPanel.add(new JLabel("Área (Agrícola):"), gbc);

        gbc.gridx = 1;
        areaField = new JTextField(20);
        fieldsPanel.add(areaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        fieldsPanel.add(new JLabel("Uso (Agrícola):"), gbc);

        gbc.gridx = 1;
        usoField = new JTextField(20);
        fieldsPanel.add(usoField, gbc);

        add(fieldsPanel, BorderLayout.CENTER);

        // Label de boas-vindas
        welcomeLabel = new JLabel("Bem-vindo à página de cadastro de robôs.", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel, BorderLayout.NORTH);

        // Área de mensagem e exibição de dados
        messageArea = new JTextArea(10, 30);
        messageArea.setEditable(false);
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        add(messageScrollPane, BorderLayout.EAST);

        // Painel de botões
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setEnabled(false);  // Desativa o botão inicialmente
        buttonsPanel.add(cadastrarButton);

        limparButton = new JButton("Limpar");
        buttonsPanel.add(limparButton);

        mostrarButton = new JButton("Mostrar Dados");
        buttonsPanel.add(mostrarButton);

        fecharButton = new JButton("Fechar");
        buttonsPanel.add(fecharButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        // Esconde os campos específicos inicialmente
        toggleFields(false, false, false);

        // Adiciona DocumentListeners para habilitar o botão de cadastro
        addDocumentListeners();
    }

    // Getters para os componentes
    public JTextField getIdField() {
        return idField;
    }

    public JTextField getModeloField() {
        return modeloField;
    }

    public JTextField getValorDiarioField() {
        return valorDiarioField;
    }

    public JTextField getNivelField() {
        return nivelField;
    }

    public JTextField getSetorField() {
        return setorField;
    }

    public JTextField getAreaField() {
        return areaField;
    }

    public JTextField getUsoField() {
        return usoField;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JButton getLimparButton() {
        return limparButton;
    }

    public JButton getMostrarButton() {
        return mostrarButton;
    }

    public JButton getFecharButton() {
        return fecharButton;
    }

    public JComboBox<String> getTipoComboBox() {
        return tipoComboBox;
    }

    // Método para mostrar ou esconder os campos específicos
    public void toggleFields(boolean domestico, boolean industrial, boolean agricola) {
        nivelField.setVisible(domestico);
        setorField.setVisible(industrial);
        areaField.setVisible(agricola);
        usoField.setVisible(agricola);
        revalidate();
        repaint();
    }

    // Método para adicionar DocumentListeners
    private void addDocumentListeners() {
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkFields();
            }
        };

        idField.getDocument().addDocumentListener(listener);
        modeloField.getDocument().addDocumentListener(listener);
        valorDiarioField.getDocument().addDocumentListener(listener);
        nivelField.getDocument().addDocumentListener(listener);
        setorField.getDocument().addDocumentListener(listener);
        areaField.getDocument().addDocumentListener(listener);
        usoField.getDocument().addDocumentListener(listener);
    }

    // Método para verificar se todos os campos necessários estão preenchidos
    private void checkFields() {
        String tipo = (String) tipoComboBox.getSelectedItem();
        boolean allFilled = !idField.getText().isEmpty() && !modeloField.getText().isEmpty() && !valorDiarioField.getText().isEmpty();

        if (tipo.equals("Doméstico")) {
            allFilled &= !nivelField.getText().isEmpty();
        } else if (tipo.equals("Industrial")) {
            allFilled &= !setorField.getText().isEmpty();
        } else if (tipo.equals("Agrícola")) {
            allFilled &= !areaField.getText().isEmpty() && !usoField.getText().isEmpty();
        }

        cadastrarButton.setEnabled(allFilled);
    }
}
