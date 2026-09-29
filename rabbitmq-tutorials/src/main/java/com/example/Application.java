package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext ctx =
                SpringApplication.run(Application.class, args);

        Sender sender = ctx.getBean(Sender.class);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    System.out.print("Escribe el mensaje: ");
                    String message = scanner.nextLine();

                    sender.sendMessage(message);
                    break;

                case "2":
                    running = false;
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }
}