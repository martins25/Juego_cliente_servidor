import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HiloServidor extends Thread{
	
	Socket comunicacionCliente1;
	ArrayList<Jugador> mejoresJuagadores;
	
	public HiloServidor(Socket comunicacionCliente1, ArrayList<Jugador> mejoresJuagadores) {
		this.comunicacionCliente1 = comunicacionCliente1;
		this.mejoresJuagadores = mejoresJuagadores;
	}
	
	
	@Override
	public void run() {
		
		try {
			
	        String preguntas[][] = {{"¿Cual es la capital de Francia?", "b"},
	                {"¿Cual es el rio mas grande del mundo?", "c"},
	                {"¿Cuantos planetas hay en el sistema solar?", "d"},
	                {"¿Quien escribio 'Cien años de soledad", "a"},
	                {"¿En que año empezo la segunda guerra mundial", "d"}};
	        
	
	        String respuestas[][] = {{"A) Berlin", "B) Paris", "C) Madrid", "D) Roma"},
	                {"A) Nilo", "B) Yangte", "C) Amazonas", "D) Misisipi"},
	                {"A) 7", "B) 8", "C) 10", "D) 9"},
	                {"A) Gabriel Garcia Marquez", "B) Mario Vargas Llosa", "C) Isabel Allende", "D) Julio Cortazar"},
	                {"A) 1935", "B) 1941", "C) 1945", "D) 1939"}};
	
	
			
			
			 DataInputStream diEntrada1 = new DataInputStream(comunicacionCliente1.getInputStream());
	         String usuario = diEntrada1.readUTF();
	
	         Jugador jugador = new Jugador(usuario);
	
	         ObjectOutputStream doSalida = new ObjectOutputStream(comunicacionCliente1.getOutputStream());
	         doSalida.writeObject(preguntas);
	         doSalida.writeObject(respuestas);
	
				DataOutputStream doSalida2 = new DataOutputStream(comunicacionCliente1.getOutputStream());
	
	         int puntos = 0;
	         for (int i = 0; preguntas.length > i; i++) {
	         	String respuesta = diEntrada1.readUTF();
	             if (respuesta.equalsIgnoreCase(preguntas[i][1])) {
	                 puntos++;
	                 doSalida2.writeUTF("Acerto!!!");
	             } else {
	                 doSalida2.writeUTF("Fallo :(");
	             }
	
	         }
	
	         jugador.setPuntos(puntos);
	
	         for (int j =0 ; mejoresJuagadores.size()> j; j++) {
	         	
	         	Jugador aux; 
	         	if(jugador.getPuntos()>=mejoresJuagadores.get(j).getPuntos()) {
	         		aux = mejoresJuagadores.get(j);
	         		mejoresJuagadores.set(j, jugador);
	         		jugador = aux;
	         	}
	         }
	         
	
	         doSalida.writeObject(mejoresJuagadores);
	
	         doSalida.close();
	         comunicacionCliente1.close();
	         
		}catch (Exception e) {
			e.printStackTrace();
		}
	         
	}
}
