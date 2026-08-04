import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        int port = 8080;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port" + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected!");
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }       
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port + ": " + e.getMessage());
        }
    }
}