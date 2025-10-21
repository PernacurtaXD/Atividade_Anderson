package br.com.example.aula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.example.aula.model.Produto;
import br.com.example.aula.model.RespostaModelo;
import br.com.example.aula.repository.ProdutoRepository;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Produto> listar(){
        return produtoRepository.findAll();
    }



    public ResponseEntity<?> cadastrar(Produto produto){
        if(produto.getNome().equals("")){
            respostaModelo.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else if(produto.getMarca().equals("")){
            respostaModelo.setMensagem("A marca do produto é obridatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
        }
       
    }

    public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){
        if(produto.getNome().equals("")){
            respostaModelo.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.BAD_REQUEST);
    }else if(produto.getMarca().equals("")){
        respostaModelo.setMensagem("O marca do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.BAD_REQUEST);
    }else{
        if(acao.equals("cadastrar")){
            return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Produto>(produtoRepository.save(produto),HttpStatus.OK);
        }
    }
        
}


    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        produtoRepository.deleteById(codigo);

        respostaModelo.setMensagem("O produto foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(respostaModelo,HttpStatus.OK);
    }
}
