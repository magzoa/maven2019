package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Departamento extends General {


private String descripcion;
	
//Relación de Uno a Uno	
//mappedBy  Relación bidireccional
//para no crear 3 tablas
// en cualquiera de las clases
// puede ir el mappedBy
//una sola vez
@OneToOne(mappedBy="departamento")
private Gerente gerente;


@OneToMany(mappedBy="departamento")
private List<Usuario> usuarios;


public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Gerente getGerente() {
	return gerente;
}

public void setGerente(Gerente gerente) {
	this.gerente = gerente;
}
	
	


}
