package br.com.casadocodigo.compra;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotBlank
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @NotNull
    @Column(name = "documento", nullable = false)
    private Long documento;

    @NotBlank
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @NotBlank
    @Column(name = "complemento", nullable = false)
    private String complemento;

    @NotBlank
    @Column(name = "cidade", nullable = false)
    private String cidade;

    @NotNull
    @Column(name = "id_estado", nullable = false)
    private Long estado;

    @NotNull
    @Column(name = "id_pais", nullable = false)
    private Long pais;

    @NotNull
    @Column(name = "telefone", nullable = false)
    private Long telefone;

    @NotNull
    @Column(name = "cep", nullable = false)
    private Integer cep;

    public CompraEntity(@NotBlank String nome, @NotBlank String sobrenome,
                        @NotNull Long documento, @NotBlank String endereco,
                        @NotBlank String complemento, @NotBlank String cidade,
                        @NotNull Long idEstado, @NotNull Long idPais,
                        @NotNull Long telefone, @NotNull Integer cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = idEstado;
        this.pais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Compra: " +
                "\nId: " + id +
                ",\nNome: " + nome +
                ",\nSobrenome: " + sobrenome +
                ",\nDocumento: " + documento +
                ",\nEndereco: " + endereco +
                ",\nComplemento: " + complemento +
                ",\nCidade: " + cidade +
                ",\nId do Estado: " + estado +
                ",\nId do País: " + pais +
                ",\nTelefone: " + telefone +
                ",\nCep: " + cep;
    }

    public CompraEntity() {
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Long getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getEstado() {
        return estado;
    }

    public Long getPais() {
        return pais;
    }

    public Long getTelefone() {
        return telefone;
    }

    public Integer getCep() {
        return cep;
    }
}
