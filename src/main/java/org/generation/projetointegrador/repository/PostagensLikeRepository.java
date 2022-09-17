package org.generation.projetointegrador.repository;

import javax.transaction.Transactional;

import org.generation.projetointegrador.model.PostagensLikeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PostagensLikeRepository extends JpaRepository<PostagensLikeModel, Long>{
	
	@Modifying
	@Query("delete from PostagensLikeModel p where p.postagem = :postagem and p.usuario = :usuario")
	int deletar(@Param("postagem") Long postagem, @Param("usuario") Long usuario);
	
}
