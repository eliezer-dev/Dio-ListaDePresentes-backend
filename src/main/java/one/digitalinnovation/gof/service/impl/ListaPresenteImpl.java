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
        //ArrayList<Object> listaPresente = new ArrayList<>();
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

//    @Override
//    public Iterable<Presente> buscarTodos() {
//        return listaPresenteRepository.findAll();
//    }

//    @Override
//    public List<List<ListaPresente>> buscarTodos() {
//        List<List<ListaPresente>> listaPresentesFinal = new ArrayList<>();
//        Iterable<ListaPresente> listaPresenteBd = listaPresenteRepository.findAll();
//        Set<Pedido> listaPedidos = new HashSet<>();
//        for (ListaPresente l : listaPresenteBd) {
//            Long pedido = l.getPedido();
//            listaPedidos.add(new Pedido(pedido));
//
//        }
//        System.out.println(listaPedidos);
//
//
//        listaPedidos.forEach(pedido -> {
//            List<ListaPresente> listaPresentePorPedido = new ArrayList<>();
//            listaPresenteBd.forEach(presente -> {
//
//                if (presente.getPedido().equals(pedido.getPedido())){
//                    listaPresentePorPedido.add(presente);
//                }
//            });
//            listaPresentesFinal.add(listaPresentePorPedido);
//        });
//        System.out.println(listaPresentesFinal);
//        return listaPresentesFinal;
//    }

    @Override
    public ProdutoPedido buscarPorId(Long idPedido) {
        return null;
    }


    @Override
    public void inserir(ProdutoPedido produtoPedido) {
        listaPresenteRepository.save(produtoPedido);
    }

    @Override
    public void atualizar(Long idPedido, ProdutoPedido produtoPedido) {

    }

    @Override
    public void deletar(Long idPedido) {

    }
}
