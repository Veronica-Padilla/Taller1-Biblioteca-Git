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



}
