package ru.geekbrains;

public class Memento {
    private static String WWW = "C:/Users/User/Desktop/geek-architecture-123/www/anotherIndex.html";

    public static String getWWW() {
        return WWW;
    }

    public static void setWWW(String WWW) {
        Memento.WWW = WWW;
    }
    private static void restore(){
        WWW = "C:/Users/User/Desktop/geek-architecture-123/www/anotherIndex.html";
    }
}
