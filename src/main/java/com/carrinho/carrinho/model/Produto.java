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

/**
 * Entidade Produto
 * @author felipevieira
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Produto implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1591055901402360466L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(precision = 8, scale = 3)
    private Float valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}