package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.ListaPresente;
import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.model.ProdutoPedido;
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
    public ResponseEntity<ListaPresente> buscarTodos(){
        System.out.println(listaPresenteService.buscarTodos());
        return ResponseEntity.ok(listaPresenteService.buscarTodos());

    }

    @PostMapping
    public ResponseEntity<ProdutoPedido> inserir(@RequestBody ProdutoPedido produtoPedido) {
        listaPresenteService.inserir(produtoPedido);
        return ResponseEntity.ok(produtoPedido);
    }


    @GetMapping("/{pedido}")
    public ResponseEntity<ListaPresente> buscarPorId(@PathVariable Long pedido) {
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
