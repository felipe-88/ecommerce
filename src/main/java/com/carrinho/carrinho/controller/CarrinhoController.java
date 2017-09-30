package com.carrinho.carrinho.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrinho.carrinho.model.Carrinho;
import com.carrinho.carrinho.service.CarrinhoService;



/**
 * Controlador que também faz o papel de atender às requisicões restful referente
 * ao CRUD de carrinho.
 * @author felipevieira
 *
 */
@RestController
@RequestMapping("/shop")
public class CarrinhoController {

	@Autowired
    private CarrinhoService carrinhoService;
	
	/**
     * Retorna todos os carrinhos cadastrados.
     * @return List&lt;Carrinho&gt;
     */
    @GetMapping("/carrinhos")
    public List<Carrinho> getAllCarrinhos() {
        return carrinhoService.getAllCarrinhos();
    }
    
    /**
     * Cadastra um Carrinho.
     * @param carrinho Carrinho
     * @return Carrinho
     */
    @PostMapping("/carrinhos")
    public Carrinho createCarrinho(@Valid @RequestBody Carrinho carrinho) {
        return carrinhoService.createOrUpdateCarrinho(carrinho);
    }
    
    /**
     * Retorna um Carrinho específico (busca pelo id).
     * @param carrinhoId Integer
     * @return ResponseEntity&lt;Carrinho&gt;
     */
    @GetMapping("/carrinhos/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable(value = "id") Integer carrinhoId) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(carrinhoId);
        if (carrinho == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carrinho);
    }
    
    /**
     * Deleta o Carrinho em questão.
     * @param carrinhoId Integer
     * @return ResponseEntity&lt;Carrinho&gt; 
     */
    @DeleteMapping("/carrinhos/{id}")
    public ResponseEntity<Carrinho> deleteCarrinho(@PathVariable(value = "id") Integer carrinhoId) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(carrinhoId);
        if (carrinho == null) {
            return ResponseEntity.notFound().build();
        }
        
        carrinhoService.deleteCarrinho(carrinho);
        return ResponseEntity.ok().build();
    }
}