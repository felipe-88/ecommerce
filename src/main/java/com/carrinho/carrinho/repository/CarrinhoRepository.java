/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.repository;

import com.carrinho.carrinho.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author felipevieira
 */
@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
    
}