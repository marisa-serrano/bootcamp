package org.academiadecodigo.wizards;

public class FileException extends Exception{

    private String message;
    public FileException(String message){

        this.message = message;

    }

    public String getMessage(){

        return message;
    }


}
