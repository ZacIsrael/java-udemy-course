package com.zacisrael;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();


    }
}

class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read(){
        // reads the message
        while (empty){
            // while the message is empty,
            try{
                // when a thread calls the  wait method , it will suspend executions and release
                // whatever locks it's holding until another thread issues a notification that
                // something important has happened
                wait();

            } catch (InterruptedException e){

            }

        }
        empty = true;
        notifyAll();
        return message;

        // notifyAll() method causes the current thread to wait until it is awakened, typically
        //  by being <em>notified</em> or <em>interrupted</em>.
    }

    public synchronized void write(String message){
        // write the message
        while(!empty){
            // while the message is not empty
            try{
                wait();
            } catch(InterruptedException e){

            }

        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements  Runnable{

    // This class writes the four messages in the messages[] array

    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    public void run(){
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
                // there will be a two second delay before writing the next message
            } catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }

}

class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    public void run(){
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()) {
            // Iterating through all of the messages until the message is equal to "Finished"
            System.out.println(latestMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }

        }
    }
}
