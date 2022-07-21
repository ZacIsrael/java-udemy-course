package com.zacisrael;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Notes {

    public static void main(String[] args) {

//        try{
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.deleteIfExists(fileToDelete);
//            // deletes the file if it exits



//            Path fileToMove = FileSystems.getDefault().getPath("Example", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Example", "file1.txt");
//            Files.move(fileToMove, destination);
            // renames the file1.txt to file1.txt

//            Path fileToMove = FileSystems.getDefault().getPath("Example", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("Example", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);
            // will move the file1copy.txt from the Example directory to the Dir1 directory which is a subdirectory of Example



//            Path sourceFile = FileSystems.getDefault().getPath("Example", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Example", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // will replace file1copy.txt if it already exits
//            // a file named file1copy.txt will be created and will be have the same txt that is in  file1.txt
//
//            sourceFile = FileSystems.getDefault().getPath("Example", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Example", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//            // Will make a copy of Dir1 and name it Dir4
//        } catch (IOException e){
//            e.printStackTrace();
//        }

      //  Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//        System.out.println("\n");
//      //  Path filePath = FileSystems.getDefault().getPath("files","file1.txt");
//        Path filePath = Paths.get(".","files","file1.txt");
//
//        printFile(filePath);
//
//        System.out.println("\n");
//      //  filePath = Paths.get("/Users/zacisrael/Desktop/UdemyJava/OutThere.txt");
//        filePath = Paths.get("/Users/zacisrael/Desktop", "/UdemyJava","OutThere.txt");
//
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//        System.out.println("\n");
//
//        Path paths2 = FileSystems.getDefault().getPath(".","files", "..", "files", "file1.txt");
//        System.out.println(paths2.normalize().toAbsolutePath());
//        printFile(paths2);
//        System.out.println("\n");
//
//        // No exceptions are thrown for files that do not exist so we must do a check if the file
//        // actually exists
//        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
//        System.out.println(path3.toAbsolutePath());
//        System.out.println("\n");
//
//        Path path4 = Paths.get("/Users/zacisrael/Desktop", "abcdef", "whatever.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        // checks if this file directory actually exists
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath)); // true
//
//        System.out.println("Exists = " + Files.exists(path4)); // false because path4 does not exist

    }

    //    private static void printFile(Path path){
//
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
