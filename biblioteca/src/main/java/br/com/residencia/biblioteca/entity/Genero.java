package br.com.residencia.biblioteca.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_genero")
@Entity
@Table(name = "genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero")
	private Integer id_genero;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "genero")
	private Set<Filme> filme;

	public Integer getId_genero() {
		return id_genero;
	}

	public void setId_genero(Integer id_genero) {
		this.id_genero = id_genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Filme> getFilme() {
		return filme;
	}

	public void setFilme(Set<Filme> filme) {
		this.filme = filme;
	}

}
