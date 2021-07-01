package br.com.casadocodigo.novacategoria;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class NovaCategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    public NovaCategoriaEntity() {
    }

    public NovaCategoriaEntity(@NotBlank String nome) {
        Assert.hasLength(nome, "O nome da categoria é obrigatório!");
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nova Categoria: " +
                "\nId: " + id +
                "\nNome: " + nome;
    }

}
