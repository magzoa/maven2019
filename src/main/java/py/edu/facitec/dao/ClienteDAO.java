package py.edu.facitec.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;
import py.edu.facitec.model.ItemPedido;
import py.edu.facitec.model.Producto;

//Indicar manipulación de datos
@Repository
public class ClienteDAO extends DAOGenerico<Cliente> {
	
	//Unidad de persistencia
		@PersistenceContext
		private EntityManager manager;
	
	public ClienteDAO() {
		super(Cliente.class);
		
	}

	@Override
	protected EntityManager getEntityManager() {
		
		return manager;
	}
	
	
	
	
	//public void insertar(Cliente cliente) {
		
		//Genera el sql y inserta en la bd
	//	manager.persist(cliente);
	//}
	
	

}
