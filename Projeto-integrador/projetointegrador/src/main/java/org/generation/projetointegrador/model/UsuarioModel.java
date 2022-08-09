package org.generation.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "usuario")
public class UsuarioModel {

	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)    // No banco de dados ele vai se transformar em uma chave primária
	private Long id;
	
	@NotNull
	@Size (min = 5, max = 100)
	private String nome;
	
	@NotNull
	@Size (min = 5, max = 100)
	private String usuario;
	
	@NotNull
	private Integer senha;
	
	private  String foto;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<PostagensModel>postagens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<PostagensModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagensModel> postagens) {
		this.postagens = postagens;
	}
	
	
}
