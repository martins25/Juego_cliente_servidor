# Juego Cliente-Servidor

Este repositorio contiene una implementación en Java de un sistema cliente-servidor. El proyecto utiliza sockets para la comunicación entre clientes y el servidor, implementando un juego de preguntas y respuestas en el que los jugadores intentan acumular puntos respondiendo correctamente.

## Descripción General

El juego sigue la siguiente estructura:
- El servidor gestiona las preguntas y respuestas, y mantiene un registro de los mejores jugadores.
- Los clientes se conectan al servidor, responden las preguntas y reciben su puntuación.
- Al finalizar, el servidor envía el top 5 de jugadores con las mejores puntuaciones.

### Clases Principales

1. **`Servidor`**
   - Escucha conexiones entrantes de clientes.
   - Crea un hilo para manejar cada cliente.
   - Mantiene un ranking global de los mejores jugadores.

2. **`HiloServidor`**
   - Gestiona la comunicación con un cliente específico.
   - Envía las preguntas, recibe las respuestas y actualiza la puntuación del jugador.
   - Actualiza el ranking de mejores jugadores.

3. **`Cliente`**
   - Se conecta al servidor.
   - Recibe preguntas y envía respuestas.
   - Al finalizar, recibe el ranking actualizado de mejores jugadores.

4. **`Jugador`**
   - Representa a un jugador con atributos como nombre y puntuación.
   - Implementa la interfaz `Serializable` para ser transmitido entre el cliente y el servidor.

---

## Tecnologías Usadas
- **Lenguaje:** Java
- **Conexiones de red:**
  - Sockets (`Socket`, `ServerSocket`)
  - Flujo de datos (`DataInputStream`, `DataOutputStream`)
  - Serialización de objetos (`ObjectInputStream`, `ObjectOutputStream`)

---

## Ejecución del Proyecto

### Requisitos

- **Java:** Versión 8 o superior.
- **IDE recomendado:** IntelliJ IDEA, Eclipse o cualquier editor de texto con soporte para Java.

### Instrucciones

1. Clona el repositorio:
   ```bash
   git clone https://github.com/martins25/Juego_cliente_servidor
   cd Juego-cliente-servidor
   ```

2. Compila las clases:
   ```bash
   javac *.java
   ```

3. Inicia el servidor:
   ```bash
   java Servidor
   ```

4. Inicia uno o varios clientes:
   ```bash
   java Cliente
   ```

---

## Detalles de las Clases

### **Servidor**
- Mantiene el socket principal para escuchar conexiones.
- Utiliza hilos para manejar múltiples clientes simultáneamente.
- Administra un ranking global de los mejores jugadores.

### **HiloServidor**
- Envía preguntas y respuestas al cliente.
- Valida las respuestas del cliente y asigna puntos.
- Actualiza el ranking global de jugadores.

### **Cliente**
- Conecta al servidor mediante sockets.
- Envía el nombre del jugador y sus respuestas.
- Recibe el ranking actualizado al finalizar.

### **Jugador**
- Implementa la serialización para ser enviado entre cliente y servidor.
- Incluye atributos para almacenar el nombre y los puntos del jugador.

---

## Ejemplo de Salida

### **Servidor**
```plaintext
SERVER ENCENDIDO
```

### **Cliente**
```plaintext
Introduce tu nombre:
Ana

----------------------------
Pregunta: ¿Cuál es la capital de Francia?
A) Berlín
B) París
C) Madrid
D) Roma
Introduce la respuesta deseada:
B

Acertó!!!

----------------------------
TOP 5 MEJORES JUGADORES:
1: Ana - 3 puntos
2: Jose - 2 puntos
3: N/A - 0 puntos
...
```

---

## Contribución
Si deseas mejorar este proyecto o reportar algún problema, puedes abrir un issue o enviar un pull request.

---

### Autor
Proyecto desarrollado como ejercicio de aprendizaje en redes y programación concurrente con Java.

