package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.ListaPresente;
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


//    @GetMapping("/{id}")
//    public ResponseEntity<ListaPresente> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(listaPresenteService.buscarPorId(id));
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ListaPresente> atualizar(@PathVariable Long id, @RequestBody ListaPresente listaPresente) {
//        listaPresenteService.atualizar(id, listaPresente);
//        return ResponseEntity.ok(listaPresente);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        listaPresenteService.deletar(id);
//        return ResponseEntity.ok().build();
//    }
}
