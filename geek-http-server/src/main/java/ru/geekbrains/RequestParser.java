package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface RequestParser {


    public default Path Parser(String WWW , List<String> request){
        String[] parts = request.get(0).split(" ");
        Path path = Paths.get(WWW,  parts[1]);
        return path;
    }
}
