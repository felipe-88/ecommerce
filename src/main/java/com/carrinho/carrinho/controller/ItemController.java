package com.carrinho.carrinho.controller;

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

import com.carrinho.carrinho.model.Carrinho;
import com.carrinho.carrinho.model.Item;
import com.carrinho.carrinho.model.Produto;
import com.carrinho.carrinho.service.CarrinhoService;
import com.carrinho.carrinho.service.ItemService;
import com.carrinho.carrinho.service.ProdutoService;



/**
 * Controlador que também faz o papel de atender às requisicões restful referente
 * ao CRUD de item.
 * @author felipevieira
 */
@RestController
@RequestMapping("/shop")
public class ItemController {

	@Autowired
    private ItemService itemService;
	@Autowired
    private CarrinhoService carrinhoService;
	@Autowired
    private ProdutoService produtoService;
    
    /**
     * Retorna todos os items cadastrados.
     * @return List&lt;Item&gt;
     */
    @GetMapping("/itens")
    public List<Item> getAllItems() {
        return itemService.getAllItens();
    }
    
    /**
     * Cadastra um Item.
     * @param item Item
     * @return Item
     */
    @PostMapping("/itens/{idcart}/{idprod}")
    public Item createItem(@Valid @RequestBody Item item,
    						@PathVariable(value = "idcart") Integer carrinhoId,
    						@PathVariable(value = "idprod") Integer prodId) {
        Carrinho carrinho = carrinhoService.getCarrinhoById(carrinhoId);
        Produto produto = produtoService.getProdutoById(prodId);
        item.setCarrinho(carrinho);
        item.setProduto(produto);
        carrinho.getItens().add(item);
        
        carrinhoService.createOrUpdateCarrinho(carrinho);
    	return itemService.createOrUpdateItem(item);
    }
    
    /**
     * Retorna um Item específico (busca pelo id).
     * @param itemId Integer
     * @return ResponseEntity&lt;Item&gt;
     */
    @GetMapping("/itens/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Integer itemId) {
        Item item = itemService.getItemById(itemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(item);
    }
    
    /**
     * Atualiza os dados de determinado item.
     * @param itemId Integer
     * @param itemNew Item
     * @return ResponseEntity&lt;Item&gt;
     */
    @PutMapping("/itens/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Integer itemId,
                                                 @Valid @RequestBody Item itemNew) {
        Item item = itemService.getItemById(itemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        item.setQuantidade(itemNew.getQuantidade());
        
        Item updatedItem = itemService.createOrUpdateItem(item);
        return ResponseEntity.ok(updatedItem);
    }
    
    /**
     * Deleta o Item em questão.
     * @param itemId Integer
     * @return ResponseEntity&lt;Item&gt; 
     */
    @DeleteMapping("/itens/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable(value = "id") Integer itemId) {
        Item item = itemService.getItemById(itemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        
        itemService.deleteItem(item);
        return ResponseEntity.ok().build();
    }
}