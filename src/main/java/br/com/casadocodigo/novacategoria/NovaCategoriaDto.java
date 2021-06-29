package br.com.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDto {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
