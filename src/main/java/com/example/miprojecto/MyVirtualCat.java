package com.example.miprojecto;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyVirtualCat implements CommandLineRunner {

    private final MyCatService myCatService;

    public MyVirtualCat(MyCatService myCatService) {
        this.myCatService = myCatService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyVirtualCat.class, args);
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Como se va a llamar tu gato?: ");
            myCatService.setNombre(scanner.nextLine());

            boolean jugando = true;
            while (jugando) {
                System.out.println("\n" + myCatService.obtenerEstado());
                System.out.println("1. Alimentar.");
                System.out.println("2. Jugar.");
                System.out.println("3. Dormir.");
                System.out.println("4. Salir.");
                System.out.print("Elegi: ");
                String opcion = scanner.nextLine();

                if (opcion.equals("1")) {
                    System.out.println(myCatService.alimentar());
                } else if (opcion.equals("2")) {
                    System.out.println(myCatService.jugar());
                } else if (opcion.equals("3")) {
                    System.out.println(myCatService.dormir());
                } else if (opcion.equals("4")) {
                    jugando = false;
                    System.out.println("Chau! " + myCatService.getNombre() + " te va a extranar.");
                } else {
                    System.out.println("Opcion invalida.");
                }
            }
        }
    }
}
