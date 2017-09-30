/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.repository;

import com.carrinho.carrinho.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface para acessar os dados de Item no banco, de acordo com a especificação
 * do Spring Data. Note que não é preciso implementar métodos tais como save, update, 
 * etc, já que estes são implementados pela classe SimpleJpaRepository (dodumentação completa em 
 * https://docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html).
 * @author felipevieira
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    
}