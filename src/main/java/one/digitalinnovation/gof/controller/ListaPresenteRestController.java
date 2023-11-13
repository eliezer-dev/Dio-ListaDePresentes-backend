package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.ListaPresentes.ListaDePedidos;
import one.digitalinnovation.gof.model.ListaPresentes.ListasPresentes;
import one.digitalinnovation.gof.service.ListaPresenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("listas-presentes")
public class ListaPresenteRestController {
    @Autowired
    private ListaPresenteService listaPresenteService;

    @GetMapping
    public ResponseEntity<ListaDePedidos> buscarTodos(){
        return ResponseEntity.ok(listaPresenteService.buscarTodos());

    }

    @PostMapping
    public ResponseEntity<ListasPresentes> inserir(@RequestBody ListasPresentes listasPresentes) {
        listaPresenteService.inserir(listasPresentes);
        return ResponseEntity.ok(listasPresentes);
    }


    @GetMapping("/{pedido}")
    public ResponseEntity<ListaDePedidos> buscarPorId(@PathVariable Long pedido) {
        return ResponseEntity.ok(listaPresenteService.buscarPorPedido(pedido));
    }

    //desenvolvimento futuro
//    @PutMapping("/{pedido}")
//    public ResponseEntity<ProdutoPedido> atualizar(@PathVariable Long pedido, @RequestBody ProdutoPedido produtoPedido) {
//        listaPresenteService.atualizar(pedido, produtoPedido);
//        return ResponseEntity.ok(produtoPedido);
//    }

    @DeleteMapping("/{pedido}")
    public ResponseEntity<Void> deletar(@PathVariable Long pedido) {
        listaPresenteService.deletar(pedido);
        return ResponseEntity.ok().build();
    }
}
