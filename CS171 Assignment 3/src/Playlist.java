/*THIS CODE WAS MY OWN,IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY
OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel */

public class Playlist {

    private Episode head;
    private int size;

    public Playlist() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void displayPlayListForward() {
        String output = "[BEGIN] ";
        Episode current = head;
        while (current.next != head) {
            output += current + " -> ";
            current = current.next;
        }
        output += current + " [END]\n";
        System.out.println(output);
    }

    public void displayPlayListBackward() {
        String print = "[END] ";
        Episode current = head.previous;
        if (isEmpty()) {
            // if the list is empty, throw runtime exception
            throw new RuntimeException("This playlist is empty.");
        }
        while (current != head) {
            // while the current element is not equal to the head,
            // add it ti the print String
            print += current + " -> ";
            current = current.previous; // iterate to the previous Episode
        }
        // By this time the current episode is the head so I just added the head to the print String
        print += head + " [BEGIN]\n";
        System.out.println(print);
    }

    public void addFirst(String title, double duration) {
        if (isEmpty()) { // If the list is empty, create a new episode and
            // initialize the previous and next episodes to null and then set
            // this episode to the head.
            Episode temp = new Episode(title, duration, null, null);
            head = temp;
            head.next = head;
            // since there is only 1 episode in the playlist, the head needs to point to itself for its previous
            // and next references
            head.previous = head;
            size++; // increment the size
        } else {
            Episode currentHead = head;
            Episode current = head;
            for (int i = 0; i < getSize() - 1; i++) {
                current = current.next;
            }
            Episode temp = new Episode(title, duration, currentHead, current);
            Episode originalHead = head; // original head of the playlist
            originalHead.previous = temp;
            // the head is not the second episode in the playlist and is assigning the temp
            // episode as it's previous reference
            current.next = temp; // the last element's next reference is the temp episode
            head = temp; // the head of the playlist is now equal to the temp episode
            size++; // increment the size
        }
    }

    public void addLast(String title, double duration) {
        if (isEmpty()) { // If the list is empty, create a new episode and
            // intialize the previous and next episodes to null and then set
            // this episode to the head.
            Episode temp = new Episode(title, duration, null, null);
            head = temp;
            head.next = temp;
            head.previous = temp;
            size++; // increment the size
        } else {
            Episode last = head;
            for (int i = 0; i < getSize()-1; i++) {
                last = last.next;
            }
            // now we are at the last episode in the list
            Episode temp = new Episode(title, duration, head, last);
            last.next = temp; // sets the temp Episode as the last episode in the playlist
            head.previous = temp; // sets the temp Episode as the previous to the head because this is a circular List
            temp.previous = last;
            // the temp episode's previous reference is pointing to the episode that use to be the tail of the playlist
            size++; // increment the size by 1
        }
    }

    public void add(String title, double duration, int index) {
        if (index > getSize()) {
            throw new RuntimeException("This list is not not large enough to add an element at the specified index.");
        } else {
            Episode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            // current is now the element at the index -1
            Episode nextTemp = head;
            for (int j = 0; j < index; j++) {
                nextTemp = nextTemp.next;
            }
            // nextTemp is now the element at the episode at that index
            Episode temp = new Episode(title, duration, nextTemp, current);
            current.next = temp; // Episode current  next will be the Episode temp
            nextTemp.previous = temp;
            temp.next = nextTemp; // Episode temp's next will be Episode nextTemp
            temp.previous = current;
            size++; // increment the size

        }
    }

