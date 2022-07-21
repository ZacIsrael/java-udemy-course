package com.zacisrael;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {

//            Path fileToCreate = FileSystems.getDefault().getPath("Example", "files2.txt");
//            Files.createFile(fileToCreate);
            // creates an empty file named "files2.txt" in the "Example" directory

//            Path dirToCreate = FileSystems.getDefault().getPath("Example", "Dir4");
//            Files.createDirectory(dirToCreate);
            // creates an empty directory named "Dir4" under the "Example" directory

//            Path dirToCreate = FileSystems.getDefault().getPath("Example", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate);
            // creates Dir6 which is a subdirectory of Dir5 which is a subdirectory of Dir4 which is a subdirectory of Dir3, etc.

            Path filePath = FileSystems.getDefault().getPath("Example", "Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            // prints out the size of the specified txt file

            System.out.println("Last modified date = " + Files.getLastModifiedTime(filePath));
            // prints out the date of the last time the specified file was modified

            System.out.println("\n");
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified date = " + attrs.lastModifiedTime());
            System.out.println("Created = " +attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
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
