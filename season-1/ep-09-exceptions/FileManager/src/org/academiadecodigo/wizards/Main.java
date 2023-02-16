package org.academiadecodigo.wizards;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager(2);

        fileManager.login();
        /*try{
            File file = fileManager.createFile("abc");
            System.out.println(file.getName());
            fileManager.getFile("def");
            File file2 = fileManager.createFile("ghi");
            System.out.println(file2.getName());


        }catch (FileException ex){
            System.out.println(ex.getMessage());
        }*/

        File file = fileManager.createFile("abc");
        System.out.println(file.getName());

        File file2 = fileManager.createFile("def");
        System.out.println(file2.getName());


        System.out.println(fileManager.getFile("ghi"));

    }
}