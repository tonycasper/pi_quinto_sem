package br.usjt.proj_int.model.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.usjt.proj_int.enums.TipoFeedback;

@Entity
public class Sugestao {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Lob
	@NotEmpty
	private String sugestao;
	
	@Enumerated(EnumType.STRING)	
	private TipoFeedback feedback;

	@ManyToOne
	@JsonIgnoreProperties("sugestoes")
	private Usuario usuario;

	@ManyToOne
	@JsonIgnoreProperties("sugestoes")
	private Conteudo conteudo;

	public Sugestao() {

	}

	public Sugestao(String sugestao, Usuario usuario, Conteudo conteudo) {
		this.sugestao = sugestao;
		this.usuario = usuario;
		this.conteudo = conteudo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public TipoFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(TipoFeedback feedback) {
		this.feedback = feedback;
	}
}
