package ServerControl;

import java.util.Scanner;

import modelo.Operador;
import modelo.Maquina;

public class ConsolaAdministracion implements Runnable {

	private ServerControl control;

	public ConsolaAdministracion(ServerControl control) {
		this.control = control;
	}

	@Override
	public void run() {

		while (true) {
			Scanner lector = new Scanner(System.in);

			System.out.println("****************************");
			System.out.println("Consola de administración");
			System.out.println("****************************");

			System.out.println("\nOpciones:" +
					"\n1.Agregar un nuevo operador" +
					"\n2.Agregar una nueva maquina" +
					"\n3.Asignar maquina a operador" +
					"\n4.Estado de alarmas" +
					"\n5.Agregar nueva receta");
			int valor = lector.nextInt();

			switch (valor) {
				case 1:
					lector.nextLine();
					System.out.println(">>Digite el código del operador");
					int codOp = lector.nextInt();
					lector.nextLine();
					System.out.println(">>Digite el nombre del operador");
					String nombre = lector.nextLine();

					Operador op = new Operador();
					op.setId(codOp);
					op.setNombre(nombre);

					control.registrarOperador(op);
					break;
				case 2:
					lector.nextLine();
					System.out.println(">>Digite código de la máquina");
					int codMqCrear = lector.nextInt();
					lector.nextLine();
					System.out.println(">>Digite la ubicación de la máquina");
					String ubicacion = lector.nextLine();

					Maquina mq = new Maquina();
					mq.setId(codMqCrear);
					mq.setUbicacion(ubicacion);

					control.registrarMaquina(mq);
					break;
				case 3:
					lector.nextLine();
					System.out.println(">>Digite código de la máquina");
					int codMqAsignar = lector.nextInt();
					lector.nextLine();
					System.out.println(">>Digite código del operador");
					int codOpAsignar = lector.nextInt();
					lector.nextLine();

					if (control.asignarOperador(codMqAsignar, codOpAsignar)) {
						System.out.println("Asignación Creada");
					} else {
						System.out.println("Error de parámetros");
					}
					break;
				case 4:
					lector.nextLine();
					System.out.println(control.obtenerEstadoAlarmas());
					break;
				case 5:
					lector.nextLine();
					System.out.println(">>Digite el nombre de la receta");
					String nombreRecetaCrear = lector.nextLine();
					System.out.println(">>Digite el precio de la receta");
					int precioRecetaCrear = lector.nextInt();

					String responseRecetaCrear = control.registrarReceta(nombreRecetaCrear, precioRecetaCrear);
					String[] arrayResponseRecetaCrear = responseRecetaCrear.split("-");
					int consecutivoNuevaReceta = Integer.parseInt(arrayResponseRecetaCrear[0]);
					System.out.println(responseRecetaCrear);
					System.out.println("\nAñadiendo ingredientes a la receta");

					int option = 1;
					do {
						lector.nextLine();
						System.out.println(">>Ingresa el id del ingrediente");
						int idIngredienteRecetaAñadir = lector.nextInt();
						lector.nextLine();

						System.out.println(">>Ingresa la dosificación del ingrediente (gramos)");
						int ingredienteCantidad = lector.nextInt();
						lector.nextLine();

						control.registrarRecetaIngrediente(consecutivoNuevaReceta, idIngredienteRecetaAñadir,
								ingredienteCantidad);

						System.out.println(">>Para añadir otro ingrediente digita 1, para salir digita 0");
						option = lector.nextInt();
					} while (option != 0);

					System.out.println();
					break;
				default:
					System.out.println("¡¡¡Opción incorrecta seleccionada!!!");
					break;
			}

			lector.close();
		}

	}
}
