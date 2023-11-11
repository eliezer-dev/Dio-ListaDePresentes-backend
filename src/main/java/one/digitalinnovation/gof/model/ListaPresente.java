package one.digitalinnovation.gof.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ListaPresente {

    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedido() {
        return pedidos;
    }

    public void setPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
