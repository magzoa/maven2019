package py.edu.facitec.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.dao.UsuarioDAO;
import py.edu.facitec.model.Usuario;


//Arquitectura Rest
@RestController
@Transactional
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
							//convertir de Json a Java

	//verbo POST es registrar
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
		
		usuarioDAO.guardar(usuario);
		
return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}


//verbo GET es para consulta
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")	
public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id){
		
	Usuario usuario=	usuarioDAO.buscar(id);
	
	if (usuario==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		
							//Retorna el usuario encontrado
return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}



//verbo DELETE es para eliminar
@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")	
public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Integer id){
		
	Usuario usuario=	usuarioDAO.buscar(id);
	
	if (usuario==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	usuarioDAO.eliminar(usuario);
		
							//Retorna la eliminacion correcta.
return new ResponseEntity<Usuario>(HttpStatus.OK);		
	}



//Listar todos los usuarios
//verbo GET es para consulta
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<List<Usuario>> buscarUsuarios(){
		
	
	List<Usuario> usuarios=usuarioDAO.getLista();
	
		
							//Retorna el usuario encontrado
return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);		
	}








	
	

}
