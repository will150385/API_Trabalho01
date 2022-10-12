package br.com.residencia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entity.Filme;

public interface FilmeRepository  extends JpaRepository<Filme,Integer>{
	

}
