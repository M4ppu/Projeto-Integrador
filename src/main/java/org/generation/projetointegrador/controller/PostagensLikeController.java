package org.generation.projetointegrador.controller;

import org.generation.projetointegrador.model.PostagensLikeModel;
import org.generation.projetointegrador.service.PostagensLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens/like")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensLikeController {

	@Autowired
	private PostagensLikeService postagensLikeService;
	
	@PostMapping("/{postagem}/{usuario}")
	private void findById(@PathVariable Long postagem, @PathVariable Long usuario){
		postagensLikeService.adicionarLike(postagem, usuario);
	}
	
	@DeleteMapping("/{postagem}/{usuario}")
	public void delete(@PathVariable Long postagem, @PathVariable Long usuario){
		postagensLikeService.removerLike(postagem, usuario);
	}
	
}
