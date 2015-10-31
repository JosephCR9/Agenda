package modelo;

import java.text.SimpleDateFormat;

import db.BaseDeDatos.BaseDeDatos;

public class DaoContacto {

	EntityContacto entityContacto;
	BaseDeDatos baseDeDatos;
	SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");

	public DaoContacto(EntityContacto entityContacto, BaseDeDatos baseDeDatos) {
		super();
		this.entityContacto = entityContacto;
		this.baseDeDatos = baseDeDatos;
	}

	public DaoContacto() {
		super();
	}

	public String SelectNombre() {

		String sql = "SELECT * from contacto where nombre LIKE '%" + entityContacto.getNombre() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String SelectTelefono() {

		String sql = "SELECT * from contacto where Telefono LIKE '%" + entityContacto.getTelefono() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String Selectapellidos() {

		String sql = "SELECT * from contacto where apellidos LIKE '%" + entityContacto.getApellidos() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String SelectfechaNacimiento() {

		String sql = "SELECT * from contacto where fecha='%" + entityContacto.getFechaNacimieto() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String Selectvinculo() {

		String sql = "SELECT * from contacto where vinculo LIKE '%" + entityContacto.getVinculo() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String Selectimagen() {

		String sql = "SELECT * from contacto where imagen LIKE '%" + entityContacto.getImagen() + "%'";
		return baseDeDatos.getTablaHTML(sql);

	}

	public String modificar() {

		String sql = "UPDATE `agenda`.`contacto` SET `nombre`='" + entityContacto.getNombre() + "', `telefono`='" + entityContacto.getTelefono()
				+ "', `fecha`='" + formato.format(entityContacto.getFechaNacimieto()) + "', `vinculo`='"
				+ entityContacto.getVinculo() + "', `imagen`='" + entityContacto.getImagen() + "' WHERE  `id`="
				+ entityContacto.getId();
		if (baseDeDatos.ejecutarActualizacionSQL(sql))
			return "Si pudo Actualizar";
		else
			return "No pudo Actualizar";

	}

	public String insertar() {

		String sql = "INSERT INTO `agenda`.`contacto` (`id`, `nombre`, `telefono`, `fecha`, `vinculo`, `imagen`)  VALUES ("
				+ entityContacto.getId() + ",'" + entityContacto.getNombre()+ "','"
				+ entityContacto.getTelefono() + "','" + formato.format(entityContacto.getFechaNacimieto()) + "','"
				+ entityContacto.getVinculo() + "','" + entityContacto.getImagen() + "')";
		System.out.println(sql);
		if (baseDeDatos.ejecutarActualizacionSQL(sql))
			return "Ha sido registrado";
		else
			return "No ha sido registrado";
	}

	public String eliminar() {

		String sql = "DELETE FROM `agenda`.`contacto` WHERE  `id`=" + entityContacto.getId();
		if (baseDeDatos.ejecutarActualizacionSQL(sql))
			return "Ha sido eliminado";
		else
			return "No ha sido eliminado";
	}

}
