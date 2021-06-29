package br.com.casadocodigo.novacategoria;

import br.com.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDto {

    @NotBlank
    @UniqueValue(domainClass = NovaCategoriaEntity.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
