package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // fase 8
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

    public static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                //.equals compara a los String
                return c;
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
        System.out.print("Nuevo teléfono (" + c.getTelefono());
        String telefono = sc.nextLine();
        System.out.print("Nuevo email (" + c.getEmail() + "):" );
        String email = sc.nextLine();

        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setEmail(email);
        System.out.println("Cliente actualizado exitosamente.");
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

}
