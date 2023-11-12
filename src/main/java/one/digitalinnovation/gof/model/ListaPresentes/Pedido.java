package one.digitalinnovation.gof.model.ListaPresentes;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private Long pedido;

    private Long idCliente;

    private List<Presente> listaPresentes = new ArrayList<>();


    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<Presente> getPresentes() {
        return listaPresentes;
    }

    public void setPresentes(ListasPresentes listasPresentes){
        Presente presente = new Presente();
        System.out.println(listasPresentes.getIdProduto());
        presente.setIdProduto(listasPresentes.getIdProduto());
        presente.setPreco(listasPresentes.getPreco());
        presente.setQuantidade(listasPresentes.getQuantidade());
        this.listaPresentes.add(presente);
    }


}
