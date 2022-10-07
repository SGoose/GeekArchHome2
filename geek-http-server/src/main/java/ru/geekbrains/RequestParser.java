package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface RequestParser {


    public default String Parser(List<String> request){
        String[] parts = request.get(0).split(" ");
        return parts[1];
    }
}
