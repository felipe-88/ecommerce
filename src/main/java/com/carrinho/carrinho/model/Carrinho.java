/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carrinho.carrinho.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Entidade Carrinho de Compra. Contém vários itens de produto.
 * @author felipevieira
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"itens", "createdAt", "updatedAt"}, 
        allowGetters = true)
public class Carrinho implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3305799975346482687L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "item")
    private List<Item> itens;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}