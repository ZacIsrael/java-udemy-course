public class Main {

    public static void main(String[] args) {
        // write your code here
        Playlist pl = new Playlist();

        pl.addFirst("Money", 26.0);
       // pl.addFirst("Love", 21.0);
        pl.displayPlayListForward();
        pl.displayPlayListBackward();
        System.out.println("\n");

        pl.deleteFirst();
        pl.addFirst("Life", 23.0);
        pl.displayPlayListForward();
        pl.displayPlayListBackward();
//        pl.addFirst("Life", 23.0);
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//        pl.addFirst("Love", 21.0);
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//        pl.addFirst("Awesome", 39.2);
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//        pl.addFirst("Hate", 45.0);
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//        pl.addLast("Fun", 29.0);
//        System.out.println(pl.getSize());
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//        pl.add("Laugh", 44.0, 2);
//        System.out.println(pl.getSize());
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//
//
//        System.out.println(pl.deleteEveryMthEpisode(4));



//        System.out.println(pl.deleteEpisode("Hate Now") + " was deleted from the playlist using the deleteEpisode(String title) method.");
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//
//
//        System.out.println("The first episode: "+pl.deleteFirst() + " was deleted from the playlist.");
//        System.out.println(pl.getSize());
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//        System.out.println("\n");
//
//        System.out.println("The last episode:" + pl.deleteLast() + " was deleted from the playlist.");
//        System.out.println(pl.getSize());
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//
//        System.out.println(pl.deleteEpisode("Love") + " was deleted from the playlist using the deleteEpisode(String title) method.");
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();
//
//        pl.deleteEpisode("Happy");
//        pl.displayPlayListForward();
//        pl.displayPlayListBackward();



    }
}
