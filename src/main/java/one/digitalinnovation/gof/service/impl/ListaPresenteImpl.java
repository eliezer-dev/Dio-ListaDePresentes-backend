package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.ListaPresentes.ListaDePedidos;
import one.digitalinnovation.gof.model.ListaPresentes.ListasPresentes;
import one.digitalinnovation.gof.model.ListaPresentes.ListasPresentesRepository;
import one.digitalinnovation.gof.model.ListaPresentes.Pedido;
import one.digitalinnovation.gof.service.ListaPresenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ListaPresenteImpl implements ListaPresenteService {

    @Autowired
    private ListasPresentesRepository listaPresentesRepository;


    @Override
    public ListaDePedidos buscarTodos(){
        Iterable<ListasPresentes> listaComTodososPedidos = listaPresentesRepository.findAll();
        ListaDePedidos listaDePedidos = new ListaDePedidos();

        Set<Long>listaComTodosNumerosPedidosUnicos = new HashSet<>();
        listaComTodososPedidos.forEach(p -> {
            listaComTodosNumerosPedidosUnicos.add(p.getPedido());
        });

        listaComTodosNumerosPedidosUnicos.forEach(pedidoProcurado -> {
           salvaPedidoProcuradoNaListaDePedidos(pedidoProcurado, listaDePedidos);
       });
        return listaDePedidos;
    }

    @Override
    public ListaDePedidos buscarPorPedido(Long pedidoProcurado) {
        ListaDePedidos listaDePedidos = new ListaDePedidos();
        salvaPedidoProcuradoNaListaDePedidos(pedidoProcurado, listaDePedidos);
        return listaDePedidos;
    }


    @Override
    public void inserir(ListasPresentes listasPresentes) {
        listaPresentesRepository.save(listasPresentes);
    }

    @Override
    public void atualizar(Long pedido, ListasPresentes listasPresentes) {

    }

    @Override
    public void deletar(Long pedido) {
        Iterable<ListasPresentes> listaComTodososPedidos = listaPresentesRepository.findAll();
        listaComTodososPedidos.forEach(p -> {
            if (p.getPedido().equals(pedido)){
                listaPresentesRepository.deleteById(p.getId());
            }
        });
    }

    private void salvaPedidoProcuradoNaListaDePedidos(Long pedidoProcurado, ListaDePedidos listaDePedidos){
        Iterable<ListasPresentes> listaComTodososPedidos = listaPresentesRepository.findAll();
        Pedido pedidoFormatado = new Pedido();
        listaComTodososPedidos.forEach(p -> {

            if (p.getPedido().equals(pedidoProcurado)){
                pedidoFormatado.setPedido(p.getPedido());
                pedidoFormatado.setIdCliente(p.getIdCliente());
                pedidoFormatado.setPresentes(p);
            }

        });
        listaDePedidos.setPedido(pedidoFormatado);
    }

}
