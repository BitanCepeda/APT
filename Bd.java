import java.util.Scanner;
import java.sql.*;
/**
 * Clase encargada de la persistencia de los datos en la base de datos
 * 
 * @author (CEPEDA) 
 * @version (1.0 19/8/2019)
 */

public class Bd
{
    
    //variables de uso
    Scanner b=new Scanner(System.in);
    
    // instance variables - replace the example below with your own
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:aptdb.sqlite";

    Connection conexion;
    /**
     * Método para realizar la conexión de la base de datos
     */
    protected void conectar() throws SQLException
     {
        try{
            Class.forName(DRIVER);
            System.out.println("\f\tConexión a la base de datos exitosa");
            System.out.println("\n Pulse una tecla para continuar");
            b.nextLine();
        } catch(Exception e){
            System.out.println(e);
            System.out.println("\f\tConexión a la base de datos exitosa");
            System.out.println("\n Pulse una tecla para continuar");
            b.nextLine();
        }
        
        conexion = DriverManager.getConnection(URL);
    }
    
    /**
     * Método para realizar la desconexión de la base de datos
     */
    protected void desconectar() throws SQLException
    {
        conexion.close();
    }
}