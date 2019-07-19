package com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.udemy.unittesting.spring.boot.restful.junit.testing.basic.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
