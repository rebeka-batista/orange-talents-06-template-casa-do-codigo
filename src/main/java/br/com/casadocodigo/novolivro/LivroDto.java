package br.com.casadocodigo.novolivro;

import br.com.casadocodigo.novacategoria.NovaCategoriaEntity;
import br.com.casadocodigo.novoautor.AutorEntity;
import br.com.casadocodigo.validator.ExistsId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDto {

    @NotBlank
    @JsonProperty("titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    @JsonProperty("resumo")
    private String resumo;

    @NotBlank
    @JsonProperty("sumario")
    private String sumario;

    @NotNull
    @Min(20)
    @JsonProperty("preco_livro")
    private BigDecimal precoLivro;

    @NotNull
    @Min(100)
    @JsonProperty("quantidade_paginas")
    private Integer qtdPaginas;

    @NotBlank
    @JsonProperty("isbn")
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @FutureOrPresent
    @JsonProperty("data_lancamento")
    private LocalDate dataLancamento;

    @NotNull
    @ExistsId(domainClass = NovaCategoriaEntity.class, fieldName = "id")
    @JsonProperty("id_categoria")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = AutorEntity.class, fieldName = "id")
    @JsonProperty("id_autor")
    private Long idAutor;

    public LivroDto() {
    }

    public LivroDto(@NotBlank String titulo,
                    @NotBlank @Size(max = 500) String resumo,
                    @NotBlank String sumario,
                    @Min(20) BigDecimal precoLivro,
                    @Min(100) Integer qtdPaginas,
                    @NotBlank String isbn,
                    @NotNull Long idCategoria,
                    @NotNull Long idAutor) {


        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }


    public LivroEntity toModel() {
        return new LivroEntity(this.titulo, this.resumo, this.sumario, this.precoLivro, this.qtdPaginas,
                this.isbn, this.dataLancamento, this.idCategoria, this.idCategoria);
    }


    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
