package br.org.fundatec.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "funcionario_generator")
    @TableGenerator(name = "funcionario_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    public Funcionario(){
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario(Integer id, String nome) {
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
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
