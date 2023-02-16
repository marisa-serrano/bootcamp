package org.academiadecodigo.wizards;

public class FileManager {

    private File[] filesArray;
    private boolean isLoggedIn;

    FileManager(int maxFiles){
        filesArray = new File[maxFiles];
    }

    private File getFileProcess(String fileName) throws FileNotFoundException {
        for (File file : filesArray) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        throw new FileNotFoundException();
    }

    private File createFileProcess(String filename) throws FileException {
        if (!isLoggedIn){
            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < filesArray.length;i++){
            if(filesArray[i] == null){
                filesArray[i] = new File(filename);
                return filesArray[i];
            }
        }
        throw new NotEnoughSpaceException();
    }

    public File createFile(String fileName){
        try {
            return createFileProcess(fileName);
        } catch (FileException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }


    public File getFile(String fileName){
        try {
            return getFileProcess(fileName);

        } catch (FileException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void login(){
        isLoggedIn = true;
    }
    public void logout(){
        isLoggedIn = false;
    }

}
