package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Identificar el nombre de la tabla a ser creada
@Entity
public class Cliente {

	
//Indicamos que id sera la clave primaria	
@Id	
@GeneratedValue  //generar automaticamente el id
	private Integer id;
	private String nombre;
	private String correo;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	
	
	public Cliente() {	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	

}
