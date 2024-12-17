import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static final int PUERTO = 9876;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            InetAddress dirServer = InetAddress.getByName("localhost");
            Socket cliente = new Socket(dirServer, PUERTO);

            DataOutputStream doSalida = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Introduce tu nombre:");
            doSalida.writeUTF(teclado.nextLine());

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            String[][] preguntas = (String[][]) ois.readObject();
            String[][] respuestas = (String[][]) ois.readObject();


            
			
           for (int i = 0; preguntas.length > i; i++) {
        	   	InputStream isEntrada = cliente.getInputStream();
   				DataInputStream diEntrada = new DataInputStream(isEntrada);
   			
            	System.out.println("\n----------------------------\n");
            	System.out.println("Introduce la respuesta deseada");
            	
                System.out.println(preguntas[i][0]);

                for (int j = 0; respuestas[i].length > j; j++) {
                    System.out.println("\t" + respuestas[i][j]);
                }
                
               String resultado;
               doSalida.writeUTF(teclado.nextLine());
                if((resultado = diEntrada.readUTF())!=null)
                	System.out.println(resultado);
            }
           	
            ArrayList<Jugador> j = (ArrayList<Jugador>) ois.readObject();
            recorreArray(j);

        } catch (Exception e) {
            System.err.println("CONEXION PERDIDA");
            e.printStackTrace();
        }
    }

    public static void recorreArray(ArrayList<Jugador> jugadores) {
    	System.out.println("\n\n");
    	System.out.println("TOP 5 MEJORES JUGADORES");
        for (int i = 0; jugadores.size() > i; i++) {
        	int j = 1;
        	j+=i;
            System.out.println(j+": "+jugadores.get(i).getNombre() + " - " + jugadores.get(i).getPuntos()+" puntos");
        }
    	System.out.println("\n\n");
    }
}
