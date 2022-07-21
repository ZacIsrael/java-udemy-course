package com.zacisrael;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
//            public boolean accept(Path path) throws IOException{
//                return Files.isRegularFile(path);
//                // returns if the specified path is a file or not
//            }
//        };

        // Lambda expression equivalent for filter method
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
        // Path directory = FileSystems.getDefault().getPath("FileTree/Dir2"); // creating path of directory
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2"); // creating path of directory
        // better to use File.separator instead of hardcoding it because File.separator will support all machines and systems
        // hardcoding will only support systems like the one your are coding on (i.e Mac = / , Windows = \\ )
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            // *.dat will return any file that ends with .dat, * ___ will return any file that ends with ___
            // creating directory stream
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }


        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp", "appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println(store);
            System.out.println(store.name());
            System.out.println("\n");
        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println("Path " + path);
        }

        System.out.println("Walking tree for Dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree", File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Copy Dir2 to Dir4/Dir2Copy");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");

        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File(File.separator + "Examples" + File.separator + "file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File(File.separator + "Examples");
        File resolvedFile = new File(parent, "dir" + File.separator + "file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File(File.separator + "Examples", "dir" + File.separator + "file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get(File.separator + "Examples");
        Path childRelativePath = Paths.get("dir" + File.separator + "file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, File.separator + "FileTree" + File.separator + "Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i < dir2Contents.length; i++) {
            System.out.println("i = " + i + ": " + dir2Contents[i]);
        }


        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[]  dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++) {
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }

    }


}
