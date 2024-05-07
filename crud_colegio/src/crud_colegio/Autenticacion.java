package crud_colegio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class Autenticacion {
	    
	    static final String JDBC_DRIVER = "org.postgresql.Driver";
	    static final String DB_URL = "jdbc:postgresql://localhost/Colegio";
	    static final String USER = "POSTGRES";
	    static final String PASS = "1234";

	    public static void main(String[] args) {
	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	            
	            Class.forName(JDBC_DRIVER);

	            
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);

	          
	            String nombreUsuario = "rector";
	            String contraseña = "rector123";

	           
	            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, nombreUsuario);
	            stmt.setString(2, contraseña);
	            ResultSet rs = stmt.executeQuery();

	            
	            if (rs.next()) {
	               
	                System.out.println("¡Inicio de sesión exitoso!");
	                
	                String rol = obtenerRol(conn, rs.getInt("id"));
	               
	                if (rol.equals("rector")) {
	                    
	                    System.out.println("Redirigiendo al CRUD completo...");
	                } else if (rol.equals("alumno")) {
	                   
	                    System.out.println("Redirigiendo a la visualización de asignaturas...");
	                }
	            } else {
	                
	                System.out.println("Error: Credenciales inválidas. Por favor, inténtalo de nuevo.");
	            }

	            
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            
	            se.printStackTrace();
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	        } finally {
	            
	            try {
	                if (stmt != null) stmt.close();
	            } catch (SQLException se2) {
	            }
	            try {
	                if (conn != null) conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    }

	    public static String obtenerRol(Connection conn, int usuarioId) throws SQLException {
	        String rol = "";
	        PreparedStatement stmt = null;
	        String sql = "SELECT rol FROM permisos WHERE usuario_id = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, usuarioId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            rol = rs.getString("rol");
	        }
	        rs.close();
	        stmt.close();
	        return rol;
	    }
	}
}
