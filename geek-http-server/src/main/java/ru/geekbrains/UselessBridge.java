package ru.geekbrains;

public class UselessBridge {
    public void threadParser(String thread){

        String[] parts = thread.split("-");
        if (Integer.parseInt (parts[1]) > 3){
        Memento.setWWW("C:/Users/User/Desktop/geek-architecture-123/www/anotherIndex.html");
        }else  Memento.setWWW("C:/Users/User/Desktop/geek-architecture-123/www/index.html");
    }

}
