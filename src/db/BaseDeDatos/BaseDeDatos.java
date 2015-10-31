/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db.BaseDeDatos;

import Middler.JDBCMiddler;
import java.sql.ResultSet;

/**
 *Clase que permite conectar con una Base De datos Mysql; sin embargo,
 * con solo cambiar el atributo controlador puede usarse para cualquier motor de base de datos
 * @author madarme
 */
public class BaseDeDatos {
private String nombreBD = "agenda";
private String userName = "root";
private String password = "1234";
private String url = "jdbc:mysql://localhost:3306/"+nombreBD;
private String controlador="com.mysql.jdbc.Driver";
private JDBCMiddler jdbc;


    public BaseDeDatos() {
        crear();
    }

    public BaseDeDatos(String bd, String login, String password, String url)
    {
        this.nombreBD=bd;
        this.userName=login;
        this.password=password;
        this.url=url;
        crear();
    }

    private void crear()
    {
        this.jdbc=new JDBCMiddler(this.controlador,this.url,this.userName,this.password);
        try{
        this.jdbc.conectar();
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public boolean ejecutarActualizacionSQL(String comandoSQL)
    {
        try{
            return (this.jdbc.ejecutarActualizacionSQL(comandoSQL));
        }catch(Exception e)
        {
                System.err.println("SQL Error:"+e.getMessage());
                return (false);
        }
    }

    public String getTablaHTML(String sql)
    {
    try{
            return (this.jdbc.getHTML(sql));
        }catch(Exception e)
        {
                System.err.println("SQL Error:"+e.getMessage());
                e.printStackTrace();
                return ("No se pudo crear la tabla");
        }
    }
    
    public String getTablaHTMLOrden(String sql)
    {
    try{
            return (this.jdbc.getHTMLOrden(sql));
        }catch(Exception e)
        {
                System.err.println("SQL Error:"+e.getMessage());
                e.printStackTrace();
                return ("No se pudo crear la tabla");
        }
    }
    
    public String getTablaHTMLSimple(String sql)
    {
        try{
                return (this.jdbc.getHTMLSimple(sql));
            }catch(Exception e){
                    System.err.println("SQL Error:"+e.getMessage());
                    e.printStackTrace();
                    return ("No se pudo crear la tabla");
            }
    }

    public java.util.ArrayList<String>  getConsultaSQL(String sql)
    {
    try{
            return (this.jdbc.getSQL(sql));
        }catch(Exception e)
        {
                System.err.println("SQL Error:"+e.getMessage());
                return (null);
        }    
    }

    public ResultSet ejecutarSQL(String sql)
    {
    try{
            return (this.jdbc.ejecutarSQL(sql));
        }catch(Exception e){
                System.err.println("SQL Error:"+e.getMessage());
                return null;
        }
    }

    public int getConsecutivo(String tabla,String llave)
    {
        try{
            ResultSet rs=this.jdbc.ejecutarSQL("select max("+llave+") consecutivo from "+tabla);
            if(rs.next())
                return rs.getInt("consecutivo")+1;
            else
                return 0;
        }catch(Exception e){
                System.err.println("SQL Error:"+e.getMessage());
                return 0;
        }
    }
    
    public static void main(String args[])
    {
        BaseDeDatos x=new BaseDeDatos();
        String sql="INSERT INTO `agenda`.`contacto` (`id`, `nombre`, `telefono`, `fecha`, `vinculo`) VALUES (2, 'Andres', '31654525', '24/23/2015', 'fanilia')";
        if(x.ejecutarActualizacionSQL(sql))
            System.out.println("Si pudo insertar");
        else
            System.out.println("No pudo insertar");

        sql="select * from contacto";
            System.out.println(x.getTablaHTML(sql));
    }

}
