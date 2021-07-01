package br.com.casadocodigo.novoautor;

import br.com.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = AutorEntity.class, fieldName = "email")
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(max = 400)
    @JsonProperty("descricao")
    private String descricao;

    public NovoAutorDto(@NotBlank String nome,
                        @NotBlank @Email String email,
                        @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorEntity toModel() {
        return new AutorEntity(this.nome, this.email, this.descricao);
    }

    public NovoAutorDto() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

}

