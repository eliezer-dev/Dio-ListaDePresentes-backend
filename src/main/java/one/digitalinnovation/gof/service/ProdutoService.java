package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Produto;

import javax.lang.model.type.NullType;

public interface ProdutoService {
    Iterable<Produto> buscarTodos();
    Produto buscarPorId(Long id);

    NullType buscarPorNome(String nome);
    void inserir(Produto produto);
    void atualizar(Long id, Produto produto);
    void deletar(Long id);


}
