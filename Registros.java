import java.util.Scanner;
import java.util.ArrayList;
/**
 * Clase encargada de los registros y opción de exportar
 * 
 * @author (CEPEDA) 
 * @version (1.0 22/08/2019)
 */
public class Registros
{
    private ArrayList<Tarea> tareas= new ArrayList<Tarea>();
    private ArrayList<Tarea> tareasActu= new ArrayList<Tarea>();
    private ArrayList<Tarea> tareasTermi= new ArrayList<Tarea>();
    
    
/**
 * Agregar una tarea
 */
public void Add(Tarea tarea)
{
    tareas.add(tarea);
}

   
/**
* Ver una tarea
*/
public Tarea VerUnaTarea(String nombre)
{
    //variable para proyecto encontrado
    Tarea tar= new Tarea();
    
     for(Tarea tareita: tareas)
    {
        if(nombre.equals(tar.getNombre()))
        {
           tar=tareita;
           break;
        }
    }
    
    return tar;
}

/**
* Imprimir una tarea
*/
public void imprimirUnaTarea(String nombre)
{
      for(Tarea tareita: tareas)
    {
        if(nombre.equals(tareita.getNombre()))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId());
        }
    }
    
}

/**
* Retorna todas las tareas
*/
public ArrayList<Tarea> VerTodos()
{
  return tareas;
}

/**
* Imprimir todas las tareas por clasificacion
*/
public void imprimirTodasTareas()
{
    
        System.out.println("\n\tURGENTES");
         for(Tarea tareita: tareas)
    {
        if(tareita.getClasificacion().equals("urgente"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
         System.out.println("\n\tNECESARIAS");
               for(Tarea tareita: tareas)
    {
        if(tareita.getClasificacion().equals("necesaria"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
    
         System.out.println("\n\tBÁSICAS");
               for(Tarea tareita: tareas)
    {
        if(tareita.getClasificacion().equals("basica"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
         System.out.println("\n\tOPCIONALES");
               for(Tarea tareita: tareas)
    {
        if(tareita.getClasificacion().equals("opcional"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
}



/**
* Mostrar tareas actuales  y agregar---- Avance < 100 
*/
public ArrayList<Tarea> verActuales()
{
    
    
 for(Tarea tareita: tareas)
    {
        if(tareita.getAvance()<100)
        {
           tareasActu.add(tareita);
           break;
        }
    }
    return tareasActu;
}


/**
* Imprime las tareas actuales
*/
public void imprimirActuales()
{
    
    
        System.out.println("\n\tURGENTES");
         for(Tarea tareita: tareasActu)
    {
          if(tareita.getClasificacion().equals("urgente"))
        
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
         System.out.println("\n\tNECESARIAS");
               for(Tarea tareita: tareasActu)
    {
        if(tareita.getClasificacion().equals("necesaria"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
    
         System.out.println("\n\tBÁSICAS");
               for(Tarea tareita: tareasActu)
    {
        if(tareita.getClasificacion().equals("basica"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
         System.out.println("\n\tOPCIONALES");
               for(Tarea tareita: tareasActu)
    {
        if(tareita.getClasificacion().equals("opcional"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
}


/**
* Mostrar tareas realizadas  y agregar---- Avance < 100 
*/
public ArrayList<Tarea> verRealizadas()
{
    
    
 for(Tarea tareita: tareas)
    {
        if(tareita.getAvance()==100)
        {
           tareasTermi.add(tareita);
           break;
        }
    }
    return tareasTermi;
}


/**
* Imprime las tareas realizadas
*/
public void imprimirRealizadas()
{
    
    
        System.out.println("\n\tURGENTES");
         for(Tarea tareita: tareasTermi)
    {
          if(tareita.getClasificacion().equals("urgente"))
        
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
         System.out.println("\n\tNECESARIAS");
               for(Tarea tareita: tareasTermi)
    {
        if(tareita.getClasificacion().equals("necesaria"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
    
         System.out.println("\n\tBÁSICAS");
               for(Tarea tareita: tareasTermi)
    {
        if(tareita.getClasificacion().equals("basica"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }  
    
         System.out.println("\n\tOPCIONALES");
               for(Tarea tareita: tareasTermi)
    {
        if(tareita.getClasificacion().equals("opcional"))
        {
        System.out.println(tareita.getNombre());
        System.out.println(tareita.getClasificacion());
        System.out.println(tareita.getFechaInicio());
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getAvance()+"%");
        System.out.println(tareita.getFechaFin());
        System.out.println(tareita.getNro());
        System.out.println(tareita.getId()+"\n\n");
        }
    }
    
}

/**
 * Retorna el estado de eficiencia del usuario
 */
public String generarEstado()
{
    String estado="";
    double suma=0, cont=0, prom;
    
    for(Tarea tareita: tareas)
    {
      cont=cont+1;
      suma=suma+tareita.getAvance();
    }
    
    prom=(suma/cont);
    
    if(prom<=30)
    {
    estado="atrasado";
    }
    else
    {
        if(prom>30 && prom<=70)
        {
            estado="normal";
        }
        else
        estado="eficiente";
    }
    
    return estado;
}


   
}
