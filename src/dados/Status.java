package dados;

public enum Status {
    CADASTRADA("Cadastrada"),

    EXECUTANDO("Executando"),

    FINALIZADA("Finalizada"),

    CANCELADA("Cancelada");

    private String nome;

    private Status(String nome) {
        this.nome = nome;
    }
}
