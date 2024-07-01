package view.ui;

import dados.Cliente;
import dados.Lists;
import dados.Robo;
import view.ui.Aplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PanelOne extends JPanel implements ActionListener {
    private Aplication app;

    Lists lists = new Lists();
    private List<Cliente> clients;
    private List<Robo> robots;
    private ArrayList<Robo> checkedRobots = new ArrayList<>();

    private JLabel selectLabel;
    private JComboBox<String> comboBox1;
    private JLabel checkLabel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JButton button1;

    public PanelOne(Aplication app) {
        super();
        this.app=app;
//        Cliente client1 = new Cliente("Jorge");
//        Cliente client2 = new Cliente("Osvaldo");
//        Cliente client3 = new Cliente("João");
//        Robo robot1 = new Robo("T800", 200.00);
//        Robo robot2 = new Robo("C908", 300.00);
//        Robo robot3 = new Robo("A500", 600.00);

//        lists.addClient(client1, client2, client3);
//        lists.addRobot(robot1, robot2, robot3);
//        clients = lists.getClients();
//        robots = lists.getRobots();
        setLayout(new BorderLayout());
        selectLabel = new JLabel("Selecione um cliente para a locação:");
        comboBox1 = new JComboBox<String>();
        comboBox1.addItem("Selecione um cliente");
        for (Cliente client : clients) {
//            comboBox1.addItem(client.getName());
        }
        JPanel centerPanel = new JPanel(new GridLayout(7,2));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(selectLabel);
        centerPanel.add(comboBox1);
        checkLabel = new JLabel("Selecione os robos no qual o cliente deseja locar:");
        centerPanel.add(checkLabel);
        for( int i=0; i<robots.size(); i++ ) {
            Robo robot = robots.get(i);
            if(i==0) {
//                checkBox1 = new JCheckBox(robot.getType());
                centerPanel.add(checkBox1);
            }else if(i==1) {
//                checkBox2 = new JCheckBox(robot.getType());
                centerPanel.add(checkBox2);
            }else if(i==2) {
//                checkBox3 = new JCheckBox(robot.getType());
                centerPanel.add(checkBox3);
            }
        }
        button1 = new JButton("Confirmar locação");
        centerPanel.add(button1);

        button1.addActionListener(this);
        checkBox1.addActionListener(this);
        checkBox2.addActionListener(this);
        checkBox3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBox1) {
            if (checkBox1.isSelected()) {
                checkedRobots.add(robots.getFirst());
//                System.out.println("checkbox 1 esta selecionada, robo: "+robots.getFirst().getType()+" ,robo na lista: "+ checkedRobots.contains(robots.getFirst()));
            }else{
                checkedRobots.remove(robots.getFirst());
//                System.out.println("checkbox 1 foi desselecionada, robo: "+robots.getFirst().getType()+" ,robo na lista: "+ checkedRobots.contains(robots.getFirst()));
            }
        }

        if (e.getSource() == checkBox2) {
            if (checkBox2.isSelected()) {
                checkedRobots.add(robots.get(1));
//                System.out.println("checkbox 2 esta selecionada, robo: "+robots.get(1).getType()+" ,robo na lista: "+ checkedRobots.contains(robots.get(1)));
            }else{
                checkedRobots.remove(robots.get(1));
//                System.out.println("checkbox 2 foi desselecionada, robo: "+robots.get(1).getType()+" ,robo na lista: "+ checkedRobots.contains(robots.get(1)));
            }
        }

        if (e.getSource() == checkBox3) {
            if (checkBox3.isSelected()) {
                checkedRobots.add(robots.get(2));
//                System.out.println("checkbox 3 esta selecionada, robo: "+robots.get(2).getType()+" ,robo na lista: "+ checkedRobots.contains(robots.get(2)));
            }else{
                checkedRobots.remove(robots.get(2));
//                System.out.println("checkbox 3 foi desselecionada, robo: "+robots.get(2).getType()+" ,robo na lista: "+ checkedRobots.contains(robots.get(2)));
            }
        }

            if (e.getSource() == button1) {
                String selectedClient = (String) comboBox1.getSelectedItem();
                if (checkedRobots.size() !=0 & !selectedClient.equals("Selecione um cliente")) {
//                    Rental rental = new Rental(lists.getByName(selectedClient), checkedRobots);
                    String message;
//                    message = "Locação concluída com sucesso!"+"\n"+"\n"+"Data da locação: "+rental.getRentDate()+"\n"+"Cliente:\n" + selectedClient + "\n"+ "Robos locados: " + "\n";
                    for (Robo robot : checkedRobots) {
//                        message += robot.getType()+"\n";
                    }
//                    System.out.println(message);
//                    showModal(message);
                } else if(checkedRobots.size()==0 & selectedClient.equals("Selecione um cliente")) {
                    showModal("Formulário não preenchido!");
                }else if(checkedRobots.size()==0) {
                    showModal("Nenhum robo selecionado!");
                } else if (selectedClient.equals("Selecione um cliente")) {
                    showModal("Nenhum cliente selecionado!");
                }
            }
    }

    private void showModal(String message) {
        JOptionPane messagePane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);

        JDialog dialog = new JDialog(app, message, true);
        dialog.setContentPane(messagePane);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

}
