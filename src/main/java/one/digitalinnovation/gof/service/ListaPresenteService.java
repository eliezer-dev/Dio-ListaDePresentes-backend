package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.ListaPresente;
import one.digitalinnovation.gof.model.ProdutoPedido;


public interface ListaPresenteService {
    ListaPresente buscarTodos();
    ProdutoPedido buscarPorId(Long Id);

    void inserir(ProdutoPedido produtoPedido);
    void atualizar(Long idPedido, ProdutoPedido produtoPedido);
    void deletar(Long idPedido);
}
