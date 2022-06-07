package SafePlace.Safeplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import SafePlace.Safeplace.models.Empresa;


public interface EmpresaRepository  extends CrudRepository<Empresa, String>{
	
	Empresa findById(long id);
	
	//Busca
	Empresa findByNome(String nome);
	
	
	//para a busca
		@Query(value = "select u from Empresa u where u.nome like %?1%")
		List<Empresa> findByNomesEmpresas(String nome);

}








