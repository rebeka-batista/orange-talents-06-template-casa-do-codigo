package br.com.casadocodigo.listadelivros;

import br.com.casadocodigo.novolivro.LivroEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivroDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal precoLivro;
    private Integer qtdPaginas;
    private String isbn;
    private LocalDate dataLancamento;
    private Long idCategoria;
    private Long idAutor;

    public DetalhesLivroDto(LivroEntity livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.precoLivro = livro.getPrecoLivro();
        this.qtdPaginas = livro.getQtdPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.idCategoria = livro.getIdCategoria();
        this.idAutor = livro.getIdAutor();
    }

    public Long getId() {
        return id;
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
