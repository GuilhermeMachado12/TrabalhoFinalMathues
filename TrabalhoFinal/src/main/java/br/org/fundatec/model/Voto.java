package br.org.fundatec.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "Voto")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "voto_generator")
    @TableGenerator(name = "voto_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column
    @Temporal(TemporalType.DATE)
    private Calendar data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }


    public Voto() {
    }

    public Voto(Calendar data, Funcionario funcionario, Restaurante restaurante) {
        this.data = data;
        this.funcionario = funcionario;
        this.restaurante = restaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id) && Objects.equals(data, voto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}


