import java.sql.*;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

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
Scanner mouse=new Scanner(System.in);
Scanner puntero=new Scanner(System.in);
Scanner rata=new Scanner(System.in);
Scanner tecla=new Scanner(System.in);

/**
* Agrega un horario
*@param se requiere un usuario
*/
public void Generar(Usuario usuario)
{
    this.idUsuario=usuario.GetId();
    String resp;
    System.out.println("\nPor favor ingrese el identificador para su nuevo horario");
    idHorario=puntero.nextInt();
    System.out.println("\nPor favor escriba la fecha actual (dd/mm/aa)");
    fechaInicio=tecla.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día lunes separada por horas");
    lunes=mouse.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día martes separada por horas");
    martes=teclado.nextLine();
    System.out.println("\nPor favor escriba la descripción para el día miercoles separada por horas");
    miercoles=rata.nextLine();
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

public void exportarInforme()
{ 
        try
                 {
                 FileWriter fw=new FileWriter("informe.txt");
                 fw.write("\f\tHorario n. "+idHorario);
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("\tLUNES\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write(lunes);
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("\tMARTES\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write(martes);
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("\tMIERCOLES\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write(miercoles);
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("\tJUEVES\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write(jueves);
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write("\tVIERNES\n");
                 fw.write("\r\n");
                 fw.write("\r\n");
                 fw.write(viernes);
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 fw.write("**************************************");
                 fw.write("\r\n");
                 
                 
                 fw.close();
                 }
                 catch(Exception e)
                 {
                        System.out.println("\fError técnico, contacte a su asesor");
                        System.out.println("Lo lamentamos");
                        System.out.println("\n\nPulse una tecla para continuar");
                        b.nextLine();
                 }
           
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
                ps.setString(6,martes);
                ps.setString(7,miercoles);
                ps.setString(8,jueves);
                ps.setString(9,viernes);
                ps.execute();
                ps.close();
                desconectar();
}



}
