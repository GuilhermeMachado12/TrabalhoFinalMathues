package br.org.fundatec.model;

public class VotoPorRestaurante {

    private String restaurantes;
    private Long voto;

    public VotoPorRestaurante(String restaurantes, Long voto) {
        this.restaurantes = restaurantes;
        this.voto = voto;
    }

    public String getRestaurantes() {
        return restaurantes;
    }

    public Long getVoto() {
        return voto;
    }

    @Override
    public String toString() {
        return "VotoPorRestaurante{" +
                "restaurantes='" + restaurantes + '\'' +
                ", voto=" + voto +
                '}';
    }
}
