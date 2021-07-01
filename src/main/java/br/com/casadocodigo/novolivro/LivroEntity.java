package br.com.casadocodigo.novolivro;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @NotBlank
    @Length(max = 500)
    @Column(name = "resumo", nullable = false, length = 500)
    private String resumo;

    @NotBlank
    @Column(name = "sumario", nullable = false)
    private String sumario;

    @NotNull
    @Min(20)
    @Column(name = "preco_livro", nullable = false)
    private BigDecimal precoLivro;

    @NotNull
    @Min(100)
    @Column(name = "quantidade_paginas", nullable = false)
    private Integer qtdPaginas;

    @NotBlank
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @FutureOrPresent
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @NotNull
    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @NotNull
    @Column(name = "id_autor", nullable = false)
    private Long idAutor;


    public LivroEntity() {
    }

    public LivroEntity(@NotBlank String titulo,
                       @NotBlank @Length(max = 500) String resumo,
                       @NotBlank String sumario,
                       @Min(20) BigDecimal precoLivro,
                       @Min(100) Integer qtdPaginas,
                       @NotBlank String isbn,
                       @DateTimeFormat(pattern = "dd/MM/yyy") LocalDate dataLancamento,
                       @NotBlank Long idCategoria,
                       @NotBlank Long idAutor) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }


    @Override
    public String toString() {
        return "Novo livro: " +
                "\nId: " + id +
                ", \nTitulo: " + titulo +
                ", \nResumo: " + resumo +
                ", \nSumario: " + sumario +
                ", \nPreço do Livro: " + precoLivro +
                ", \nQuantidade de páginas: " + qtdPaginas +
                ", \nIsbn: " + isbn +
                ", \nData de Lancamento: " + dataLancamento +
                ", \nId da Categoria: " + idCategoria +
                ", \nId do Autor: " + idAutor;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
}
