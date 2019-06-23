package com.java.springbootsoapbasics.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.springbootsoapbasics.models.Authors;

@Component
public class AuthorsDetailService {
	
	//default response of status
	public enum status {
		SUCCESS,
		FAILURE;
	}
	
	//static list of Authors
	private static List<Authors> authors = new ArrayList<>();
	
	static {
		Authors author1 = new Authors(1, "Gabriel García Márquez", "Cien años de Soledad");
		authors.add(author1);
		Authors author2 = new Authors(2, "Gabriel García Márquez", "El amor en el tiempo del cólera");
		authors.add(author2);
		Authors author3 = new Authors(3, "Gabriel García Márquez", "El coronel no tiene quien le escriba");
		authors.add(author3);
		Authors author4 = new Authors(4, "Gabriel García Márquez", "Memorias de mis putas tristes");
		authors.add(author4);
		Authors author5 = new Authors(5, "Pablo Neruda", "Veinte poemas de amor y una canción desesperada");
		authors.add(author5);
		Authors author6 = new Authors(6, "Pablo Neruda", "Canto General");
		authors.add(author6);
		Authors author7 = new Authors(7, "Pablo Neruda", "Cien sonetos de amor");
		authors.add(author7);
		Authors author8 = new Authors(8, "Mario Vargas Llosa", "La ciudad y los perros");
		authors.add(author8);
		Authors author9 = new Authors(9, "Mario Vargas Llosa", "La tía Julia y el escribidor");
		authors.add(author9);
		Authors author10 = new Authors(10, "Mario Vargas Llosa", "La fiesta del Chivo");
		authors.add(author10);
		Authors author11 = new Authors(11, "Mario Vargas Llosa", "Travesuras de la niña mala");
		authors.add(author11);
		Authors author12 = new Authors(12, "Juan Carlos Onetti", "El pozo");
		authors.add(author12);
		Authors author13 = new Authors(13, "Juan Carlos Onetti", "Tierra de nadie");
		authors.add(author13);
		Authors author14 = new Authors(14, "Juan Carlos Onetti", "Para esta noche");
		authors.add(author14);
		Authors author15 = new Authors(15, "Juan Carlos Onetti", "La vida breve");
		authors.add(author15);
		Authors author16 = new Authors(16, "José Martí", "Ismaelillo");
		authors.add(author16);
		Authors author17 = new Authors(17, "José Martí", "Versos sencillos");
		authors.add(author17);
		
	}
	
	/*3 service methods:
		1. service to getAuthorDetails based on id
		2. service to getAllAuthorDetails
		3. service to deleteAuthor
	//*/
	
	//1. service to getAuthorDetails based on id
	public Authors findById (int id) {
		
		for (Authors author:authors) {
			
			if(author.getId() == id) {
				return author;
			}
		}
		
		return null;
	}
	
	//2. service to getAllAuthorDetails
	public List<Authors> getAllAuthorDetails(){
		
		return authors;
	}
	
	//3. service to deleteAuthor
	public status deleteAuthor(int id) {
	
		//iterator
		Iterator<Authors> authorIterator = authors.iterator();
		
		while (authorIterator.hasNext()) {
			
			Authors author = authorIterator.next();
			
			if(author.getId() == id) {
				
				authorIterator.remove();
				return status.SUCCESS;
			}
		}
		
		return status.FAILURE;
	}

}
