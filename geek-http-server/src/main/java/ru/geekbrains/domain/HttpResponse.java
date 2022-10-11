package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

public class HttpResponse {

    private String http;
    private String statusFile;
    private String headers;
    private SocketService socketService;
    private String statusCode;

    private String status;

    private String contentCharset;

    public void setStatus(String status) {
        this.statusFile = statusFile;
    }
    private HttpResponse(){

    }

    public HttpResponse(SocketService socketService) {
        this.socketService = socketService;
    }




    public SocketService getSocketService() {
        return socketService;
    }

    public String getHttp() {
        return http;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getContentCharset() {
        return contentCharset;
    }
    public String getAll(){
        String all = getHttp()+getStatusCode()+getStatus()+getContentCharset();
        return all;
    }
    public static class BuilderResponse {


        private HttpResponse httpResponse;

        public BuilderResponse() {
            this.httpResponse =  new HttpResponse();
        }

        public BuilderResponse withHttpCode(String http){
            this.httpResponse.http = http;
            return this;
        }
        public BuilderResponse withStatusCode(String statusCode){
            this.httpResponse.statusCode = statusCode;
            return this;
        }
        public BuilderResponse withStatus(String status){
            this.httpResponse.status = status;
            return this;
        }
        public BuilderResponse withContentChar(String contentCharset){
            this.httpResponse.contentCharset = contentCharset;
            return this;
        }
        public HttpResponse build(){
            return this.httpResponse;
        }

    }

}
