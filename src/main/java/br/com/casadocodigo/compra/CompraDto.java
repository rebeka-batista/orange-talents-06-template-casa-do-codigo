package br.com.casadocodigo.compra;

import br.com.casadocodigo.cadastroestado.EstadoEntity;
import br.com.casadocodigo.cadastropais.PaisEntity;
import br.com.casadocodigo.validator.ExistsId;
import br.com.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompraDto {

    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @NotBlank
    @JsonProperty("sobrenome")
    private String sobrenome;

    @NotNull
    @JsonProperty("documento")
    @UniqueValue(domainClass = CompraEntity.class, fieldName = "documento")
    private Long documento;

    @NotBlank
    @JsonProperty("endereco")
    private String endereco;

    @NotBlank
    @JsonProperty("complemento")
    private String complemento;

    @NotBlank
    @JsonProperty("cidade")
    private String cidade;

    @NotNull
    @JsonProperty("id_estado")
    @ExistsId(domainClass = EstadoEntity.class, fieldName = "id")
    private Long estado;

    @NotNull
    @JsonProperty("id_pais")
    @ExistsId(domainClass = PaisEntity.class, fieldName = "id")
    private Long pais;

    @NotNull
    @JsonProperty("telefone")
    private Long telefone;

    @NotNull
    @JsonProperty("cep")
    private Integer cep;

    public CompraDto(CompraEntity compra) {
        this.nome = compra.getNome();
        this.sobrenome = compra.getSobrenome();
        this.documento = compra.getDocumento();
        this.endereco = compra.getEndereco();
        this.complemento = compra.getComplemento();
        this.cidade = compra.getCidade();
        this.estado = compra.getEstado();
        this.pais = compra.getPais();
        this.telefone = compra.getTelefone();
        this.cep = compra.getCep();
    }

    public CompraEntity toModel() {
        return new CompraEntity(this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, this.estado, this.pais, this.telefone, this.cep);
    }

    public CompraDto() {
    }

}
