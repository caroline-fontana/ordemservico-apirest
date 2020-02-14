package com.ordemservico.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordemservico.projeto.models.OrdemServico;
import com.ordemservico.projeto.repository.OrdemServicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController 
@RequestMapping(value="/api")
@Api(value="API REST Ordem de Serviços")
@CrossOrigin(origins="*") // Qualquer domínio poderá acessar a API.

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService{

	@Autowired
	OrdemServicoRepository ordemServicoRepository;
	
	/* Método para listar todas as Ordens de Servico do banco de dados. */
	@GetMapping("/ordensservico")
	@ApiOperation(value="Retorna uma lista de ordens de serviço")
	@Override
	public List<OrdemServico> listarOrdensServico(){
		return ordemServicoRepository.findAll();
	}
	
	/* Método para listar uma Ordem de Servico ao passar o respectivo Id, do banco de dados. */
	@GetMapping("/ordemservico/{id}")
	@ApiOperation(value="Retorna uma ordem de serviço")
	@Override
	public OrdemServico listarOrdemServico(@PathVariable(value="id") long id){
		return ordemServicoRepository.findById(id);
	}
	
	/* Método para salvar uma ordem de serviço. */
	@PostMapping("/ordemservico")
	@ApiOperation(value="Salva uma ordem de serviço")
	@Override
	public OrdemServico salvarOrdem(@RequestBody OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	/* Método para deletar uma ordem de serviço. */
	@DeleteMapping("/ordemservico")
	@ApiOperation(value="Exclui uma ordem de serviço")
	@Override
	public void deletarOrdem(@RequestBody OrdemServico ordemServico) {
		ordemServicoRepository.delete(ordemServico);
	}

	/* Método para atualizar uma ordem de serviço. */
	@PutMapping("/ordemservico")
	@ApiOperation(value="Atualiza uma ordem de serviço")
	@Override
	public OrdemServico atualizarOrdem(@RequestBody OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}

}
