package Services;

import Entities.Perro;
import Entities.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramService {

   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");

   public Integer crearPerros(ArrayList<Perro> perros) {
      System.out.print("Cuántas mascotas quiere crear? ");
      Integer cantMasc;
      do {
         cantMasc = leer.nextInt();
         if (cantMasc < 0) {
            System.out.print("Cantidad incorrecta, vuelva a ingresar: ");
         }
      } while (cantMasc < 0);
      System.out.println("");

      for (int i = 0; i < cantMasc; i++) {
         Perro p = new Perro();
         System.out.println("Ingrese datos para el perro " + (i + 1));
         System.out.print("Nombre: ");
         p.setNombre(leer.next());
         System.out.print("Raza: ");
         p.setRaza(leer.next());
         System.out.print("Edad: ");
         do {
            p.setEdad(leer.nextInt());
            if (p.getEdad() < 0) {
               System.out.print("Cantidad incorrecta, vuelva a ingresar: ");
            }
         } while (p.getEdad() < 0);
         System.out.print("Tamaño: ");
         p.setTamanno(leer.next());
         p.setDuenno(false);

         perros.add(p);
      }
      return cantMasc;
   }

   public void crearPersonas(ArrayList<Persona> per, Integer cant) {
      System.out.println("Se van a crear " + cant + " personas");

      for (int i = 0; i < cant; i++) {
         Persona p = new Persona();
         System.out.println("Ingrese datos de la persona " + (i + 1));
         System.out.print("Nombre: ");
         p.setNombre(leer.next());
         System.out.print("Apellido: ");
         p.setAppelido(leer.next());
         System.out.print("Edad: ");
         do {
            p.setEdad(leer.nextInt());
            if (p.getEdad() < 0) {
               System.out.print("Cantidad incorrecta, vuelva a ingresar: ");
            }
         } while (p.getEdad() < 0);
         System.out.print("DNI: ");
         do {
            p.setDni(leer.nextInt());
            if (p.getDni() < 0) {
               System.out.print("Cantidad incorrecta, vuelva a ingresar: ");
            }
         } while (p.getDni() < 0);
         Perro pe = new Perro("", "", 0, "", false);
         p.setPerro(pe);

         per.add(p);
      }
   }

   public void asignarPerro(ArrayList<Persona> personas, ArrayList<Perro> perros) {
      System.out.println("A continuación se le asigna a cada dueño un perro elegido por su nombre");
      for (Persona persona : personas) {

         boolean bol2;
         do {
            

            System.out.println("Lista de perros");
            for (Perro perro : perros) {
               mostrarPerro(perro);
            }

            System.out.println("Ingrese el nombre del perro");
            String nombre;
            boolean bol;

            do {
               bol = false;
               bol2 = false;
               nombre = leer.next();
               for (Perro perro : perros) {
                  if (nombre.equals(perro.getNombre())) {
                     bol = true;
                  }
               }
               if (bol == false) {
                  System.out.print("Nombre erróneo, vuelva a ingresar: ");
               }
            } while (bol == false);

            for (Perro perro : perros) {
               if (perro.getNombre().equals(nombre) && perro.isDuenno() == false) {
                  persona.setPerro(perro);
                  bol2 = true;
                  perro.setDuenno(true);
                  System.out.println(nombre + " ha sido asignado!!!");
               }
            }

            if (bol2 == false) {
               System.out.println("El perro ya está asignado, elija otro perro");
            }

         } while (bol2 == false);

         mostrarPersona(persona);

      }

   }

   public void mostrarPerro(Perro p) {
      System.out.print("El perro es ");
      System.out.println(p.toString());
   }

   public void mostrarPersona(Persona p) {
      System.out.println("La persona es " + p.toString());
   }

}
