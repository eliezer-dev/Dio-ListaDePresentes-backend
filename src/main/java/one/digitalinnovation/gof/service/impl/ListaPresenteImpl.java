package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.service.ListaPresenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ListaPresenteImpl implements ListaPresenteService {

    @Autowired
    private PresenteRepository listaPresenteRepository;


    @Override
    public ListaPresente buscarTodos(){
        Iterable<ProdutoPedido> listaComTodososPedidos = listaPresenteRepository.findAll();
        ListaPresente listaPresente = new ListaPresente();
        Set<Long>listaComNumeroPedidosUnicos = new HashSet<>();
        listaComTodososPedidos.forEach(p -> {
            listaComNumeroPedidosUnicos.add(p.getPedido());
        });
       listaComNumeroPedidosUnicos.forEach(n -> {
           Pedido pedido = new Pedido();
           listaComTodososPedidos.forEach(p -> {

               if (p.getPedido().equals(n)){
                   pedido.setPedido(p.getPedido());
                   pedido.setIdCliente(p.getIdCliente());
                   pedido.setPresentes(p);
               }

           });
           listaPresente.setPedido(pedido);
       });

        return listaPresente;
    }

    @Override
    public ListaPresente buscarPorPedido(Long pedido) {
        Iterable<ProdutoPedido> listaComTodososPedidos = listaPresenteRepository.findAll();
        ListaPresente listaPresente = new ListaPresente();
        Pedido pedidoformatado = new Pedido();
        listaComTodososPedidos.forEach(p -> {
            if (p.getPedido().equals(pedido)){
                pedidoformatado.setPedido(p.getPedido());
                pedidoformatado.setIdCliente(p.getIdCliente());
                pedidoformatado.setPresentes(p);
            }
        });
        listaPresente.setPedido(pedidoformatado);
        return listaPresente;
    }


    @Override
    public void inserir(ProdutoPedido produtoPedido) {
        listaPresenteRepository.save(produtoPedido);
    }

    @Override
    public void atualizar(Long pedido, ProdutoPedido produtoPedido) {

    }

    @Override
    public void deletar(Long pedido) {
        Iterable<ProdutoPedido> listaComTodososPedidos = listaPresenteRepository.findAll();
        listaComTodososPedidos.forEach(p -> {
            if (p.getPedido().equals(pedido)){
                listaPresenteRepository.deleteById(p.getId());
            }
        });
    }

    private ListaPresente obterListaPresente(){
        return null;
    }

}
