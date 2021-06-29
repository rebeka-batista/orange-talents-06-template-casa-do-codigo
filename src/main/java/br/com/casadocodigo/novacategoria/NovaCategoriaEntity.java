package br.com.casadocodigo.novacategoria;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class NovaCategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
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
