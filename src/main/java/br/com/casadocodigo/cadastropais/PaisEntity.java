package br.com.casadocodigo.cadastropais;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "país")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    @NotBlank
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    public PaisEntity() {
    }

    public PaisEntity(@NotBlank String nome) {
        Assert.hasLength(nome, "O nome do país é obrigatório!");
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Novo País: " +
                "\nId: " + id +
                "\nNome: " + nome;
    }
}
