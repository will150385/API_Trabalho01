package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Filme;
import br.com.residencia.biblioteca.repository.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository filmeRepository;
	
	public List<Filme>getAllFilme(){
		return filmeRepository.findAll();
		}
	
	public Filme getFilmeById(Integer id) {
		return filmeRepository.findById(id).orElse(null);
	}
	
	public Filme savefilme(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme updateFilme(Filme filme,Integer id) {
		
		Filme filmeExistenteNoBanco= getFilmeById(id);
		filmeExistenteNoBanco.setNome_br(filme.getNome_br());
		filmeExistenteNoBanco.setNome_en(filme.getNome_en());
		filmeExistenteNoBanco.setSinopse(filme.getSinopse());
		filmeExistenteNoBanco.setAno_lancamento(filme.getAno_lancamento());
		filmeExistenteNoBanco.setDiretor(filme.getDiretor());
		filmeExistenteNoBanco.setGenero(filme.getGenero());
		return filmeRepository.save(filmeExistenteNoBanco);
				
	}	
	public Filme deleteFilme(Integer Id) {
		filmeRepository.deleteById(Id);
		return getFilmeById(Id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
