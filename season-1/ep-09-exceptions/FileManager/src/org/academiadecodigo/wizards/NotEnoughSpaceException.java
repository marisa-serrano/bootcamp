package org.academiadecodigo.wizards;

public class NotEnoughSpaceException extends FileException{

    public NotEnoughSpaceException(){

        super("There's not enough space");
    }
}
