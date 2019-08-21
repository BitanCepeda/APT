import java.sql.*;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
   /**
* Clase de tarea
* @author (Cepeda)
* @version (1.0 20/8/2019)
*/
public class Tarea extends Bd
{

private int idUsuario;
private String nombre;
private String clasificacion;
private String fechaInicio;
private String fechaFin;
private double avance;
private int nroItems;
Scanner teclado=new Scanner(System.in);
Scanner tecla=new Scanner(System.in);

/**
* Agrega una Tarea
*@param se requiere un usuario
*/
public Tarea(Usuario usuario)
{
    this.idUsuario=usuario.GetId();
    String resp;
    System.out.println("\nPor favor ingrese el nombre de la tarea");
    nombre=teclado.nextLine();
    System.out.println("\nPor favor ingrese el tipo de tarea");
    System.out.println("urgente, necesaria, básica u opcional");
    clasificacion=teclado.nextLine();
    System.out.println("\nPor favor escriba la fecha actual (dd/mm/aa)");
    fechaInicio=teclado.nextLine();
    System.out.println("\n¿Desea dividir la tarea en ítems? (si/no)");
    resp=tecla.nextLine();
    
    if(resp.equals("si"))
    {
      System.out.println("\n¿En cuántos ítems desea dividirla?");
      nroItems=teclado.nextInt();
    }
    
    System.out.println("\nPulse una tecla para continuar");
    teclado.nextLine();
    
}

/**
* Retorna el nombre otorgado a la tarea
*/
public String getNombre()
{
    return nombre;
}

/**
* Retorna la clasificacion de la tarea
*/
public String getClasificacion()
{ 
    return clasificacion;
}

/**
* Retorna el porcentaje de desarrollo del proyecto
*/
public double getAvance()
{
    return avance;
}


/**
* Modifica el porcentaje de desarrollo de la tarea por items
*/
public void setDesarrollo(int nroItems)
{
    double result;
    result=(100/this.nroItems)*nroItems;
    this.avance=result;
    System.out.println("La tarea tiene un "+this.avance+"% de desarrollo");

}

/**
 * Desarrolla la tarea 
 */
public void Desarrollar(int avance)
{
    this.avance=avance;
}

/**
 * Guarda la tarea en la base de datos
 */
public void Crear()throws SQLException
{
    String sql = "INSERT INTO tarea (nombret, idus, clasif, finicio, fin, avance, nroitems) VALUES (?,?,?,?,?,?,?)";
                
                conectar();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setInt(2,idUsuario);
                ps.setString(3,clasificacion);
                ps.setString(4,fechaInicio);
                ps.setString(5,fechaFin);
                ps.setDouble(6,avance);
                ps.setInt(7,nroItems);
                ps.execute();
                ps.close();
                desconectar();
}



}
