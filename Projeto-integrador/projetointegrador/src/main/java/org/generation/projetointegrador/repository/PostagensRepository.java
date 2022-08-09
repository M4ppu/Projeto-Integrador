package org.generation.projetointegrador.repository;

import java.util.List;

import org.generation.projetointegrador.model.PostagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<PostagensModel, Long>{

	public List<PostagensModel> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
}
