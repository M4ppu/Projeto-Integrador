package org.generation.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "postagem_like")
public class PostagensLikeModel {

	public PostagensLikeModel() {
	};

	public PostagensLikeModel(
			@NotNull(message = "O atributo id_postagem é Obrigatório e não pode utilizar espaços em branco!") Long postagem,
			@NotNull(message = "O atributo id_usuario é Obrigatório e não pode utilizar espaços em branco!") Long usuario) {
		this.postagem = postagem;
		this.usuario = usuario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "id_postagem")
	@NotNull(message = "O atributo id_postagem é Obrigatório e não pode utilizar espaços em branco!")
	private Long postagem;

	@JoinColumn(name = "id_usuario")
	@NotNull(message = "O atributo id_usuario é Obrigatório e não pode utilizar espaços em branco!")
	private Long usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostagem() {
		return postagem;
	}

	public void setPostagem(Long postagem) {
		this.postagem = postagem;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

}