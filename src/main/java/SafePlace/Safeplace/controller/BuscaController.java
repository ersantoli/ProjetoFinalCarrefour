package SafePlace.Safeplace.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import SafePlace.Safeplace.models.Empresa;
import SafePlace.Safeplace.repository.EmpresaRepository;



@Controller
public class BuscaController {
	
	
	
	@Autowired
	private EmpresaRepository er;
	
	//GET
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	//POST
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da busca por " + buscar;
		
		 if(nome.equals("nomeEmpresa")) {
			mv.addObject("empresas", er.findByNomesEmpresas(buscar));
			
		}
		else {
		
			mv.addObject("empresas", er.findByNomesEmpresas(buscar));
		}
		
		mv.addObject("mensagem", mensagem);
		
		return mv;
	}

}