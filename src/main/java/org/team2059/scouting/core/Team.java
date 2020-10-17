package org.team2059.scouting.core;

import java.io.Serializable;
import java.util.ArrayList;

import org.team2059.scouting.core.frc2020.IrMatch;


public class Team implements Serializable{

    /**
     *
     */
    
    private String teamNumber;
    private String teamName;
    private String homeDistrict;
    private ArrayList<Match> matches;

    /* calculated stats */
    private double rankPointAvg;
    private int totalPoints;

    /* temp attrs */
    private String byteMapString;
    private int overallRank;

    public Team(String name, String number, String byteMapString) {
        teamName = name;
        teamNumber = number;
        this.byteMapString = byteMapString;
    }

    public Team(String name, String number, String district, ArrayList<Match> mList) {
        teamName = name;
        teamNumber = number;
        homeDistrict = district;
        matches = mList;
    }

    /* get methods */
    public String getTeamNumber() {
        return teamNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getHomeDistrict() {
        return homeDistrict;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public double getRankPointAvg() {
        rankPointAvg = calRankAvg();
        return rankPointAvg;
    }

    public int getTotalPoints() {
        totalPoints = calTotalPoints();
        return totalPoints;
    }

    public ArrayList<IrMatch> getIrMatches() {
        ArrayList<IrMatch> irMatches = new ArrayList<IrMatch>();
        for (Match m : matches) {
            irMatches.add((IrMatch) m);
        }
        return irMatches;
    }

    public String getbyteMapString() {
        return byteMapString;
    }

    public int getOverallRank() {
        return overallRank;
    }

    /* calulated methods */

    private double calRankAvg() {
        double avg = 0;
        for (int i = 0; i < matches.size(); i++) {
            avg += matches.get(i).getRankPoints();

        }
        avg = avg / matches.size();
        return avg;
    }

    private int calTotalPoints() {
        int sum = 0;
        for (Match m : matches) {
            sum += m.getTeamPoints();
        }
        return sum;
    }

    /* set methods */

    public void setByteMapString(String byteMapString) {
        this.byteMapString = byteMapString;
    }

    public void setOverallRank(int overallRank) {
        this.overallRank = overallRank;
    }

    /*Android Parceable methods*/



    



    


}