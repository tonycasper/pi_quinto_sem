package br.usjt.proj_int.model.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@NotEmpty
	private String nome;
	
	@ManyToMany(mappedBy = "categorias")
	@JsonIgnoreProperties("conteudos")
	private List<Conteudo> conteudos;
	
	@ManyToMany(mappedBy = "categorias")
	@JsonIgnoreProperties("conteudos")
	private List<Material> materiais;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}	
}
