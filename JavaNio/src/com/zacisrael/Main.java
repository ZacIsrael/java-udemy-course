package com.zacisrael;

import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    // Each folder aka directory is also a node in a path
    // Path example: You have a File named "file.txt" in stored in the downloads directory of your computer
    // The path would be C:\downloads\file.txt , the root node of the path would be "C:\", the other two nodes
    // in the file's path would be "downloads" and " file.txt"

    // absolute paths have a root node and gives enough info to locate the file, relative paths do not
    public static void main(String[] args) {

        // Using a Pipe to send data from one Thread  to another 
        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {

                    try {
                        // Pipes are used to channel the output from one program (or thread)
                        // into the input of another.

                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        // gets the sinkChannel
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        // allocates a buffer

                        for (int i = 0; i < 10; i++) {

                            String currentTime = "The time is: " + System.currentTimeMillis();

                            // Writing String to the buffer
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                // writing buffer into sinkChannel
                                sinkChannel.write(buffer);

                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {

                    try {

                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binChannel = binFile.getChannel()) {
//            // buffers capacity is the number of elements it can contain
//            // buffers position is the index of the next element that should read or written, can't be greater than the capacity
//
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//
//
//
//
//
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long intPos = outputBytes.length;
//            buffer.putInt(245);
//            long intPos2 = intPos + Integer.BYTES;
//            buffer.putInt(-98765);
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long intPos3 = intPos2 + Integer.BYTES + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();
//            binChannel.write(buffer);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(intPos3); // specify start position
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int 3 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(intPos2);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(intPos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rwd");
//            FileChannel copyChannel = copyFile.getChannel();
//            channel.position(0); // set the channel's position to the first index
//            //long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
//            // copy channel starting from index 0 in channel
//
//            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
//            // transfer the channel to copyChannel starting from index 0 in channel
//
//            System.out.println("Num transferred = " + numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }
}


// read(ByteBuffer) - reads bytes beginning at the channel"s current position, and after the read,
//                    updates the position accordingly.
// write(ByteBuffer) - the same as read, except it writes. There is one exception
//                     If a datasource is opened inAPPEND mode, the the first wrote will take place starting
//                     at  the end of the datasource, rather than at position 0. After the write, the position
//                     will be updated accordingly.
//