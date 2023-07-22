package Services;

import Entities.Baraja;
import Entities.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class BarajaService {

   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");

   public Baraja crearBaraja() {

      ArrayList<Carta> cartas = new ArrayList<>();
      ArrayList<Carta> cartasDadas = new ArrayList<>();

      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 10; j++) {
            Carta bar = new Carta();

            if (j < 7) {
               bar.setNumero(j + 1);
            } else {
               bar.setNumero(j + 3);
            }

            switch (i) {
               case 0:
                  bar.setPalo("espada");
                  break;
               case 1:
                  bar.setPalo("oro");
                  break;
               case 2:
                  bar.setPalo("basto");
                  break;
               case 3:
                  bar.setPalo("copa");
                  break;
            }
            cartas.add(bar);
         }

      }
      return new Baraja(cartas, cartasDadas);
   }

   public void mostrarBaraja(ArrayList<Carta> cartas) {
      System.out.println("Las cartas son: ");
      for (Carta carta : cartas) {
         System.out.println(carta.toString());
      }
   }

   public void barajar(Baraja baraja) {
      System.out.println("Se barajaron las cartas");
      Collections.shuffle(baraja.getCartas());
   }

   public void juego(Baraja baraja) {
      barajar(baraja);

      Integer opc;
      do {
         noHayMas(baraja);
         System.out.println("Qué desea hacer?");
         do {
            opc = menu();
            if (opc < 1 || opc > 7) {
               System.out.print("Valor erróneo, vuelva a ingresar: ");
            }
         } while (opc < 1 || opc > 7);

         opciones(opc, baraja);

      } while (true);

   }

   public Integer menu() {
      System.out.println("----------------");
      System.out.println("1. Barajar");
      System.out.println("2. Siguiente carta");
      System.out.println("3. Cartas disponibles");
      System.out.println("4. Dar cartas");
      System.out.println("5. Contar cartas dadas");
      System.out.println("6. Mostrar baraja");
      System.out.println("7. Salir");
      return leer.nextInt();
   }

   public void opciones(Integer opc, Baraja baraja) {
      switch (opc) {
         case 1:
            barajar(baraja);
            break;
         case 2:
            siguienteCarta(baraja);
            break;
         case 3:
            System.out.println("Cartas disponibles: " + cartasDisponibles(baraja));
            break;
         case 4:
            darCartas(baraja);
            break;
         case 5:
            cartasMonton(baraja);
            break;
         case 6:
            mostrarBaraja(baraja.getCartas());
            break;
         case 7:
            System.exit(0);
      }
   }

   public void siguienteCarta(Baraja baraja) {
      if (baraja.getCartas().size() > 0) {

         Iterator it = baraja.getCartas().iterator();
         Carta carta = (Carta) it.next();
         
         System.out.println(carta.toString());
         baraja.getCartasDadas().add(carta);
         it.remove();
      }
   }

   public Integer cartasDisponibles(Baraja baraja) {
      return baraja.getCartas().size();
   }

   public void darCartas(Baraja baraja) {
      System.out.print("Ingrese la cantidad de cartas a dar: ");
      Integer cant;
      do {
         cant = leer.nextInt();
         if (cant < 0) {
            System.out.print("Error, elija al menos 1 carta: ");
         }
      } while (cant < 0);
      System.out.println("");

      if (baraja.getCartas().size() < cant) {
         System.out.println("No se puede dar ese número de cartas porque no hay tantas para dar");
      } else {
         Iterator it = baraja.getCartas().iterator();

         System.out.println("Las cartas dadas son:");
         for (int i = 0; i < cant; i++) {
            Carta carta = (Carta) it.next();
            System.out.println(carta.toString());
            baraja.getCartasDadas().add(carta);
            it.remove();
         }

      }

   }

   public void cartasMonton(Baraja baraja) {
      ArrayList<Carta> cartasDadas = baraja.getCartasDadas();
      System.out.println("Las cartas en el montón son: ");
      for (Carta cartaDada : cartasDadas) {
         System.out.println("Carta: " + cartaDada.getNumero() + " de " + cartaDada.getPalo());
      }
   }

   public void noHayMas(Baraja baraja) {
      if (baraja.getCartas().size() == 0) {
         System.out.println("No hay más cartas que repartir");
         System.exit(0);
      }
   }

}
