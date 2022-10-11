package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public interface ResponseSerializer {

     default Reader answerResponse(Path path) throws IOException {
         return Files.newBufferedReader(path);

     }

     default String acceptAnswer(){
         HttpResponse httpResponse1 = new HttpResponse.BuilderResponse()
                 .withHttpCode("HTTP/1.1\n")
                 .withStatusCode("200 ")
                 .withStatus("OK ")
                 .withContentChar("Content-Type: text/html; charset=utf-8\n"+"\n")
                 .build();
         return httpResponse1.getAll();
     }
     default String nonAcceptAnswer(){
         HttpResponse httpResponse2 = new HttpResponse.BuilderResponse()
                 .withHttpCode("HTTP/1.1\n")
                 .withStatusCode("404 ")
                 .withStatus("NOT FOUND ")
                 .withContentChar("Content-Type: text/html; charset=utf-8\n"+"\n")
                 .build();
         return httpResponse2.getAll();
     }
    default Reader badAnswerResponse(Path path) throws IOException{
        return new StringReader("<h1>Файл не найден</h1>");
    }
}
