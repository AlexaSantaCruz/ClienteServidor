import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  protected ServerSocket serverSocket;
  protected Socket clientSocket;
  protected DataOutputStream outputClient;
  protected BufferedReader input;
  protected String message;

  public Servidor() throws IOException {
    serverSocket = new ServerSocket(1234);
    clientSocket = new Socket();
  }

  public void startServer() {
    try {
      System.out.println("Esperando...");
      clientSocket = serverSocket.accept();
      System.out.println("Cliente en línea...");
      // Se obtiene el flujo de salida del cliente para enviarle mensajes
      outputClient = new DataOutputStream(clientSocket.getOutputStream());
      // Se le envía un mensaje al cliente usando su flujo de salida
      outputClient.writeUTF("Petición recibida y aceptada");
      // Se obtiene el flujo entrante desde el cliente
      input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      while ((message = input.readLine()) != null) {
        System.out.println(message);
      }
      System.out.println("Fin de la conexión");
      serverSocket.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) throws IOException {
    Servidor server = new Servidor();
    System.out.println("Iniciando servidor...");
    server.startServer();
  }
}
