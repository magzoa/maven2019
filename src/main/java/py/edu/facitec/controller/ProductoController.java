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

import py.edu.facitec.dao.ProductoDAO;
import py.edu.facitec.model.Producto;


//Arquitectura Rest
@RestController
@Transactional
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoDAO productoDAO;
							//convertir de Json a Java

	//verbo POST es registrar
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		
		productoDAO.guardar(producto);
		
return new ResponseEntity<Producto>(producto, HttpStatus.OK);		
	}


//verbo GET es para consulta
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")	
public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
		
	Producto producto=	productoDAO.buscar(id);
	
	if (producto==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		
							//Retorna el producto encontrado
return new ResponseEntity<Producto>(producto, HttpStatus.OK);		
	}



//verbo DELETE es para eliminar
@RequestMapping(method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,value="/{id}")	
public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id){
		
	Producto producto=	productoDAO.buscar(id);
	
	if (producto==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	productoDAO.eliminar(producto);
		
							//Retorna la eliminacion correcta.
return new ResponseEntity<Producto>(HttpStatus.OK);		
	}



//Listar todos los productos
//verbo GET es para consulta
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)	
public ResponseEntity<List<Producto>> buscarProductos(){
		
	
	List<Producto> productos=productoDAO.getLista();
	
		
							//Retorna el producto encontrado
return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);		
	}








	
	

}
