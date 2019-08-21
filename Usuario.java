import java.sql.*;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
/**
 * Clase encargada de los datos del usuario y sus registros
 * 
 * @author (CEPEDA) 
 * @version (1.0 18/8/2019)
 */
public class Usuario extends Bd
{
   
    //Variables de datos personales del cliente
    private int id;
    private String cedula, nombre, apodo, ocupacion, estado, password, encrip;
    
    //Variables de uso 
    private Scanner a= new Scanner(System.in);
    private Scanner b=new Scanner(System.in);

      /**
      * Constructor para un nuevo usuario
      */
      public Usuario(int id)
      {
          this.id=id;
      }
      
       /**
      * Constructor para buscar un nuevo usuario
      */
      public Usuario(String cedula, String password)
      {
          this.cedula=cedula;
          this.password=password;
          encrip=Encrip(password);
      }
      
      /**
       * Devuelve el id del usuario
       */
      public int GetId()
      {
          return id;
      }

      /**
       * Método de ingreso de los datos personales del usuario
         */
      public void Datos()
      {
         System.out.println("\f\tDATOS PERSONALES :\n");
         System.out.println("Ingrese su nombre : ");
         nombre=a.nextLine();
   
         int right=0;
         while(right==0)
         {
             System.out.println("\nTiene algún apodo ó nombre de cariño que quiera utilizar(?)(si/no) ");
             //Variable local para confirmación
             //Variable Scanner
             String confir;
             confir=a.nextLine();
             //Variable local para el ingreso correcto de la respuesta
   
   
  
             if(confir.equals("si"))
             { 
                 SetApodo();
                 right=1;
                }
                else
                {
                    if(confir.equals("no"))
                    {
                        apodo=nombre;
                        right=1;
                    }
                    else
                    System.out.println("Entrada inválida, inténtelo de nuevo");
                }
            }  
         System.out.println("\fIngrese su cédula");
         cedula=a.nextLine();
         
         System.out.println("\nIngrese su ocupación");
         ocupacion=a.nextLine();
         
         int cond=0;
         
         do
         {
         
         System.out.println("\nIngrese su contraseña (sin números ni caracteres especiales)");
         password=a.nextLine();
         
         System.out.println("\nConfirme su contraseña");
         String p1;
         p1=a.nextLine();
       
         if(p1.equals(password))
         {
              System.out.println("\nContraseña guardada");
              System.out.println("Pulse una tecla para continuar");
              a.nextLine();
              encrip=Encrip(password);
              //guardar en la base de datos, pero encriptar antes de enviar
              cond=1;
         }
         else
         {
              System.out.println("\nContraseñas no coinciden, pulse una tecla");
              a.nextLine();
         }
        }while(cond==0);    
            
            System.out.println("\fGracias por ingresar sus datos personales "+apodo+", operación exitosa\n");  
            System.out.println("Pulse una tecla para continuar");
            a.nextLine();
        }
   
        /**
         * Agrega ó cambia el apodo del usuario, pedido anteriormente
         */
       public void SetApodo()
       {
           //Variable local para continuar
  
           String igual;
           int confirmar=0;;
    
           do
           {
               System.out.println("\nPor favor ingrese su apodo");
               apodo=b.nextLine();
               System.out.println("\n"+apodo + " es su apodo(?)(si/no)");
               igual=a.nextLine();
    
               if(igual.equals("si"))
               { 
      
                   System.out.println("\nSu apodo ha sido guardado exitosamente");  
                   System.out.println("\nPulse una tecla para continuar");
                   b.nextLine();
                   confirmar=1;
     
                }  
                else{
                    if(igual.equals("no"))
                    System.out.println("Inténtelo nuevamente\n");
           
           
                    else
                    System.out.println("Entrada inválida, inténtelo de nuevo");
                }
            }while(confirmar==0);
   
        }
        
         /**
         * Agrega ó cambia la contraseña del usuario
         */
       public void SetPassword()
       {
           //Variable local para continuar
    
           String igual, entrada;
           int confirmar=0;;
    
           do
           {
               System.out.println("\nPor favor ingrese su actual contraseña");
               entrada=a.nextLine();
    
               if(entrada.equals(password))
               { 
      
                   System.out.println("\n\nIngrese su nueva contraseña");  
                   password=a.nextLine();
         
                   System.out.println("\nConfirma que su nueva contraseña es "+password+" (?) (si/no)\n");
                   String confir;
                   confir=a.nextLine();
         
                   if(confir.equals("si"))
                   { 
                       System.out.println("\nContraseña guardada");
                       encrip=Encrip(password);
                       //guardar en la base de datos, pero encriptar antes de enviar
                       confirmar=1;
                    }
                    else
                    {
                        if(confir.equals("no"))
                        {
                            System.out.println("Inténtelo nuevamente\n");
                        }
                        else
                        System.out.println("Entrada inválida, inténtelo de nuevo");
                    }
     
                }  
                else{
                    System.out.println("Contraseña inválida, inténtelo de nuevo");
                }
            }while(confirmar==0);
   
        }
        
        /**
         * Agrega ó cambia la ocupación del usuario
         */
        public void SetOcu(String ocupacion)
        {
            this.ocupacion=ocupacion;
        }
        
         /**
         * Encripta contraseña
         */
        public String Encrip(String texto)
        {
            int codigo=10;
             StringBuilder cifrado = new StringBuilder();
             codigo = codigo % 26;
             for (int i = 0; i < texto.length(); i++) {
                 if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                     if ((texto.charAt(i) + codigo) > 'z') {
                         cifrado.append((char) (texto.charAt(i) + codigo - 26));
                        } else {
                            cifrado.append((char) (texto.charAt(i) + codigo));
                        }
                    } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                        if ((texto.charAt(i) + codigo) > 'Z') {
                            cifrado.append((char) (texto.charAt(i) + codigo - 26));
                        } else {
                            cifrado.append((char) (texto.charAt(i) + codigo));
                        }
                    }
                }
                return cifrado.toString();
        }
        
        /**
         * Desencripta Contraseña
         */
        public String Desencript(String texto)
        {
            int codigo=10;
            StringBuilder cifrado = new StringBuilder();
            codigo = codigo % 26;
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }
            }
            return cifrado.toString();
        }
        
        /**
         * Crea los datos en la base de datos
         */
        public void Crear()throws SQLException
        {
                String sql = "INSERT INTO usuario (id, cedula, nombre, apodo, ocupacion, estado, password) VALUES (?,?,?,?,?,?,?)";
                
                conectar();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2,cedula);
                ps.setString(3,nombre);
                ps.setString(4,apodo);
                ps.setString(5,ocupacion);
                ps.setString(6,estado);
                ps.setString(7,encrip);
                ps.execute();
                ps.close();
                desconectar();
        }
        
        /**
         * Busca un registro de usuario e importa sus datos
         */
        public boolean Buscar()throws SQLException
        {
            boolean decision=true;
            String ced, ids="";
            
           
            String sql="SELECT id FROM usuario WHERE (cedula like "+cedula+") AND (password like (?))"; //solo cedula
            conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            //ps.setString(1, cedula);
            ps.setString(1, encrip);
            ResultSet resultSet=ps.executeQuery();
            while(resultSet.next()){
            ids=resultSet.getString("id");
            /*System.out.println(resultSet.getString("id"));
            System.out.println("Pulse una tecla para continuar");*/
            a.nextLine();
            }
           
             
            if(ids=="")
            {
            decision=false;
            }
            else id=Integer.parseInt(ids);
            
            ps.close();
            desconectar();
            return decision;
        }
         
}
