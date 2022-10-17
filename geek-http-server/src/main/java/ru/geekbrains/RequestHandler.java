package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class RequestHandler implements Runnable, RequestParser, ResponseSerializer {

    private static final String WWW = "C:/Users/User/Desktop/geek-architecture-123/www/index.html";


    private static final Logger logger = new ConsoleLogger();

    private final SocketService socketService;

    public RequestHandler(SocketService socketService) {
        this.socketService = socketService;
    }



    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        HttpRequest httpRequest = new HttpRequest(socketService);
        HttpResponse httpResponse = new HttpResponse(socketService);
        UselessBridge uselessBridge = new UselessBridge();
        Path path = Parser(uselessBridge.threadParser(currentThread.getName()), httpRequest.getRequest());
        if (!Files.exists(path)){
            try {
                httpResponse.getSocketService().writeResponse(nonAcceptAnswer(), badAnswerResponse(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            httpResponse.getSocketService().writeResponse(acceptAnswer(), answerResponse(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("Client disconnected!");

    }

}
