package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.demo.DTO.CartDTO;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class CartData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private int cartId;
	private String bookName;
	private String authorName;
	private String bookImage;
	private int quantity;
	private int price;
	private String bookDescription;
	
	public CartData() {}
	
	public CartData(CartDTO cartDTO) {
		this.bookName = cartDTO.bookName;
		this.authorName = cartDTO.authorName;
		this.bookImage = cartDTO.image;
		this.quantity = cartDTO.quantity;
		this.price = cartDTO.price;
		this.bookDescription = cartDTO.bookDescription;
	}
}
