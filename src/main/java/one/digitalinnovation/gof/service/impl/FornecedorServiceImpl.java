package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.service.FornecedorService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

   
    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    

    @Override
    public Iterable<Fornecedor> buscarTodos() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.get();
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        salvarFornecedorComCep(fornecedor);
    }



    @Override
    public void atualizar(Long id, Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorBd = fornecedorRepository.findById(id);
        if (fornecedorBd.isPresent()){
            salvarFornecedorComCep(fornecedor);
        }
    }

    @Override
    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }

    private void salvarFornecedorComCep(Fornecedor fornecedor) {
        String cep = fornecedor.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultaCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        fornecedor.setEndereco(endereco);
        fornecedorRepository.save(fornecedor);
    }
}
