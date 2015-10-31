package test;

import java.util.Date;

import db.BaseDeDatos.BaseDeDatos;
import modelo.DaoContacto;
import modelo.EntityContacto;

public class Test {
	
	public static void main(String args[])
    {
        EntityContacto entityContacto=new EntityContacto("o", "apellidossss", "123456", "materno", "c:", 3 ,new Date());
    	BaseDeDatos baseDeDatos= new BaseDeDatos();
    	DaoContacto dao=new DaoContacto(entityContacto, baseDeDatos);
    	
    	//System.out.println(dao.insertar());
    	//System.out.println(dao.eliminar());
    	//System.out.println(dao.modificar());
    	System.out.println(dao.SelectNombre());
    }
	

}
