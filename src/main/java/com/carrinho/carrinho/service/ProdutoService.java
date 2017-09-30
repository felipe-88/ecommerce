/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.service;

import com.carrinho.carrinho.model.Produto;
import com.carrinho.carrinho.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author felipevieira
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    /**
     * 
     * @return List&lt;Produto&gt;
     */
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    
    /**
     * 
     * @param produto Produto
     * @return Produto
     */
    public Produto createOrUpdateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    /**
     * 
     * @param id Integer
     * @return Produto
     */
    public Produto getProdutoById(Integer id) {
        return produtoRepository.findOne(id);
    }
    
    /**
     * 
     * @param produto Produto
     */
    public void deleteProduto(Produto produto) {
        produtoRepository.delete(produto);
    }
}