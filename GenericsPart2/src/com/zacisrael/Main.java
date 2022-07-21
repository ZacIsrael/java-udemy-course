package com.zacisrael;

import java.lang.reflect.Array;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        FootballPlayer Joe = new FootballPlayer("Joe");
        BaseballPlayer Pat = new BaseballPlayer("Pat");
        SoccerPlayer Zac = new SoccerPlayer("Zac");
        BaseballPlayer Zvi = new BaseballPlayer("Zvi");
        SoccerPlayer Julius = new SoccerPlayer("Julius");
        FootballPlayer Jon = new FootballPlayer("Jon");
        SoccerPlayer Surf = new SoccerPlayer("Surf");
        BaseballPlayer Daniel = new BaseballPlayer("Daniel");
        SoccerPlayer Najja = new SoccerPlayer("Najja");
       BaseballPlayer Graham = new BaseballPlayer("Graham");
        FootballPlayer Justin = new FootballPlayer("Justin");
        SoccerPlayer Kyle = new SoccerPlayer("Kyle");
        SoccerPlayer Jefe = new SoccerPlayer("Shy Glizzy");

        SoccerPlayer Keith = new SoccerPlayer("Keith");





        Team<SoccerPlayer> soccerTeam = new Team<>("Barcelona");
        soccerTeam.addPlayer(Zac);
        soccerTeam.addPlayer(Julius);
        soccerTeam.addPlayer(Surf);
        soccerTeam.addPlayer(Najja);


        System.out.println(soccerTeam.numPlayers());

        Team<SoccerPlayer> realMadrid = new Team<>("Real Madrid");
        realMadrid.addPlayer(Kyle);
        realMadrid.addPlayer(Jefe);

        Team<FootballPlayer> footBallTeam = new Team<>("Redskins");
        footBallTeam.addPlayer(Joe);
        footBallTeam.addPlayer(Jon);
        footBallTeam.addPlayer(Justin);
        System.out.println(footBallTeam.numPlayers());

        soccerTeam.matchResult(realMadrid, 2,1);
        System.out.println("Rankings");
        System.out.println(footBallTeam.getName() + ": " + footBallTeam.ranking());
        System.out.println(soccerTeam.getName() + ": " + soccerTeam.ranking());

        System.out.println(soccerTeam.compareTo(realMadrid));
        System.out.println(realMadrid.compareTo(soccerTeam));

        







    }
}
