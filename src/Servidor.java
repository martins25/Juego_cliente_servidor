import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor{
    private static final int PUERTO = 9876;

    public static void main(String[] args) {

        System.out.println("SERVER ENCENDIDO");
        ServerSocket socketServidor = null;
        
        try {
            socketServidor = new ServerSocket(PUERTO);
        }catch (Exception e) {
        	e.printStackTrace();
		}
        
        ArrayList<Jugador> mejoresJuagadores = new ArrayList<Jugador>();
        mejoresJuagadores.add(new Jugador("Jose", 5));
        mejoresJuagadores.add(new Jugador("Agustin", 4));
        mejoresJuagadores.add(new Jugador("N/A", 0));
        mejoresJuagadores.add(new Jugador("N/A", 0));
        mejoresJuagadores.add(new Jugador("N/A", 0));
        
        try {
            while (true) {
            	            	
            	
                Socket comunicacionCliente1 = socketServidor.accept();

                HiloServidor hilo = new HiloServidor(comunicacionCliente1, mejoresJuagadores);
                hilo.start();
                
            }

        } catch (Exception e) {
            System.err.println("CONEXION PERDIDA");
            e.printStackTrace();
        }
    }
}
