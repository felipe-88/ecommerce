package com.carrinho.carrinho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrinho.carrinho.model.Carrinho;
import com.carrinho.carrinho.repository.CarrinhoRepository;

/**
 * 
 * @author felipevieira
 *
 */
@Service
public class CarrinhoService {

	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	/**
	 * 
	 * @return List&lt;Carrinho&gt;
	 */
	public List<Carrinho> getAllCarrinhos() {
		return carrinhoRepository.findAll();
	}
	
	/**
	 * 
	 * @param carrinho Carrinho
	 * @return Carrinho
	 */
	public Carrinho createOrUpdateCarrinho(Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	/**
	 * 
	 * @param id Integer
	 * @return Carrinho
	 */
	public Carrinho getCarrinhoById(Integer id) {
		return carrinhoRepository.findOne(id);
	}
	
	/**
	 * 
	 * @param carrinho Carrinho
	 */
	public void deleteCarrinho(Carrinho carrinho) {
		carrinhoRepository.delete(carrinho);
	}
}