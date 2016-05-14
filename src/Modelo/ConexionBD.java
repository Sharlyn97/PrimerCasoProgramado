

package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    String arregloInformacionConsultada[]=new String[2];
    public String sigla="";
    public String cedula="";
    public String nombre="";
    public String nombreCurso="";
    String arregloCursos[]=new String[3];
    
    public ConexionBD()
    {
        realizarConexion();
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+cedula+"','"+nombre+"','"+direccion+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
      public boolean registrarCurso(String sigla, String nombre, int creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+sigla+"','"+nombre+"','"+creditos+"','"+horario+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
      public boolean registrarUsuario(String nombre, String usuario, String contraseña, String tipo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuarios(nombreUsuario, password, nombres, tipo) VALUES ('"+usuario+"','"+contraseña+"','"+nombre+"','"+tipo+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
       public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        String codigo=arreglo[0];
        String cedula=arreglo[1];
        String sigla=arreglo[2];
        boolean ejecuto;
        boolean ejecutoDos;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula(numero, cedula) VALUES ('"+codigo+"','"+cedula+"')");
                ejecutoDos = cmd.execute("INSERT INTO detalle_matricula(numero, sigla) VALUES ('"+codigo+"','"+sigla+"')");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
    public boolean actualizarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `estudiantes` SET cedula='"+cedula+"',nombre='"+nombre+"',direccion='"+direccion+"' WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
     public boolean actualizarCursos(String sigla, String nombre, int creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `cursos` SET sigla='"+sigla+"',nombre='"+nombre+"',creditos='"+creditos+"',horario='"+horario+"' WHERE sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
     public boolean actualizarUsuario(String nombre, String usuario,String contraseña, String tipo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE usuarios SET nombres='"+nombre+"',nombreUsuario='"+usuario+"',password='"+contraseña+"',tipo='"+tipo+"' WHERE nombreUsuario='"+usuario+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
     public boolean actualizarMatricula(String codigo, String cedula, String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        boolean ejecutoDos;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE matricula SET numero='"+codigo+"',cedula='"+cedula+"'");
                ejecutoDos = cmd.execute("UPDATE detalle_matricula SET numero='"+codigo+"','"+sigla+"')");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
     
     public boolean eliminarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiantes WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos WHERE sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
      public boolean eliminarUsuario(String nombre)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuarios WHERE nombres='"+nombre+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
      public boolean eliminarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        boolean ejecutoDos;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM matricula WHERE codigo='"+codigo+"'");
                ejecutoDos = cmd.execute("DELETE FROM detalle_matricula WHERE codigo='"+codigo+"')");
                
                
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
    public void consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("direccion");
                    arregloInformacionConsultada[0]=nombre;
                    arregloInformacionConsultada[1]=direccion;
                    System.out.println("Información de la BD: "+nombre+" Direccion: "+direccion); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
    public boolean consultarEstudiantes(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("direccion");
                    arregloInformacionConsultada[0]=nombre;
                    arregloInformacionConsultada[1]=direccion;
                    System.out.println("Información de la BD: "+nombre+" Direccion: "+direccion); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     public void consultarCursos(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    System.out.println("Información de la BD: "+nombre+" Creditos: "+creditos+" Horario: "+horario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
     public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    arregloCursos[0]=nombre;
                    arregloCursos[1]=""+creditos;
                    arregloCursos[2]=horario;
                    System.out.println("Información de la BD: "+nombre+" Creditos: "+creditos+" Horario: "+horario); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     
     public String[] retornarCursos()
     {
         return this.arregloCursos;
     }
     public boolean consultarUsuario(String nombre)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombres='"+nombre+"'");
                
                while (rs.next()) 
                {
                    String usuario = rs.getString("nombreUsuario");
                    String contraseña = rs.getString("password");
                    String tipo = rs.getString("tipo");
                    System.out.println("Información de la BD: Usuario "+usuario+" Tipo: "+tipo); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     
        public boolean consultarUsuarios(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        String nombreUsuario=arreglo[0];
        String password=arreglo[1];        
        boolean encontroUsuario=false;
     
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombreUsuario='"+nombreUsuario+"'");
                
                while (rs.next()) 
                {
                  String usuario = rs.getString("nombreUsuario");
                  String contraseña = rs.getString("password");
                  if(nombreUsuario.equals(usuario) && password.equals(contraseña))
                  {
                      encontroUsuario=true;
                  }
                        
                    
                    System.out.println("Información de la BD: Usuario "+usuario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Este SQLException ejecutando sentencia: " + e.getMessage());
        }
   
      
        return encontroUsuario;
    }
     
      public boolean consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        ResultSet rsDM = null;
        ResultSet rsE = null;
        ResultSet rsC = null;
        
        Statement cmd = null;
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula where numero='"+codigo+"'");
                rsDM = cmd.executeQuery("SELECT * FROM detalle_matricula where numero='"+codigo+"'");
                System.out.println("numero de codigo: "+codigo);
                while (rs.next()) 
                {
                     cedula = rs.getString("cedula");
                     sigla = rsDM.getString("sigla");
                     
                     rsE = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                     rsC = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                     
                     nombre = rsE.getString("nombre");
                     nombreCurso = rsC.getString("nombre");
                     
                     
                     
                    //String sigla = rs.getString("sigla");
                   // arregloInformacionConsultada[0]=cedula;
                    
                    //
                    //arregloInformacionConsultada[1]=sigla;
                    System.out.println("Información de la BD cedula: "+cedula);//+" Direccion: "+sigla); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
      
      
      
        public String devolverCodigo()
    {
        ResultSet rs = null;
        Statement cmd = null;
        String filas= "";
        String codigo;
        
         try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(numero) FROM matricula");
                
                while (rs.next()) 
                {
                    filas=""+rs.getInt(1);
                   
                    System.out.println(filas); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        if(filas.equals(0))
        {
            codigo="1";
         }
       else
        {
            int numero=Integer.parseInt(filas);
            numero++;
            codigo=""+numero;
        }
        
        return codigo; 
    }
        
     public boolean comprobarUsuario()
     {
        ResultSet rs = null;
        Statement cmd = null;
        boolean hayUsuarios=false;
        String filas= "";
        String codigo;
        
         try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(nombres) FROM usuarios");
                
                while (rs.next()) 
                {
                    filas=""+rs.getInt(1);
                    if(filas.equals("0"))
                    {                
                      hayUsuarios=false;
                    }else
                    {
                        hayUsuarios=true;
                    }
                    System.out.println(filas); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
         return hayUsuarios;
     }
     
    
     
     public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
}
