package com.tools;

import java.util.Scanner;

public class ImprimirMenu {

	public static void imprimirMenu() {
		Scanner sn = new Scanner(System.in);
		boolean exit = false;
		int opcion;

		while (!exit) {
			System.out.println("\nWELCOME TO DATABASE JUNIOR ");
			System.out.println("1. Mostrar todos los registros ");
			System.out.println("2. Insertar un registro nuevo");
			System.out.println("3. Actualizar registro ");
			System.out.println("4. Eliminar registro ");
			System.out.println("5. Salir");
			System.out.println("Selecciona una opcion");
			opcion = sn.nextInt();
			
			switch (opcion) {
			case 1:
				Operaciones.MostrarDatos();
				break;
			case 2:
				Operaciones.insertarDatos();
				break;
			case 3:
				Operaciones.actualizarDatos();
				break;
			case 4:
				Operaciones.BorrarDatos();
				break;
			case 5:
				System.out.println("----------------------------------------");
				System.out.println("Gracias por utilizar este servicio");
				System.out.println("----------------------------------------");
				exit = true;
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
			
		}
	}
}
