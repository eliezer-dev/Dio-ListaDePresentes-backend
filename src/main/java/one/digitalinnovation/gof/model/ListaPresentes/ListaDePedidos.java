package one.digitalinnovation.gof.model.ListaPresentes;

import java.util.ArrayList;
import java.util.List;

public class ListaDePedidos {

    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedido() {
        return pedidos;
    }

    public void setPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
