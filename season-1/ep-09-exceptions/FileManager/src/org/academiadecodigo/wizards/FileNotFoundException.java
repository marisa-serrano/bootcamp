package org.academiadecodigo.wizards;

public class FileNotFoundException extends FileException{

    public FileNotFoundException(){
        super("This file does not exist");
    }

}
