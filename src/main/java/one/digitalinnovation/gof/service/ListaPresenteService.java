package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.ListaPresente;
import one.digitalinnovation.gof.model.ProdutoPedido;


public interface ListaPresenteService {
    ListaPresente buscarTodos();
    ListaPresente buscarPorPedido(Long pedido);

    void inserir(ProdutoPedido produtoPedido);
    void atualizar(Long pedido, ProdutoPedido produtoPedido);
    void deletar(Long pedido);
}
