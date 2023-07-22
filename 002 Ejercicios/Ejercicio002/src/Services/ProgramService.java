package Services;

import Entities.Juego;
import Entities.Jugador;
import Entities.Revolver;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramService {

   public final Scanner leer = new Scanner(System.in).useDelimiter("\n");
   public final Random ran = new Random();

   public Revolver llenarRevolver() {
      int r1 = ran.nextInt(6) + 1;
      int r2 = ran.nextInt(6) + 1;
      return new Revolver(r1, r2);
   }

   public boolean mojar(Revolver r) {
      if (r.getPosicionActual() == r.getPosicionAgua()) {
         return true;
      } else {
         return false;
      }
   }

   public void siguienteChorro(Revolver r) {
      if (r.getPosicionActual() == 6) {
         r.setPosicionActual(1);
      } else {
         r.setPosicionActual(r.getPosicionActual() + 1);
      }
   }

   public boolean disparo(Revolver r) {
      if (mojar(r) == true) {
         System.out.println(carteles());
         return true;
      } else {
         siguienteChorro(r);
         return false;
      }
   }

   public String carteles() {
      int aux = ran.nextInt(5) + 1;
      switch (aux) {
         case 1:
            return "Has muerto";
         case 2:
            return "R.I.P.";
         case 3:
            return "Te has mojado";
         case 4:
            return "Moriste";
         default:
            return "Dejaste de existir";
      }
   }

   public void llenarJugadores(ArrayList<Jugador> j) {
      System.out.println("Ingrese la cantidad de jugadores que desean participar");
      Integer num = leer.nextInt();
      if (num < 1 || num > 6) {
         num = 6;
         System.out.println("valor fuera de rango...");
         System.out.println("Por defecto participarán 6 jugadores");
      }
      for (int i = 0; i < num; i++) {
         Jugador player = new Jugador(i + 1, "Jugador", true);
         j.add(player);
      }
   }

   public String ronda(Juego game) {
      System.out.println("Iniciando el juego...");
      esperar();
      ArrayList<Jugador> player = game.getJugadores();
      Revolver rev = game.getRevolver();
      String aux = "";
      boolean bol = false;
      while (bol == false) {
         for (Jugador jugador : player) {
            esperar();
            System.out.println("Inicia el disparo para " + jugador.getNombre() + " " + jugador.getId());
            if (disparo(rev) == true) {
               esperar();
               jugador.setMojado(false);
               aux = "El jugador mojado fue " + jugador.getNombre() + " " + jugador.getId();               
               bol = true;
            } else {
               esperar();
               System.out.println(mensajes());
            }
            if (bol == true) {
               break;
            }
            esperar();
            System.out.println(rev.toString());
            System.out.println("-------------------------------------------");
         }
      }
      return aux;
   }

   public void esperar() {
      try {
         Thread.sleep(1500);
      } catch (InterruptedException ex) {
         Logger.getLogger(ProgramService.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   public String mensajes(){
      int aux = ran.nextInt(5) + 1;
      switch (aux) {
         case 1:
            return "No pasó nada, sigue la ronda";
         case 2:
            return "Te has salvado, el que sigue";
         case 3:
            return "Has tenido suerte, continúa la ronda";
         case 4:
            return "Por un pelo de rana calva";
         default:
            return "FFFIIIUUUUU, qué nervios";
      }
   }

}
