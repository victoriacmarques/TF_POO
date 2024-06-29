package dados;

public class Industrial extends Robo {
    private String setor;

    public Industrial(int id, String modelo, double valorDiario, String setor) {
        super(id, modelo, valorDiario);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public double calculaLocacao(int dias) {
        return dias * getValorDiario();
    }

    @Override
    public String toString() {
        return super.toString() + ", Setor: " + setor;
    }
}
