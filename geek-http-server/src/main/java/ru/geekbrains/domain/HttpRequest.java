package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

import java.util.List;
import java.util.Map;

public class HttpRequest {
    private final SocketService socketService;

    private String method;

    private String path;

    private Map<String, String> headers;

    private String body;

    private List<String> request;

    public List<String> getRequest() {
        return request = socketService.readRequest();
    }

    public void setRequest(List<String> request) {
        this.request = request;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpRequest(SocketService socketService) {
        this.socketService = socketService;
    }

    // TODO constructors, getters, setters
}
