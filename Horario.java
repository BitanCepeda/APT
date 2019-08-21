import java.sql.*;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
   /**
* Clase de tarea
* @author (Cepeda)
* @version (1.0 20/8/2019)
*/
public class Horario extends Bd
{

private int idUsuario;
private int idHorario;
private String fechaInicio;
private String fechaFin;
private String lunes;
private String martes;
private String miercoles;
private String jueves;
private String viernes;

Scanner teclado=new Scanner(System.in);
Scanner tecla=new Scanner(System.in);

/**
* Agrega una Tarea
*@param se requiere un usuario
*/
public Horario(Usuario usuario)
{
    this.idUsuario=usuario.GetId();
    String resp;
    System.out.println("\nPor favor ingrese el identificador para su nuevo horario");
    idHorario=teclado.nextInt();
    System.out.println("\nPor favor escriba la fecha actual (dd/mm/aa)");
    fechaInicio=tecla.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día lunes separada por horas");
    lunes=teclado.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día martes separada por horas");
    martes=teclado.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día miercoles separada por horas");
    miercoles=teclado.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día jueves separada por horas");
    jueves=teclado.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día viernes separada por horas");
    viernes=teclado.nextLine();
   
    System.out.println("\nHorario agregado correctamente");
    System.out.println("\nPulse una tecla para continuar");
    teclado.nextLine();
    
}

/**
* Retorna el nombre otorgado a la tarea
*/
public int getId()
{
    return idHorario;
}

/**
* Retorna la La impresión del horario
*/
public void visualizar()
{ 
        System.out.println("\f\tHorario n. "+idHorario);
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\tLUNES\n");
         System.out.println(lunes);
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\tMARTES\n");
         System.out.println(martes);
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\tMIERCOLES\n");
         System.out.println(miercoles);
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\tJUEVES\n");
         System.out.println(jueves);
         System.out.println("**************************************");
         System.out.println("**************************************");
          System.out.println("\tVIERNES\n");
         System.out.println(viernes);
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\n\nPulse una tecla para continuar");
         b.nextLine();
           
}

/**
 * Guarda el horario en la base de datos
 */
public void Crear()throws SQLException
{
    String sql = "INSERT INTO horario (idh, feinih, fefinh, iduser, lunes, martes, miercoles, jueves, viernes) VALUES (?,?,?,?,?,?,?, ?,?)";
                
                conectar();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, idHorario);
                ps.setString(2,fechaInicio);
                ps.setString(3,fechaFin);
                ps.setInt(4,idUsuario);
                ps.setString(5,lunes);
                ps.setString(5,martes);
                ps.setString(5,miercoles);
                ps.setString(5,jueves);
                ps.setString(5,viernes);
                ps.execute();
                ps.close();
                desconectar();
}



}
