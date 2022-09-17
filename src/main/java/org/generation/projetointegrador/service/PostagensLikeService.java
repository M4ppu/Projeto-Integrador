package org.generation.projetointegrador.service;

import org.generation.projetointegrador.model.PostagensLikeModel;
import org.generation.projetointegrador.repository.PostagensLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostagensLikeService {
	
	@Autowired
	private PostagensLikeRepository repository;
	
	public void adicionarLike(Long postagem, Long usuario) {
		 repository.save(new PostagensLikeModel(postagem, usuario));				
	}
	
	public void removerLike(Long postagem, Long usuario) {
		repository.deletar(postagem, usuario);			
	}

}

