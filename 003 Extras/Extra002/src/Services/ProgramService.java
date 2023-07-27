package Services;

import Entities.Cine;
import Entities.Espectador;
import Entities.Pelicula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ProgramService {

   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");
   public final Random ran = new Random();

   public ArrayList<Espectador> lista;

   public void crearEspectadores(ArrayList<Espectador> esp) {
      System.out.println("Ingrese la cantidad de espectadores que quieren entrar al cine");
      System.out.print("La sala cuenta con 48 asientos a ser ocupados: ");
      Integer cant;
      do {
         cant = leer.nextInt();
         if (cant < 1) {
            System.out.print("Cantidad inválida, vuelva a ingresar: ");
         }
      } while (cant < 1);

      for (int i = 0; i < cant; i++) {
         Espectador e = new Espectador();
         System.out.println("Ingerse datos del espectador " + (i + 1));

         System.out.print("Nombre: ");
         e.setNombre(leer.next());

         System.out.print("Edad: ");
         do {
            e.setEdad(leer.nextInt());
            if (e.getEdad() < 1) {
               System.out.print("Edad inválida, vuelva a ingresar: ");
            }
         } while (e.getEdad() < 1);

         System.out.print("Dinero: ");
         do {
            e.setDinero(leer.nextDouble());
            if (e.getDinero() < 1) {
               System.out.print("Monto inválida, vuelva a ingresar: ");
            }
         } while (e.getDinero() < 1);

         e.setAsiento("");

         esp.add(e);
      }
   }

   public Pelicula crearPelicula() {
      Pelicula p = new Pelicula();
      System.out.println("Ingrese los datos de la película a ver");

      System.out.print("Título: ");
      p.setTitulo(leer.next());

      System.out.print("Duración: ");
      do {
         p.setDuracion(leer.nextDouble());
         if (p.getDuracion() < 30) {
            System.out.print("Duración inválida, vuelva a ingresar: ");
         }
      } while (p.getDuracion() < 30);

      System.out.print("Clasificación: ");
      do {
         p.setClasificacion(leer.nextInt());
         if (p.getClasificacion() < 0) {
            System.out.print("Duración inválida, vuelva a ingresar: ");
         }
      } while (p.getClasificacion() < 0);

      System.out.print("Director: ");
      p.setDirector(leer.next());

      return p;
   }

   public Cine crearSala(Pelicula peli, ArrayList<Espectador> lista) {
      Cine c = new Cine();
      System.out.print("Ingrese el monto de la entrada: ");
      do {
         c.setEntrada(leer.nextDouble());
         if (c.getEntrada() < 1) {
            System.out.print("Monto inválida, vuelva a ingresar: ");
         }
      } while (c.getEntrada() < 1);
      c.setPelicula(peli);

      c.setSala(llenarSala(lista, c.getEntrada(), peli));

      return c;
   }

   public Espectador[][] llenarSala(ArrayList<Espectador> lista, Double entrada, Pelicula peli) {
      Espectador auxiliar = new Espectador("", 0, 0.0, "");
      Espectador[][] aux = new Espectador[8][6];

      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 6; j++) {
            aux[i][j] = auxiliar;
         }
      }

      boolean reubicar;
      Integer auxI, auxJ;
      Integer cap = 48;
      Iterator it = lista.iterator();

      while (it.hasNext()) {
         Espectador esp = (Espectador) it.next();
         do {
            reubicar = false;
            auxI = ran.nextInt(8);
            auxJ = ran.nextInt(6);
            if (esp.getDinero() >= entrada) {
               if (esp.getEdad() >= peli.getClasificacion()) {
                  if (cap != 0) {
                     if (aux[auxI][auxJ].getNombre().equals("")) {
                        System.out.println(esp.getNombre() + " tomó asiento");
                        aux[auxI][auxJ] = esp;
                        esp.setDinero(esp.getDinero()-entrada);
                        cap--;
                     } else {
                        reubicar = true;
                     }
                  } else {
                     System.out.println("No hay más lugar en la sala para " + esp.getNombre());
                  }
               } else {
                  System.out.println(esp.getNombre() + " no clasifica por su edad");
               }
            } else {
               System.out.println("A " + esp.getNombre() + " no le alcanza el dinero para entrar");
            }

         } while (reubicar == true);
      }

      return aux;
   }

   public void mostrarSala(Cine cine) {
      Espectador[][] esp = cine.getSala();
      String[][] aux = new String[8][6];
      llenarAux(aux);

      for (int i = 7; i >= 0; i--) {
         for (int j = 0; j < 6; j++) {
            if (!esp[i][j].getNombre().isEmpty()) {
               esp[i][j].setAsiento(aux[i][j]);
               aux[i][j] += "X";
            } else {
               aux[i][j] += " ";
            }
            System.out.print("|" + aux[i][j]);
            if (j == 5) {
               System.out.print("|");
            }
         }
         System.out.println("");
      }
   }

   public void llenarAux(String[][] aux) {
      for (int i = 7; i >= 0; i--) {
         for (int j = 0; j < 6; j++) {
            switch (j) {
               case 0:
                  aux[i][j] = (i + 1) + "A";
                  break;
               case 1:
                  aux[i][j] = (i + 1) + "B";
                  break;
               case 2:
                  aux[i][j] = (i + 1) + "C";
                  break;
               case 3:
                  aux[i][j] = (i + 1) + "D";
                  break;
               case 4:
                  aux[i][j] = (i + 1) + "E";
                  break;
               default:
                  aux[i][j] = (i + 1) + "F";
            }

         }

      }
   }

   public void buscarEspectador(Cine cine) {
      System.out.println("Ingrese un nombre para ser buscado en la sala");
      String nombre = leer.next();
      boolean esta = false;
      Espectador[][] espectadores = cine.getSala();
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 6; j++) {
            if (espectadores[i][j].getNombre().equals(nombre)) {
               System.out.println(nombre + " está en el asiento " + espectadores[i][j].getAsiento());
               esta = true;
            }
         }
      }
      if (esta == false) {
         System.out.println(nombre + " no se encuentra en la sala");
      }
   }

}
