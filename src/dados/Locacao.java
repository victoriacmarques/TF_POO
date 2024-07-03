package dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public class Locacao {
    private int numero;
    private Status situacao;
    private Date dataInicio;
    private int dataFim;
    private ArrayList<Robo> robos;
    private TreeSet<Cliente> clientes;
    private ArrayList<Locacao> locacoes;

    public Locacao(int numero, Status situacao, Date dataInicio, int dataFim) {
        this.numero = numero;
        this.situacao = situacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        robos = new ArrayList<>();
        clientes = new TreeSet<>();
        locacoes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Status getSituacao() {
        return situacao;
    }

    public void setSituacao(Status situacao) {
        this.situacao = situacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setData(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }

    public double calculaValorFinal(Date dataInicio, int dataFim) {
        double diasLocacao = dataFim - dataInicio.getTime();
        double valorLocacao = 0;

        for (Robo robo : robos) {
            valorLocacao += robo.getValorDiario() * diasLocacao;
        }

        return valorLocacao;
    }

    public ArrayList<Robo> getRobos() {
        return robos;
    }

    public boolean cadastrarRobo(Robo robo) {
        for (Robo r : robos) {
            if (r.getId()==robo.getId()) {
                return false;
            }
        }robos.add(robo);
        return true;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getCodigo()==cliente.getCodigo()) {
                return false;
            }
        }clientes.add(cliente);
        return true;
    }

    public TreeSet<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Locacao> consultarLocacoes(){
        ArrayList<Locacao> locacoesConsultadas = new ArrayList<>();
        if (locacoes.isEmpty()){
            return null;
        }else{
            for (Locacao locacao : locacoes){
                locacoesConsultadas.add(locacao);
                if (!locacao.getRobos().isEmpty()){
                    for (Robo robo : locacao.getRobos()){
                        robo.toString();
                    }
                }
            }
        }return locacoesConsultadas;
    }


    @Override
    public String toString() {
        return "Locacao{" +
                "numero=" + numero +
                ", situacao=" + situacao +
                ", data=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}
