package com.zacisrael;
/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel and Terry Floyd II*/

public class KlingWord {

    private String kn;
    private String en;

    public KlingWord(){
        kn = en = "";
    }

    public KlingWord(String knWord, String enWord) {
        kn = knWord;
        en = enWord;
    }

    public String getKN() {
        return kn;
    }

    public String getEN() {
        return en;
    }

    @Override
    public String toString() {
        String rs = "KlinglingWord: " + kn + ", English meaning: " + en;
        return rs;
    }
}
