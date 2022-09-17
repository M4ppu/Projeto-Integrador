package org.generation.projetointegrador.controller;

import java.util.List;

import org.generation.projetointegrador.model.PostagensModel;
import org.generation.projetointegrador.repository.PostagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensController {

	@Autowired
	private PostagensRepository postagensRepository;
	
	@GetMapping
	private ResponseEntity<List<PostagensModel>> getAll(){
		return ResponseEntity.ok(postagensRepository.findAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<PostagensModel> findById(@PathVariable Long id){
		return postagensRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	private ResponseEntity<List<PostagensModel>> findAllByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagensRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<PostagensModel> post(@RequestBody PostagensModel titulo){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagensRepository.save(titulo));
	}
	
	@PutMapping
	public ResponseEntity<PostagensModel> put (@RequestBody PostagensModel titulo){
		return ResponseEntity.ok().body(postagensRepository.save(titulo));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		postagensRepository.deleteById(id);
	}
	
	
}
