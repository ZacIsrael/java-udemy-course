package com.zacisrael;

import java.lang.reflect.Array;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here
        League<Team<BaksteballPlayer>> NBA = new League<>("NBA");
        Team<BaksteballPlayer> wizards = new Team<>("Washington Wizards");
        Team<BaksteballPlayer> lakers = new Team<>("L.A Lakers");
        Team<BaksteballPlayer> suns = new Team<>("Phoenix Suns");
        Team<BaksteballPlayer> magic = new Team<>("Orlando Magic");
        Team<BaksteballPlayer> raptors = new Team<>("Toronto Raptors");
        Team<BaksteballPlayer> warriors = new Team<>("Golden State Warriors");

        NBA.addTeam(wizards);
        NBA.addTeam(lakers);
        NBA.addTeam(warriors);
        NBA.addTeam(suns);
        NBA.addTeam(magic);
        NBA.addTeam(raptors);

        League<Team<SoccerPlayer>> laLiga = new League<>("La Liga");

        NBA.showLeagueTable();

        lakers.matchResult(wizards, 92,88);
        magic.matchResult(lakers, 105,104);
        raptors.matchResult(warriors,103,92);
        raptors.matchResult(wizards, 85, 97);
        suns.matchResult(lakers,88,73);

        NBA.showLeagueTable();








    }


}
