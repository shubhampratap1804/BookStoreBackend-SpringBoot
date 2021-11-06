package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.WishlistData;

public interface WishlistRepository extends JpaRepository<WishlistData, Integer> {

}
