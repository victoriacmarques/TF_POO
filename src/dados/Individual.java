package dados;

import java.awt.*;
import java.util.ArrayList;

public class Individual extends Cliente{
    private String cpf;
    private ArrayList<Robo> robos;

    public Individual(int codigo,String nome, String cpf) {
        super(codigo,nome);
        this.cpf = cpf;
        robos = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double calculaDesconto(){
        if (robos.size()>1){
            return 0.95;}
            else {
                return 0;
            }
        }
    }


