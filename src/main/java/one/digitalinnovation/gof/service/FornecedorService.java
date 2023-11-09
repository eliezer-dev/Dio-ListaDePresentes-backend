package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Fornecedor;

public interface FornecedorService {
    Iterable<Fornecedor> buscarTodos();
    Fornecedor buscarPorId(Long id);
    void inserir(Fornecedor fornecedor);
    void atualizar(Long id, Fornecedor fornecedor);
    void deletar(Long id);

}
