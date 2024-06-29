package dados;

import java.awt.*;
import java.util.ArrayList;

public class Empresarial extends Cliente {
    private int ano;
    private ArrayList<Robot> robos;

    public Empresarial(int codigo,String nome, int ano) {
        super(codigo,nome);
        this.ano = ano;
        robos = new ArrayList<>();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double calculaDesconto(){
        if (robos.size()>=2 && robos.size()<=9){
            return 0.97;}
        else if (robos.size()>10){
            return 0.93;
        } else {
            return 0;
        }

    }
}
