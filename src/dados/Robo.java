package dados;

public abstract class Robo {
    private int id;
    private String modelo;
    private double valorDiario;
    private boolean status;

    public Robo(int id, String modelo, double valorDiario) {
        this.id = id;
        this.modelo = modelo;
        this.valorDiario = valorDiario;
        this.status = true;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean getStatus() {return status;}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public abstract double calculaLocacao(int dias);

    @Override
    public String toString() {
        return "ID: " + id + ", Modelo: " + modelo + ", Valor Diário: " + valorDiario;
    }
}