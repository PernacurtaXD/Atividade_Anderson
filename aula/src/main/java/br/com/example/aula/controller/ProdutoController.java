package br.com.example.aula.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.example.aula.model.Produto;
import br.com.example.aula.model.RespostaModelo;
import br.com.example.aula.service.ProdutoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;







@RestController
@CrossOrigin(origins = "*   ")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoservice;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody Produto produto){
        return produtoservice.cadastrar(produto);
    }
    
    @GetMapping("/listar")
    public Iterable<Produto> listar(){
        return produtoservice.listar();
    }
    

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto produto){
        return produtoservice.cadastrarAlterar(produto, "alterar");
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return produtoservice.remover(codigo);
    }

    @GetMapping("")
    public String rota(){
        return "api de produtos funcionando!";
    }


    
    
    

}