    public Episode deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("This playlist is empty, therefore no episodes can be deleted.");
        }
        if(getSize() == 1){
            Episode deleted = head;
            head = null;
            size--;
            return deleted;

        }
        Episode temp = head; // the head of the list
        Episode tempNext = head.next;
        Episode prev = head.previous;
        prev.next = tempNext; // The tail episode's next reference is to the second episode in the playlist
        tempNext.previous = prev; // the second episode's previous reference is to the last element
        head = tempNext; // the head is now equal to the second element in the playlist
        size--; // decrease the size by 1
        return temp; // return the original head , the firstElement
    }

    public Episode deleteLast() {
        if (isEmpty()) {
            // if the list is empty, throw this exception and display the following message
            throw new RuntimeException("This playlist is empty, therefore no episodes can be deleted.");
        }
        if(getSize() == 1){
            return deleteFirst();
        } else if(getSize() == 2){
           Episode headNext = head.next;
           head.next = head;
           head.previous = head;
           size--;
           return headNext;

        }
        Episode deleteCurrent = head.previous;

        // deleteCurrent is now on the last element in the list
        deleteCurrent.previous.next = head; // sets the second to last episode's next equal to the head
        head.previous = deleteCurrent.previous; // sets the previous of the last episode equal to the previous of the head's.
        size--; // decreases the size by 1
        return deleteCurrent;
    }

    public Episode deleteEpisode(String title) {
        if (isEmpty()) {
            throw new RuntimeException("The list is empty.");
        }
        Episode originalHead = head; // head episode of the playlist
        Episode ohPrevious = head.previous; // last episode in the playlist
        Episode ohNext = head.next; // second episode in the playlist
        Episode episodeIterator = head;

        if (head.getTitle().equals(title)) { // if the first episode's title in the playlist is equal to the title parameter,
            size--; // decrease the size of the playlist by 1
            ohNext.previous = originalHead.previous; // set the second episode's previous to the last episode
            ohPrevious.next = ohNext; // set the last episode's next to the second episode
            ohNext = ohPrevious.next; // set the second episode equal to the last episode's next
            head = ohNext;
            return originalHead; // this is the head episode that was deleted
        } else {
            while (episodeIterator.next != null && episodeIterator.next != head) {
                if (episodeIterator.getTitle().equals(title)) {
                    size--; // decrease the size of the playlist by 1
                    // Just for explanation purposes, episodeIterator = episode i
                    episodeIterator.next.previous = episodeIterator.previous; // set the i + 1 episode's previous reference equal to the i -1 episode
                    episodeIterator.previous = episodeIterator.next.previous; // set the i - 1 episode equal to the i + 1 episode's previous reference
                    episodeIterator.previous.next = episodeIterator.next; // set the i - 1 episode's next reference equal to the i + 1 episode
                    episodeIterator.next = episodeIterator.previous.next; // set the i + 1 episode equal to the i - 1 next reference
                    return episodeIterator; // return the i episode
                } else {
                    episodeIterator = episodeIterator.next;
                }
            }
            System.out.println("The episode " + title + " is not in the playlist.");
            return null; // if the title is not in the list, return null
        }
    }

    public Episode deleteEveryMthEpisode(int m) {
        if(isEmpty()){
            // If the list is empty, throw new RuntimeException and print the following message.
            throw new RuntimeException("The list is empty.");
        }
         final int originalSize = getSize();
         // If i do not create a copy of the size and declare it final, the size would continuously get smaller as I
        // iterate through the list which would prevent me from looping through all the episodes in the play list.
        while (getSize() > 1) { // While the size of the playlist is greater than 1
            Episode current = head;
            for (int j = 0; j < originalSize -1; j++) { // this loop iterates for the size - 1
                for (int i = 0; i < m; i++) { // nested loop iterates m times and keeps track of the m episode each time
                    current = current.previous;
                }
                current.previous.next = current.next;
                // sets the current episode's previous' next equal to the current episode's next
                current.next.previous = current.previous;
                // sets the current episode's next's previous equal to the current episode's previous
                current.next = current.previous.next;
                // sets the current episode's next equal to the current previous' next
                current.previous = current.next.previous;
                // sets the current episode's previous equal to the current episode's next's previous
                size--; // decreases the size by 1
            }
            current = current.previous;
            // this sets the current (the episode that was just removed) equal to the episode that has not been removed yet.

            head = current;
            // the episode that has not been removed is now the head of the playlist

        }
        return head;
        // return the head
    }

}
