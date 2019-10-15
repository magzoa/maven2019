package py.edu.facitec.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido extends General{
	
private Date fechaToma;
private Date fechaEntrega;
private BigDecimal total;

//Relación de uno a muchos

//pedido es el objeto de la clase
//Pedido contenido dentro de
//ItemPedido
@OneToMany(mappedBy="pedido")
private List<ItemPedido> itemPedidos;


@ManyToOne
private Cliente cliente;

@ManyToOne
private Usuario usuario;


public Date getFechaToma() {
	return fechaToma;
}

public void setFechaToma(Date fechaToma) {
	this.fechaToma = fechaToma;
}

public Date getFechaEntrega() {
	return fechaEntrega;
}

public void setFechaEntrega(Date fechaEntrega) {
	this.fechaEntrega = fechaEntrega;
}

public BigDecimal getTotal() {
	return total;
}

public void setTotal(BigDecimal total) {
	this.total = total;
}

public List<ItemPedido> getItemPedidos() {
	return itemPedidos;
}

public void setItemPedidos(List<ItemPedido> itemPedidos) {
	this.itemPedidos = itemPedidos;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

	//GETTERS Y SETTERS


	
	

}
