package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Simulador {

   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");
   public final Random ran = new Random();

   public ArrayList<String> nombreLista() {

      ArrayList<String> nombres = new ArrayList<>(Arrays.asList(
              "Julio", "Camila", "Mateo", "Valentina", "Sebastián", "Sofía", "Samuel", "Isabella", "Juan", "Lucía",
              "Gabriel", "Martina", "Matías", "Regina", "Felipe", "Luna", "Diego", "Renata", "Emilio", "Abril",
              "Joaquín", "Ana", "Adrián", "Valeria", "Nicolás", "Olivia", "Andrés", "Emily", "Emmanuel", "Mía",
              "Tomás", "Ximena", "Daniel", "Renata", "Emiliano", "Victoria", "Rafael", "Catalina", "Emilio", "Camila",
              "Luis", "Valeria", "Esteban", "Florencia", "Ignacio", "Laura", "Pablo", "Carolina", "Carlos", "María"
      ));

      ArrayList<String> apellidos = new ArrayList<>(Arrays.asList(
              "García", "Rodríguez", "Martínez", "López", "Hernández", "González", "Pérez", "Gómez", "Fernández", "Sánchez",
              "Díaz", "Torres", "Rivera", "Ramírez", "Cruz", "Morales", "Ortiz", "Reyes", "Romero", "Núñez",
              "Gutiérrez", "Jiménez", "Ramos", "Chávez", "Ruiz", "Silva", "Alvarez", "Mendoza", "Vargas", "Castillo",
              "Rojas", "Guerrero", "Bautista", "Molina", "Moreno", "Delgado", "Cortés", "Medina", "Ayala", "Vega",
              "Acosta", "Cabrera", "Campos", "Carrasco", "Herrera", "Lozano", "Montes", "Miranda", "Peña", "Orozco"
      ));

      ArrayList<String> nombreCompleto = new ArrayList<>();

      for (int i = 0; i < 50; i++) {
         nombreCompleto.add(nombres.get(ran.nextInt(50)) + " " + apellidos.get(ran.nextInt(50)));
      }

      return nombreCompleto;
   }

   public ArrayList<Integer> DNIgen() {
      ArrayList<Integer> aux = new ArrayList<>();
      Integer num;
      for (int i = 0; i < 50; i++) {
         do {
            num = ran.nextInt(56000000);
         } while (num < 48000000 || num > 56000000);
         aux.add(num);
      }
      Collections.shuffle(aux);
      return aux;
   }

   public ArrayList<Alumno> crearLista() {
      ArrayList<Alumno> alumnos = new ArrayList<>();
      System.out.println("Ingrese una cantidad de alumnos para agregar a una lista");
      System.out.print("Ingrese cantidad: ");
      Integer cantidad;
      Integer auxDNI;
      boolean validar;
      do {
         cantidad = leer.nextInt();
         if (cantidad < 1) {
            System.err.print("ERROR! Ingrese un valor positivo: ");
         }
      } while (cantidad < 1);
      for (int i = 0; i < cantidad; i++) {
         Alumno al = new Alumno();
         ArrayList<String> nombreCompleto = nombreLista();
         al.setNombreApellido(nombreCompleto.get(0));

         do {
            validar = true;
            ArrayList<Integer> dnis = DNIgen();
            if (i == 0) {
               al.setDNI(dnis.get(0));
            } else {
               auxDNI = dnis.get(0);
               for (Alumno alumno : alumnos) {
                  if (alumno.getDNI() == auxDNI) {
                     validar = false;
                  } else {
                     al.setDNI(auxDNI);
                  }
               }
            }
         } while (validar == false);

         al.setCantidadVotos(0);
         alumnos.add(al);
      }

      return alumnos;
   }

   public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
      for (Alumno alumno : alumnos) {
         System.out.println(alumno.toString());
         System.out.println("Sus votos fueron:");
         for (String voto : alumno.getVotados()) {
            System.out.println(voto);
         }
      }
   }

   public void voto(ArrayList<Alumno> alumnos) {

      Alumno aux;
      Integer n;
      boolean igual;

      for (Alumno alumno : alumnos) {
         aux = alumno;
         HashSet<Alumno> alumnosHash = new HashSet<>();
         do {
            do {
               igual = false;
               n = ran.nextInt(alumnos.size());
               if (aux.getDNI() != alumnos.get(n).getDNI()) {
                  alumnosHash.add(alumnos.get(n));
               } else {
                  igual = true;
               }
            } while (igual == true);
            if (alumnosHash.size() == 3) {
               break;
            }
         } while (true);
         for (Alumno al : alumnosHash) {
            aux.getVotados().add(al.getNombreApellido());
            al.setCantidadVotos(al.getCantidadVotos() + 1);
         }

      }
   }

   public Integer recuentoVotos(ArrayList<Alumno> alumnos) {
      return 3*alumnos.size();
   }
   
   public ArrayList<Alumno> faci(ArrayList<Alumno> alumnos){
      Collections.sort(alumnos, (alumno1, alumno2) -> alumno2.getCantidadVotos().compareTo(alumno1.getCantidadVotos()));
      ArrayList<Alumno> faci = new ArrayList<>();
         for (Alumno alumno : alumnos) {
            if(faci.size()<10){
               faci.add(alumno);
            }
         }
      return faci;
   }
   
   public void mostrarFaci(ArrayList<Alumno> faci){
      System.out.println("Los 5 facilitadores son");
      
      for (int i = 0; i < faci.size(); i++) {
         if (i<5){
            System.out.println(faci.get(i).getNombreApellido()+", con "+faci.get(i).getCantidadVotos()+" votos");
         } else if (i==5){
            System.out.println("--------------------------------------------------");
            System.out.println("Los 5 facilitadores suplentes son");
            System.out.println(faci.get(i).getNombreApellido()+", con "+faci.get(i).getCantidadVotos()+" votos");
         } else {
            System.out.println(faci.get(i).getNombreApellido()+", con "+faci.get(i).getCantidadVotos()+" votos");
         }
         
      }
      
//      for (Alumno alumno : faci) {
//         if (faci.size()<5){
//            System.out.println(alumno.getNombreApellido());
//         } else if(faci.size()==5){
//            System.out.println("Los 5 facilitadores suplentes son");
//            System.out.println(alumno.getNombreApellido());
//         } else {
//            System.out.println(alumno.getNombreApellido());
//         }
//         
//      }
   }

}
