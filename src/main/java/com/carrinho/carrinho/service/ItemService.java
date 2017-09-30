package com.carrinho.carrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrinho.carrinho.model.Item;
import com.carrinho.carrinho.repository.ItemRepository;

/**
 * 
 * @author felipevieira
 *
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	/**
	 * 
	 * @return List&lt;Item&gt;
	 */
	public List<Item> getAllItens() {
		return itemRepository.findAll();
	}
	
	/**
	 * 
	 * @param item Item
	 * @return Item
	 */
	public Item createOrUpdateItem(Item item) {
		return itemRepository.save(item);
	}
	
	/**
	 * 
	 * @param id Integer
	 * @return Item
	 */
	public Item getItemById(Integer id) {
		return itemRepository.findOne(id);
	}
	
	/**
	 * 
	 * @param item Item
	 */
	public void deleteItem(Item item) {
		itemRepository.delete(item);
	}
}