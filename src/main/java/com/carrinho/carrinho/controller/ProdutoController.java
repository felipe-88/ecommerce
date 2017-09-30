/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.controller;

import com.carrinho.carrinho.model.Produto;
import com.carrinho.carrinho.service.ProdutoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que também faz o papel de atender às requisicões restful referente
 * ao CRUD de produto.
 * @author felipevieira
 */
@RestController
@RequestMapping("/shop")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    /**
     * Retorna todos os produtos cadastrados.
     * @return List&lt;Produto&gt;
     */
    @GetMapping("/produtos")
    public List<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }
    
    /**
     * Cadastra um Produto.
     * @param produto Produto
     * @return Produto
     */
    @PostMapping("/produtos")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoService.createOrUpdateProduto(produto);
    }
    
    /**
     * Retorna um Produto específico (busca pelo id).
     * @param produtoId Integer
     * @return ResponseEntity&lt;Produto&gt;
     */
    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable(value = "id") Integer produtoId) {
        Produto produto = produtoService.getProdutoById(produtoId);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(produto);
    }
    
    /**
     * Atualiza os dados de determinado produto.
     * @param produtoId Integer
     * @param produtoNew Produto
     * @return ResponseEntity&lt;Produto&gt;
     */
    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Integer produtoId,
                                                 @Valid @RequestBody Produto produtoNew) {
        Produto produto = produtoService.getProdutoById(produtoId);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produto.setNome(produtoNew.getNome());
        produto.setValor(produtoNew.getValor());
        
        Produto updatedProduto = produtoService.createOrUpdateProduto(produto);
        return ResponseEntity.ok(updatedProduto);
    }
    
    /**
     * Deleta o Produto em questão.
     * @param produtoId Integer
     * @return ResponseEntity&lt;Produto&gt; 
     */
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") Integer produtoId) {
        Produto produto = produtoService.getProdutoById(produtoId);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        
        produtoService.deleteProduto(produto);
        return ResponseEntity.ok().build();
    }
}