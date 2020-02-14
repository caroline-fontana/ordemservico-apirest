package com.ordemservico.projeto.service;

import java.util.List;

import com.ordemservico.projeto.models.OrdemServico;

public interface OrdemServicoService {

	List<OrdemServico> listarOrdensServico();

    OrdemServico listarOrdemServico(long id);

    OrdemServico salvarOrdem(OrdemServico ordemServico);
	
    void deletarOrdem(OrdemServico ordemServico);
    
    OrdemServico atualizarOrdem(OrdemServico ordemServico);
}
