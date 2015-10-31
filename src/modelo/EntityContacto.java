package modelo;

import java.util.Date;

public class EntityContacto {

	private String nombre;
	private String apellidos;
	private String telefono;
	private String vinculo;
	private String imagen;
	private int id;
	private Date fechaNacimieto;

	// Get & Set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaNacimieto() {
		return fechaNacimieto;
	}

	public void setFechaNacimieto(Date fechaNacimieto) {
		this.fechaNacimieto = fechaNacimieto;
	}

	// to string
	@Override
	public String toString() {
		return "EntityContacto [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", vinculo="
				+ vinculo + ", imagen=" + imagen + ", id=" + id + ", fechaNacimieto=" + fechaNacimieto + "]";
	}

	// contructor
	public EntityContacto(String nombre, String apellidos, String telefono, String vinculo, String imagen, int id,
			Date fechaNacimieto) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.vinculo = vinculo;
		this.imagen = imagen;
		this.id = id;
		this.fechaNacimieto = fechaNacimieto;
	}
	
	// constructor vacio

	public EntityContacto() {

		super();
	}

}