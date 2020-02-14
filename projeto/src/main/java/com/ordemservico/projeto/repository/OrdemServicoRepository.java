package com.ordemservico.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordemservico.projeto.models.OrdemServico;

/* JpaRepository possui vários métodos prontos para persistência no banco de dados. */

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
	
	// Método que procura uma única Ordem de Serviço através do ID.
	OrdemServico findById(long id);
}
