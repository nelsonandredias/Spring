package com.java.springbootepisodezero.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootepisodezero.models.books;

@RestController
public class booksController {
	
	@GetMapping("/books")
	public List<books> getAllBooks (){
		
		return Arrays.asList(
				new books (1, "Cien años de Soledad", "Gabriel García Márquez"),
				new books (1, "El amor en el tiempo del cólera", "Gabriel García Márquez"),
				new books (1, "El coronel no tiene quien le escriba", "Gabriel García Márquez"),
				new books (1, "Memorias de mis putas tristes", "Gabriel García Márquez"),
				new books (1, "Veinte poemas de amor y una canción desesperada", "Pablo Neruda"),
				new books (1, "Canto General", "Pablo Neruda"),
				new books (1, "Cien sonetos de amor", "Pablo Neruda"),
				new books (1, "La ciudad y los perros", "Mario Vargas Llosa"),
				new books (1, "La tía Julia y el escribidor", "Mario Vargas Llosa"),
				new books (1, "La fiesta del Chivo", "Mario Vargas Llosa"),
				new books (1, "Travesuras de la niña mala", "Mario Vargas Llosa"),
				new books (1, "El pozo", "Juan Carlos Onetti"),
				new books (1, "Tierra de nadie", "Juan Carlos Onetti"),
				new books (1, "Para esta noche", "Juan Carlos Onetti"),
				new books (1, "La vida breve", "Juan Carlos Onetti"),
				new books (1, "Ismaelillo", "José Martí"),
				new books (1, "Versos sencillos", "José Martí")
				);
	}

}
