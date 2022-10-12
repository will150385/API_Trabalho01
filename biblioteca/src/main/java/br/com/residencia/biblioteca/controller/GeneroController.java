package br.com.residencia.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.residencia.biblioteca.entity.Genero;
import br.com.residencia.biblioteca.service.GeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {
	@Autowired
	GeneroService generoService;
	
	@GetMapping
	public ResponseEntity<List<Genero>>getAllGenero(){
		return new ResponseEntity<>(generoService.getAllGenero(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero>getgeneroById(@PathVariable Integer Id){
		Genero genero = generoService.getGeneroById(Id);
		if (null!= genero)
			return new ResponseEntity<>(genero,HttpStatus.OK);
		else 
			return new ResponseEntity<>(genero,HttpStatus.NOT_FOUND);
	}
	@PostMapping
	public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
		return new ResponseEntity<>(generoService.saveGenero(genero),
				HttpStatus.CREATED);

	}
	@PutMapping("/{id}")
	public ResponseEntity<Genero>updateGenero(@RequestBody Genero genero,@PathVariable Integer id ){
		return new ResponseEntity<>(generoService.updateGenero(genero,id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Genero>deleteGenero(@PathVariable Integer id){
		return new ResponseEntity<>(generoService.deleteGenero(id),HttpStatus.OK);
	}
	public GeneroService getgeneroService() {
		return generoService;	
	}
	public void setGeneroService(GeneroService generoService) {
		this.generoService = generoService;
	}
	

}
