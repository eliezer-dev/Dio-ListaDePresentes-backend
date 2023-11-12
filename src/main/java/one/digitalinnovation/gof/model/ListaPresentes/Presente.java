package one.digitalinnovation.gof.model.ListaPresentes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Presente {
    private Long idProduto;
    private Float preco;
    private Long quantidade;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Presente{" +
                "idProduto=" + idProduto +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
