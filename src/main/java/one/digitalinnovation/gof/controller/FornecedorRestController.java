package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Fornecedor;
import one.digitalinnovation.gof.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fornecedores")
public class FornecedorRestController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> buscarTodos(){
        return ResponseEntity.ok(fornecedorService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> inserir(@RequestBody Fornecedor fornecedor) {
        fornecedorService.inserir(fornecedor);
        return ResponseEntity.ok(fornecedor);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fornecedorService.buscarPorId(id));
    }



    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        fornecedorService.atualizar(id, fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
