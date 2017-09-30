/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entidade Item. Contém o produto e a quantidade dele.
 * @author felipevieira
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"produto", "carrinho"}, 
						allowGetters = true)
public class Item implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3941807493153722033L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private Integer quantidade;
    @OneToOne(mappedBy = "item")
    @JoinColumn(name = "id", nullable = false)
    private Produto produto;   
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Carrinho carrinho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}