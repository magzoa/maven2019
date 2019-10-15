package py.edu.facitec.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;


@Transactional // Manejar transaciones en la bd
@Controller
public class ClienteController {
	
// Inicializa
	@Autowired 
	private ClienteDAO clienteDAO;
	
	
	@RequestMapping("/clientes")
	public String registrar(Cliente cliente) {
		
			//Guardar inserta y actualiza si necesario
		clienteDAO.guardar(cliente);
		
		return "view/cliente/form";
	}
	
	@RequestMapping("/cargar")
	public String cargarFormulario() {
		
		System.out.println("Cargando formulario");
		
		return "view/cliente/form";
	}
	
	
	
	
	

}
