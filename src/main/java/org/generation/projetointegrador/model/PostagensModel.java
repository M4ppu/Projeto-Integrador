package org.generation.projetointegrador.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name= "postagem")
public class PostagensModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	
	
	@Size (min = 5, max =100)
	private String titulo;
	

	@UpdateTimestamp
	private LocalDateTime data;
	
	private String foto;	
	
	@ManyToOne
	@JsonIgnoreProperties("Postagens")
	private TemaModel tema;
	
	@ManyToOne
	@JsonIgnoreProperties("Usuario")
	private UsuarioModel usuario;
	
	@OneToMany(mappedBy="postagem",fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)	
	@JsonIgnoreProperties("Like")
	private List<PostagensLikeModel> like;
	
	@JsonIgnoreProperties("qtdLike")
	private Integer qtd_like;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public List<PostagensLikeModel> getLike() {
		return like;
	}

	public void setLike(List<PostagensLikeModel> like) {
		this.like = like;
	}

	public Integer getQtd_like() {
		return like.size();
	}

	public void setQtd_like(Integer qtd_like) {
		this.qtd_like = qtd_like;
	}
			
}