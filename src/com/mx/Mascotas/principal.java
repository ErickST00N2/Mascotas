package com.mx.Mascotas;

import java.util.Scanner;

public class principal {

    public static void main(String[] args) {
        // Instanciar el objeto
    	System.out.println("Instanciando...");
        Mascota mascota1 = new Mascota("Deysi", "Snauser", 8, "Perro", "Blanco", 8.30, "Gripa", "Carlos Arturo");
        Mascota mascota2 = new Mascota("Coqueta", "Snauser", 5, "Perro", "Negro", 6.30, "Golpe de calor", "Jose Luis");
        Mascota mascota3 = new Mascota("Audaz", "Labrador", 3, "Perro", "Gris", 8.30, "Nada", "Jose Luis");
        Mascota mascota4 = new Mascota("Campanita", "Desconocida", 2, "Gato", "Amarillo", 4.2, "Nada", "Felipe");
        Mascota mascota5 = new Mascota("Duvalin", "Siames", 3, "Gato", "Café con blanco", 3.5, "Parásitos", "Jorge");

        // Auxiliar
        
        Mascota mascotita = null;
        Implementacion crud = new Implementacion();

        crud.contarRegistros();

        // Añadir datos a la lista
        System.out.println("Aniadiendo los datos...");
        crud.guardar(mascota1);
        crud.guardar(mascota2);
        crud.guardar(mascota3);
        crud.guardar(mascota4);
        crud.guardar(mascota5);

        // Mostrar
        System.out.println();
        System.out.println("Mostrando...");
        System.out.println();
        crud.mostrar();
        crud.contarRegistros();

        // Buscar
        System.out.println();
        System.out.println("Buscando...");
        mascotita = crud.buscar(1);
        System.out.println("La mascota encontrada es:\n" + mascotita);

        
        // Editar
        System.out.println();
        System.out.println("Editando...");
        mascotita = crud.buscar(0);
        mascotita.setColor("Negro");
        mascotita.setNombre("Ruby");
        crud.editar(0, mascotita);
        crud.mostrar();

        // Eliminar
        System.out.println();
        System.out.println("Eliminar...");

        crud.eliminar(2);
        crud.mostrar();

        // Metodo personalizado
        System.out.println();
        System.out.println("Metodo personalizado...");

        crud.contarRegistros();

        // Datos de mascota:
        String nombre, raza, tipo, color, condicionMedica, propietario;
        int edad;
        double peso;

        // Scanner
        Scanner scan = new Scanner(System.in);
        int menuP = 0, menuS = 0, indice = 0;
        String search2;
        double search3;
        int search;

        System.out.println();
        System.out.println("Entrando a menu...");
        System.out.println();
        do {
            // Menu
            System.out.println("------ MENU ------");
            System.out.println("1.- Alta");
            System.out.println("2.- Buscar");
            System.out.println("3.- Editar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Mostrar");
            System.out.println("6.- Contar");
            System.out.println("7.- Salir del menú");
            System.out.println("ELIGE UNA OPCION");
            menuP = scan.nextInt();

            switch (menuP) {
                // ALTA
                case 1:
                    System.out.println("Escribe el nombre de la mascota");
                    scan.nextLine();  // Limpiar el buffer
                    nombre = scan.nextLine();

                    System.out.println("Escribe la raza de la mascota");
                    raza = scan.nextLine();

                    System.out.println("Escribe la edad de la mascota");
                    edad = scan.nextInt();

                    System.out.println("Escribe el tipo de mascota");
                    scan.nextLine();  // Limpiar el buffer
                    tipo = scan.nextLine();

                    System.out.println("Escribe el color de la mascota");
                    color = scan.nextLine();

                    System.out.println("Escribe el peso de la mascota");
                    peso = scan.nextDouble();

                    System.out.println("Escribe la condición médica de la mascota");
                    scan.nextLine();  // Limpiar el buffer
                    condicionMedica = scan.nextLine();

                    System.out.println("Escribe el nombre del propietario");
                    propietario = scan.nextLine();

                    mascotita = new Mascota(nombre, raza, edad, tipo, color, peso, condicionMedica, propietario);

                    boolean existe = false;
                    for (Mascota p : crud.mascotas) {
                        if (p.getNombre().equalsIgnoreCase(nombre) && p.getRaza().equalsIgnoreCase(raza)
                                && p.getEdad() == edad && p.getTipo().equalsIgnoreCase(tipo)
                                && p.getColor().equalsIgnoreCase(color) && p.getPeso() == peso
                                && p.getCondicionMedica().equalsIgnoreCase(condicionMedica)
                                && p.getPropietario().equalsIgnoreCase(propietario)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("La mascota ya existe en la lista.");
                    } else {
                        // Agregamos a la lista
                        crud.guardar(mascotita);
                        System.out.println("El registro de la mascota fue exitoso");
                    }
                    break;

                // BUSCAR
                case 2: {
                    if (crud.mascotas.size() < 1) {
                        System.out.println("No hay nada en la lista");
                        break;
                    }

                    do {
                        System.out.println("2. Buscar un elemento por atributo");
                        System.out.println("¿Qué atributo deseas buscar?");
                        System.out.println("1. Buscar por índice");
                        System.out.println("2. Buscar por nombre");
                        System.out.println("3. Buscar por raza");
                        System.out.println("4. Buscar por tipo");
                        System.out.println("5. Buscar por color");
                        System.out.println("6. Buscar por propietario");
                        System.out.println("7. Buscar por peso");
                        System.out.println("8. Buscar por edad");
                        System.out.println("9. Salir del submenú");
                        menuS = scan.nextInt();

                        switch (menuS) {
                            case 1:
                                System.out.println("Introduce el índice que quieres buscar");
                                search = scan.nextInt();
                                mascotita = crud.buscar(search);
                                System.out.println("La mascota encontrada es:\n" + mascotita);
                                break;
                            case 2:
                                System.out.println("Introduce el nombre de la mascota que quieres buscar");
                                scan.nextLine();
                                search2 = scan.nextLine();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getNombre().equalsIgnoreCase(search2)) {
                                        System.out.println("La mascota " + search2 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Introduce la raza de la mascota que quieres buscar");
                                scan.nextLine();
                                search2 = scan.nextLine();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getRaza().equalsIgnoreCase(search2)) {
                                        System.out.println("La raza " + search2 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Introduce el tipo de la mascota que quieres buscar");
                                scan.nextLine();
                                search2 = scan.nextLine();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getTipo().equalsIgnoreCase(search2)) {
                                        System.out.println("El tipo " + search2 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Introduce el color de la mascota que quieres buscar");
                                scan.nextLine();
                                search2 = scan.nextLine();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getColor().equalsIgnoreCase(search2)) {
                                        System.out.println("El color " + search2 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Introduce el propietario de la mascota que quieres buscar");
                                scan.nextLine();
                                search2 = scan.nextLine();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getPropietario().equalsIgnoreCase(search2)) {
                                        System.out.println("El propietario " + search2 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 7:
                                System.out.println("Introduce el peso de la mascota que quieres buscar");
                                search3 = scan.nextDouble();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getPeso() == search3) {
                                        System.out.println("El peso " + search3 + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 8:
                                System.out.println("Introduce la edad de la mascota que quieres buscar");
                                search = scan.nextInt();
                                for (int i = 0; i < crud.mascotas.size(); i++) {
                                    if (crud.mascotas.get(i).getEdad() == search) {
                                        System.out.println("La edad " + search + " se encuentra en la posición: " + i);
                                        System.out.println(crud.mascotas.get(i));
                                    }
                                }
                                break;
                            case 9:
                                System.out.println("Saliendo del submenú de búsqueda");
                                break;
                            default:
                                System.out.println("Opción no válida, intenta de nuevo");
                                break;
                        }
                    } while (menuS != 9);
                    break;
                }

                // EDITAR
                case 3:
                    System.out.println("Introduce el índice de la mascota que quieres editar");
                    indice = scan.nextInt();
                    mascotita = crud.buscar(indice);
                    if (mascotita != null) {
                        System.out.println("Escribe el nombre de la mascota");
                        scan.nextLine();  // Limpiar el buffer
                        nombre = scan.nextLine();
                        mascotita.setNombre(nombre);

                        System.out.println("Escribe la raza de la mascota");
                        raza = scan.nextLine();
                        mascotita.setRaza(raza);

                        System.out.println("Escribe la edad de la mascota");
                        edad = scan.nextInt();
                        mascotita.setEdad(edad);

                        System.out.println("Escribe el tipo de mascota");
                        scan.nextLine();  // Limpiar el buffer
                        tipo = scan.nextLine();
                        mascotita.setTipo(tipo);

                        System.out.println("Escribe el color de la mascota");
                        color = scan.nextLine();
                        mascotita.setColor(color);

                        System.out.println("Escribe el peso de la mascota");
                        peso = scan.nextDouble();
                        mascotita.setPeso(peso);

                        System.out.println("Escribe la condición médica de la mascota");
                        scan.nextLine();  // Limpiar el buffer
                        condicionMedica = scan.nextLine();
                        mascotita.setCondicionMedica(condicionMedica);

                        System.out.println("Escribe el nombre del propietario");
                        propietario = scan.nextLine();
                        mascotita.setPropietario(propietario);

                        crud.editar(indice, mascotita);
                        System.out.println("La mascota fue actualizada con éxito.");
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                // ELIMINAR
                case 4:
                    System.out.println("Introduce el índice de la mascota que quieres eliminar");
                    indice = scan.nextInt();
                    crud.eliminar(indice);
                    break;

                // MOSTRAR
                case 5:
                    crud.mostrar();
                    break;

                // CONTAR
                case 6:
                    crud.contarRegistros();
                    break;

                // SALIR
                case 7:
                    System.out.println("Saliendo del menú...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo");
                    break;
            }
        } while (menuP != 7);

        System.out.print("Hasta pronto!");
        scan.close();
        
    }
}
