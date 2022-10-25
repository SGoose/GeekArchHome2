package ru.geekbrains;

import ru.geekbrains.domain.Mapper;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

public class HttpServer {
    private static final Logger logger = new ConsoleLogger();

    public static void main(String[] args) throws SQLException {
        Mapper mapper = new Mapper();
        Scanner scanner = new Scanner(System.in);
        String[] scn = scanner.nextLine().split(" ");
        if (mapper.checkInfo(scn[0], scn[1])){
            serverStart();
        }
    }
    public static void serverStart(){
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            logger.info("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
