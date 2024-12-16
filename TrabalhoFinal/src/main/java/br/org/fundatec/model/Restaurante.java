package br.org.fundatec.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "restaurante_generator")
    @TableGenerator(name = "restaurante_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    public Restaurante(){
    }

    public Restaurante(String nome) {
        this.nome = nome;
    }

    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
