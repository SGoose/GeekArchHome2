package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpResponse {

    private int statusCode;

    private String http;
    private String status;
    private String headers;
    private final SocketService socketService;

    public HttpResponse(String file, SocketService socketService, int statusCode, String http, String headers, String status) {
        this.statusCode = statusCode;
        this.http = http;
        this.headers = headers;
        this.status = status;
        this.socketService = socketService;
        this.file = file;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public HttpResponse(SocketService socketService) {

        this.socketService = socketService;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public SocketService getSocketService() {
        return socketService;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }
    private String file;


    public String getHttp() {
        return http;
    }

    public String getHeaders() {
        return headers;
    }

    // TODO
    public String getFile() {
        return file = ("HTTP/1.1 200 OK\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n");
    }



    public String getStatus() {
        return status= ("HTTP/1.1 404 NOT_FOUND\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n");
    }

}
