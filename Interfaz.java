
/**
* Clase que representa la interfaz que interactuará con el usuario
* @author (CEPEDA)
* @version (1.0 22/08/2019)
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;   
import java.io.ObjectOutputStream; 
import java.io.FileReader;
import java.io.BufferedReader;

public class Interfaz 
{
  Scanner lee=new Scanner(System.in); 
  Scanner le=new Scanner(System.in); 
  Scanner leer=new Scanner(System.in);
  Scanner ingreso=new Scanner(System.in);
  Scanner ingres=new Scanner(System.in);
  Scanner conti= new Scanner(System.in);
  Scanner leo=new Scanner(System.in);
  Scanner entrada=new Scanner(System.in);
  Scanner respuesta=new Scanner(System.in);
  
 
  
  Registros r= new Registros();
  Horario h= new Horario();
 
  
/**
  * Menú principal de la aplicación
  */   
public void menu(Usuario user)
   {
        
  
    int respuesta;
    System.out.println("\f\tMenú principal\n");
    System.out.println("1. Ver tareas");
    System.out.println("2. Ver horario");
    System.out.println("3. Opciones personales");
    System.out.println("4. Ingresar tarea");
    System.out.println("5. Ingresar horario");
    System.out.println("6. Registros");
    System.out.println("7. Acerca de");
    System.out.println("8. Salir\n");
    System.out.println(user.GetApodo());
    System.out.println("Su estado de rendimiento es "+user.GetEstado());
    respuesta=lee.nextInt();
   
    switch(respuesta)
    {
        case 1:
        r.imprimirActuales();
        menu(user);
        break;
        
        case 2:
        h.visualizar();
        menu(user);
        break;
        
        case 3:
        segundoMenu(user);
        menu(user);
        break;
        
        case 4:
        crearTarea(user);
        menu(user);
        break;
        
        case 5:
        crearHorario(user);
        menu(user);
        break;
        
        case 6:
        primerMenu(user);
        menu(user);
        break;
        
        case 7:
        infor();
        menu(user);
        break;
        
     
        case 8:
        {
        System.out.println("\fGracias por usar nuestro software");
        le.nextLine();
        System.out.println("\f");
        
  

    }   
        break;
    }  
    menu(user);
}

 
   /**
  * Menú de opciones de tareas
  */   
 private void primerMenu(Usuario user)
{
    System.out.println("\f");
    int respuesta;
    
    System.out.println("1. Ver todos mis tareas");
    System.out.println("2. Exportar mi horario");
    System.out.println("3. Regresar");
    
    respuesta=leo.nextInt();
    
    switch(respuesta)
    {
        case 1:
        r.imprimirTodasTareas();
        primerMenu(user);
        break;
        
        case 2:
        h.exportarInforme();
        primerMenu(user);
        break;
        
    
       
        
        case 3:
        menu(user);
        break;
    }
    primerMenu(user);
}


/**
  * Menú para agregar ó modificar el nombre preferido del usuario 
  */   
     private void segundoMenu(Usuario user)
{
    System.out.println("\f");
    
    int respuesta;
    
   
    System.out.println("1. Cambiar apodo ó agregarlo");
    System.out.println("2. Regresar");
    
    respuesta=lee.nextInt();
    System.out.println("\f");
    
    switch(respuesta)
    {
       
        case 1:
        user.SetApodo();
        break;
        
        case 2:
        menu(user);
        break;
        
      
    }

    menu(user);


}

/**
  * Opción seleccionada anteriormente; agregar una nueva tarea
  */   
private void crearTarea(Usuario user)
{
    Tarea t= new Tarea();
    t.Generar(user);
    try
                 {
                   t.Crear();
                 }
                 catch(Exception e)
                 {
                        System.out.println("\fError técnico, contacte a su asesor");
                        System.out.println("Lo lamentamos");
                        System.out.println("\n\nPulse una tecla para continuar");
                        leo.nextLine();
                 }
    
    menu(user);
}

/**
  * Opción seleccionada anteriormente; agregar un nuevo horario
  */   
private void crearHorario(Usuario user)
{
    Horario h= new Horario();
    h.Generar(user);
    try
                 {
                   h.Crear();
                 }
                 catch(Exception e)
                 {
                        System.out.println("\fError técnico, contacte a su asesor");
                        System.out.println("Lo lamentamos");
                        System.out.println("\n\nPulse una tecla para continuar");
                        leo.nextLine();
                 }
    menu(user);
}


    
  

/**
 * Información acerca de ADMINISTRADOR FINANCIERO PERSONAL:
 */
private void infor()
{
    System.out.println("\fAcerca de :\n");
    System.out.println("Administrador Personal de tareas\n");
    System.out.println("No te preocupes por el manejo de tus actividades, nosotros las manejamos");
    System.out.println("Qué esperas para comenzar a ingresar tareas & alcanzar tus sueños(?)");
    System.out.println("No lo olvides nunca; no administramos tus tareas y horarios, administramos tus sueños y potencial");
    System.out.println("\nVersión 1.0");
    System.out.println("Brayan Orlando Rivera Cepeda");
    System.out.println("Contáctanos: riveracepedabrayan@gmail.com");
    System.out.println("BlueJ. 2019");
    System.out.println("28/08/2019");
    System.out.println("UNIVERSIDAD INDUSTRIAL DE SANTANDER\n");
    System.out.println("Pulse una tecla para continuar");
    conti.nextLine();
  }

 
  
}
