package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.ListaPresentes.ListaDePedidos;
import one.digitalinnovation.gof.model.ListaPresentes.ListasPresentes;


public interface ListaPresenteService {
    ListaDePedidos buscarTodos();
    ListaDePedidos buscarPorPedido(Long pedido);

    void inserir(ListasPresentes listasPresentes);
    void atualizar(Long pedido, ListasPresentes listasPresentes);
    void deletar(Long pedido);
}
