package servicio;

import java.util.Date;
import db.BaseDeDatos.*;
import modelo.DaoContacto;
import modelo.EntityContacto;

public class serviceContacto {
	private BaseDeDatos basededatos;
	private DaoContacto daocontacto;

	public BaseDeDatos getBasededatos() {
		return basededatos;
	}

	public void setBasesdedatos(BaseDeDatos basededatos) {
		this.basededatos = basededatos;
	}

	public serviceContacto() {

	}

	public String insertar(String nombre, String apellidos, String telefono, String vinculo, String imagen, String id,
			String fechaNacimieto) {
		EntityContacto contacto = new EntityContacto(nombre, apellidos, telefono, vinculo, imagen,  Integer.parseInt(id),  new Date(fechaNacimieto));
		
		daocontacto = new DaoContacto(contacto, basededatos);
		return daocontacto.insertar();

	}
	public String consultar(String nombre){
		EntityContacto consultarPorNombre = new EntityContacto();
		daocontacto = new DaoContacto(consultarPorNombre, basededatos);
		return daocontacto.SelectNombre();
	}

}
