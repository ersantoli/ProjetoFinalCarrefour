package SafePlace.Safeplace.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import SafePlace.Safeplace.models.Empresa;
import SafePlace.Safeplace.repository.EmpresaRepository;

@Controller
public class EmpresaController {


        @Autowired
		private EmpresaRepository er;




       
	
	//Chama o form de cadastro
	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.GET)
	public String form() {
		return "empresa/formEmpresa";
	}
	
	
	//Cadastra Empresa
	@RequestMapping(value = "/cadastrarEmpresa", method = RequestMethod.POST)
	public String form(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes ) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos" );
			
			return "redirect:/cadastrarEmpresa";
		}
		
		er.save(empresa);
		attributes.addFlashAttribute("mensagem","Empresa cadastrado com sucesso!");
			return "redirect:/empresas";
		
	}
	
	//listar empresa
	
		@RequestMapping("/empresas")
		public ModelAndView listaEmpresas() {
			ModelAndView mv = new ModelAndView("empresa/listaEmpresa");
			Iterable<Empresa> empresas = er.findAll();
			mv.addObject("empresas", empresas);
			return mv;
			
			
}
		
		@RequestMapping(value = "/editar-empresa", method = RequestMethod.GET)
		public ModelAndView editarEmpresa(long id) {
			Empresa empresa = er.findById(id);
			ModelAndView mv = new ModelAndView("empresa/update-empresa");
			mv.addObject("empresa", empresa);
			return mv;
		}
		
		//Atualiza Empresa
		@RequestMapping(value = "/editar-empresa", method = RequestMethod.POST)
		public String updateEmpresa(@Valid Empresa empresa, BindingResult result, RedirectAttributes attributes) {
			er.save(empresa);
			attributes.addFlashAttribute("success", "Atualizado com sucesso!");
			
			long idLong = empresa.getId();
			String id = ""+ idLong;
			return "redirect:/empresas";
		
		
	}
	
	//deletar Empresa
		@RequestMapping("/deletarEmpresa")
		public String deletarEmpresa(long id) {
		 
			Empresa empresa = er.findById(id);
			er.delete(empresa);
			return "redirect:/empresas";
			
		}
		
}
