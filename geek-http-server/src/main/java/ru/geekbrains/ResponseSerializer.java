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

    default Reader badAnswerResponse(Path path) throws IOException{
        return new StringReader("<h1>Файл не найден</h1>");
    }
}
