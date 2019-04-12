package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.datos.Conexion;

public class Operaciones {
	public static void MostrarDatos() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM prueba");

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				int edad = rs.getInt(4);
				String direccion = rs.getString(5);
				System.out.println(idUsuario + " - " + first_name + " , " + last_name +  " , " + edad +  " , " + direccion);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void insertarDatos() {
		 Conexion conexion = new Conexion();
		 Connection con = null;
	     PreparedStatement pst = null;
	     Statement stm = null;
		 ResultSet rs = null;
	     try {
	    	 String query = " INSERT INTO prueba (nombre, apellido, edad, telefono)"
	    		        + " values (?, ?, ?, ?)";
	    	 con = conexion.conectar();
	    	 PreparedStatement preparedStmt = con.prepareStatement(query);
	    	 preparedStmt.setString (1, LeerStrings.leerString("Introduce el nombre"));
	         preparedStmt.setString (2, LeerStrings.leerString("Introduce el apellido"));
	         preparedStmt.setInt(3, LeerStrings.leerInt("Introduce tu edad"));
	         preparedStmt.setString (4, LeerStrings.leerString("Introduce el telefono"));
	         preparedStmt.execute();
	         System.out.println("Datos insertados");
	     } catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (rs != null) {
						rs.close();
					}

					if (stm != null) {
						stm.close();
					}

					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
        
	}
	
	public static void actualizarDatos() {
		 Conexion conexion = new Conexion();
		 Connection con = null;
	     PreparedStatement pst = null;
	     Statement stm = null;
		 ResultSet rs = null;
	     try {
	    	 String query = " UPDATE prueba SET nombre = ? WHERE nombre = ?";
	    	 con = conexion.conectar();
	    	 PreparedStatement preparedStmt = con.prepareStatement(query);
	    	 preparedStmt.setString (2, LeerStrings.leerString("Introduce el nombre que desea actualizar"));
	         preparedStmt.setString (1, LeerStrings.leerString("Introduce el nombre nuevo"));
	         preparedStmt.execute();
	         System.out.println("Los datos se han actualizado correctamente");
	     } catch (SQLException e) {
				e.printStackTrace();

			} finally {
				try {
					if (rs != null) {
						rs.close();
					}

					if (stm != null) {
						stm.close();
					}

					if (con != null) {
						con.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}
       
	 	
	 	public static void BorrarDatos() {
	 		 Conexion conexion = new Conexion();
	 		 Connection con = null;
	 	     PreparedStatement pst = null;
	 	     Statement stm = null;
	 		 ResultSet rs = null;
	 	     try {
	 	    	 String query = " DELETE FROM prueba WHERE nombre = ? && apellido = ?";
	 	    	 con = conexion.conectar();
	 	    	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 	         preparedStmt.setString (1, LeerStrings.leerString("Introduce el nombre de la persona que quiere eliminar"));
	 	         preparedStmt.setString (2, LeerStrings.leerString("Introduce el apellido de la persona que quiere eliminar"));
	 	         preparedStmt.execute();
	 	         System.out.println("Campos eliminados");
	 	     } catch (SQLException e) {
	 				e.printStackTrace();

	 			} finally {
	 				try {
	 					if (rs != null) {
	 						rs.close();
	 					}

	 					if (stm != null) {
	 						stm.close();
	 					}

	 					if (con != null) {
	 						con.close();
	 					}
	 				} catch (Exception e2) {
	 					e2.printStackTrace();
	 				}
	 			}
	        
	}
		
		
		
				
		
		
		
}
