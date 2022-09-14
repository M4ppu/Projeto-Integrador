package org.generation.projetointegrador.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@Size (min = 5, max =255)
	private String parceiros_nome;
	
	@Size (min = 5, max =255)
	@Email(message = "O Atributo Usuário deve ser um email válido!")
	private String parceiros_email;
	
	@Size (min = 5, max =255)
	private String parceiros_site;
	
	@ManyToOne
	@JsonIgnoreProperties("Postagens")
	private TemaModel tema;
	
	@ManyToOne
	@JsonIgnoreProperties("Usuario")
	private UsuarioModel usuario;

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

	public String getParceiros_nome() {
		return parceiros_nome;
	}

	public void setParceiros_nome(String parceiros_nome) {
		this.parceiros_nome = parceiros_nome;
	}

	public String getParceiros_email() {
		return parceiros_email;
	}

	public void setParceiros_email(String parceiros_email) {
		this.parceiros_email = parceiros_email;
	}

	public String getParceiros_site() {
		return parceiros_site;
	}

	public void setParceiros_site(String parceiros_site) {
		this.parceiros_site = parceiros_site;
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
}