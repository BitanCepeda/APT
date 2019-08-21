import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
/**
 * Clase principal encargada de la ejecución del software
 * 
 * @author (CEPEDA) 
 * @version (1.0 18/8/2019)
 */
public class App
{
     public static void main(String[] args)throws Exception
     {
          //Variables de uso 
         Scanner a= new Scanner(System.in);
         Scanner b=new Scanner(System.in);
         Scanner c=new Scanner(System.in);
         Scanner d=new Scanner(System.in);
         int opc;
         
         System.out.println("\f**************************************");
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\tBIENVENIDO A APT\n");
         System.out.println("\tADMINISTRADOR PERSONAL DE TAREAS\n");
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("**************************************");
         System.out.println("\n\nPulse una tecla para continuar");
         b.nextLine();
           
         int condt=0;
         
         while(condt==0)
         {
         
         
         System.out.println("\f\tINICIAR\n\n");
         System.out.println("\n1. Ingresar\n");
         System.out.println("\n2. Crear cuenta\n");
         System.out.println("\n3. Salir\n");
         opc=a.nextInt();
         
         if(opc==1)
         {
             String ced, pass;
             //Persistencia de datos
             System.out.println("\f\tINICIO DE SESIÓN");
             System.out.println("\nIngrese cedula\n");
             ced=b.nextLine();
             System.out.println("\nIngrese su password\n");
             pass=c.nextLine();
             Usuario usuario;
             usuario=new Usuario(ced, pass);
           
             
             if(usuario.Buscar()==false)
             {
                  System.out.println("\fNo se ha encontrado su cuenta");
                  System.out.println("\nVerifique sus credenciales ó cree una nueva");
                  System.out.println("\n\nPulse una tecla para continuar");
                  c.nextLine();
             }
             else
             {
                  System.out.println("\f\tBienvenido de nuevo");
                  System.out.println("\nsu id es "+usuario.GetId()+"\n");
                  System.out.println("\n\nPulse una tecla para continuar");
                  d.nextLine();
                  condt=1;
             }
                
             
         }
         else
         {
             if(opc==2)
             {
                  String entrada="";
                  String entrada2="";
                  try
                        {
                        FileReader lector=new FileReader("id.txt");
                        BufferedReader contenido=new BufferedReader(lector);
                        
                        
                        while((entrada=contenido.readLine())!=null)
                        {
                           entrada2=entrada;
                        }
                        lector.close();
                        }
                        
                        catch(Exception e)
                        {
                        System.out.println("\fError técnico, contacte a su asesor");
                        System.out.println("Lo lamentamos");
                        System.out.println("\n\nPulse una tecla para continuar");
                        b.nextLine();
                        condt=1;
                        }
                 int id;
                 id=Integer.parseInt(entrada2);
                 id=id+1;
                 String ids = Integer.toString(id);
                 try
                 {
                 FileWriter fw=new FileWriter("id.txt");
                 fw.write(ids);
                 fw.close();
                 }
                 catch(Exception e)
                 {
                        System.out.println("\fError técnico, contacte a su asesor");
                        System.out.println("Lo lamentamos");
                        System.out.println("\n\nPulse una tecla para continuar");
                        b.nextLine();
                 }
                 
                 
                 Usuario usuario;
                 usuario=new Usuario(id);
                 usuario.Datos();
                 usuario.Crear();
                 condt=1;
             }
             else
             {
                 if(opc==3)
                 System.exit(0);
                 
                 else
                 System.out.println("Entrada inválida");
            }
         }
        }
         
     }
}
