package view;

import dados.*;

import java.util.ArrayList;
import java.util.TreeSet;

public class Relatorio {
    public ArrayList<Robo> robos;
    public TreeSet<Cliente> clientes;
    public ArrayList<Locacao> locacoes;

    public Relatorio(ArrayList<Robo> robos, TreeSet<Cliente> clientes, ArrayList<Locacao> locacoes) {
        robos = new ArrayList<>();
        clientes = new TreeSet<>();
        locacoes = new ArrayList<>();
    }

    public void mostrarRelatorio() {
        if (robos.isEmpty() && clientes.isEmpty() && locacoes.isEmpty()) {
            System.out.println("Não existem dados no sistema");
        } else {
            for (Robo robo : robos) {
                System.out.println(robo.toString());
            }
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
            for (Locacao locacao : locacoes) {
                System.out.println(locacao.toString());

                if (!locacao.getRobos().isEmpty()){
                    for (Robo robo : locacao.getRobos()) {
                        System.out.println(robo.toString());
                    }
                }
                //Valor final

            }


        }
    }
}
