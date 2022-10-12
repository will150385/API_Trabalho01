package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Diretor;
import br.com.residencia.biblioteca.repository.DiretorRepository;


@Service
public class DiretorService {
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Diretor>getAllDiretor(){
		return diretorRepository.findAll();
		}
	
	public Diretor getDiretorById(Integer id) {
		return diretorRepository.findById(id).orElse(null);
	}
	
	public Diretor saveDiretor(Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public Diretor updateDiretor(Diretor diretor,Integer id) {
		
		Diretor diretorExistenteNoBanco= getDiretorById(id);
		
		diretorExistenteNoBanco.setNome(diretor.getNome());	
			
		return diretorRepository.save(diretorExistenteNoBanco);
				
	}	
	public Diretor deleteDiretor(Integer Id) {
		diretorRepository.deleteById(Id);
		return getDiretorById(Id);
		
	}
	
	
	

}
