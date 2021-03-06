package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.proj_int.model.dto.CategoriaUploadDTO;
import br.usjt.proj_int.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired private CategoriaService categoriaService;
	
	@Secured("ROLE_ESTAGIARIO")
	@PostMapping("/cadastrar/{categoria}")
	public CategoriaUploadDTO cadastrarTag(@PathVariable("categoria") String nome){
		return new CategoriaUploadDTO(categoriaService.cadastrar(nome));
	}
	
	
}