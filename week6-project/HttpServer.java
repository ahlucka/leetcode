import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

    static class RequestHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            long startTime = System.currentTimeMillis();
            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();
            int statusCode = 500;


        try {
            if (!path.equals("/")) {
                statusCode = 404;
            } else if (!method.equals("GET")) {
                statusCode = 405;
                String response = "405 Method Not Allowed";
            } else {
                statusCode = 200;
            }
        }


        }

}