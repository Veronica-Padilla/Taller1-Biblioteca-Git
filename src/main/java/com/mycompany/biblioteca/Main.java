package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Crear libro");
            System.out.println("6. Listar libros");
            System.out.println("7. Actualizar libro");
            System.out.println("8. Eliminar libro");
            System.out.println("9. Registrar préstamo");
            System.out.println("10. Registrar devolución");
            System.out.println("11. Listar préstamos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> {
                    System.out.print("ID del cliente a actualizar: ");
                    actualizarCliente(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("ID del cliente a eliminar: ");
                    eliminarCliente(sc.nextLine());
                }
                case 5 -> crearLibro();
                case 6 -> listarLibros();
                case 7 -> {
                    System.out.print("Código del libro a actualizar: ");
                    actualizarLibro(sc.nextLine());
                }
                case 8 -> {
                    System.out.print("Código del libro a eliminar: ");
                    eliminarLibro(sc.nextLine());
                }
                case 9 -> crearPrestamo();
                case l0 -> {
                    System.out.print("ID del préstamo a devolver: ");
                    devolverPrestamo(sc.nextLine());
                }
                case ll -> listarPrestamos();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void crearCliente() {
        System.out.println("       CREAR CLIENTE");
        System.out.print("ID:  ");
        String id = sc.nextLine();
        //Leer id
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email; ");
        String email = sc.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, email);
        clientes.add(nuevoCliente);
        System.out.println("Cliente creado exitosamente.");

    }

    public static void crearLibro() {
        System.out.println("       CREAR LIBRO");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(sc.nextLine());
        //Integer.parseInt convierte un String a un entero
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro nuevoLibro = new Libro(codigo, titulo, anio, autor);
        libros.add(nuevoLibro);
        System.out.println("Libro creado exitosamente.");

    }

    public static void crearPrestamo() {
        System.out.println("       REGISTRAR PRÉSTAMO");
        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();
        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        System.out.print("Código del libro: ");
        String codigoLibro = sc.nextLine();

        Cliente cliente = buscarCliente(idCliente);
        Libro libro = buscarLibro(codigoLibro);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible actualmente.");
            return;
        }

        Prestamo nuevoPrestamo = new Prestamo(idPrestamo, cliente, libro, LocalDate.now(), "ACTIVO");
        prestamos.add(nuevoPrestamo);
        libro.setDisponible(false);
        System.out.println("Préstamo registrado exitosamente.");
    }

    public static void listarClientes() {
        System.out.print("       LISTAR CLIENTES");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public static void listarLibros() {
        System.out.println("       LISTAR LIBROS");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }

    public static void listarPrestamos() {
        System.out.println("       LISTA DE PRÉSTAMOS");
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            for (Prestamo p : prestamos) {
                System.out.println(p);
            }
        }
    }

    public static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                //.equals compara a los String
                return c;
            }
        }
        return null;
    }

    public static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public static void actualizarCliente(String id) {
        Cliente c = buscarCliente(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.println("       ACTUALIZAR CLIENTE");
        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo teléfono (" + c.getTelefono() + ")";
        String telefono = sc.nextLine();
        System.out.print("Nuevo email (" + c.getEmail() + "):" );
        String email = sc.nextLine();

        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setEmail(email);
        System.out.println("Cliente actualizado exitosamente.");
    }

    public static void actualizarLibro(String codigo) {
        Libro l = buscarLibro(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        System.out.println("--- Actualizar Libro ---");
        System.out.print("Nuevo título (" + l.getTitulo() + "): ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo año de publicación (" + l.getAnioPublicacion() + "): ");
        int anio = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo autor (" + l.getAutor() + "): ");
        String autor = sc.nextLine();

        l.setTitulo(titulo);
        l.setAnioPublicacion(anio);
        l.setAutor(autor);
        System.out.println("Libro actualizado exitosamente.");
    }

    public static void eliminarCliente(String id) {
        Cliente c = buscarCliente(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        clientes.remove(c);
        System.out.println("Cliente eliminado exitosamente");
    }

    public static void eliminarLibro(String codigo) {
        Libro l = buscarLibro(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        libros.remove(l);
        System.out.println("Libro eliminado exitosamente.");
    }

    public static void devolverPrestamo(String idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo)) {
                if (p.getEstado().equals("DEVUELTO")) {
                    System.out.println("Este préstamo ya fue devuelto.");
                    return;
                }
                p.setEstado("DEVUELTO");
                p.getLibro().setDisponible(true);
                System.out.println("Devolución registrada exitosamente.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado.");
    }

}
