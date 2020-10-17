package org.team2059.scouting.core;

import java.io.Serializable;

public class Match implements Serializable
{
    private String teamName;
    private int matchNumber;
    private int teamPoints;
    private int alliancePoints;
    private int rankPoints;
    private String matchResult;


    public Match(String name, int number, String result)
    {
        teamName = name;
        matchNumber = number;
        matchResult = result;
    }

    /*get methods*/
    public String getTeamName()
    {
        return teamName;
    }
    public int getMatchNumber()
    {
        return matchNumber;
    }
    public int getTeamPoints()
    {
        return teamPoints;
    }
    public int getAlliancePoints()
    {
        return alliancePoints;
    }
    public double getRankPoints()
    {
        return rankPoints;
    }
    public String getMatchResult()
    {
        return matchResult;
    }

    public void setTeamPoints(int points){
        teamPoints = points;
    }

    public void setAlliancePoints(int allPoints){
        alliancePoints = allPoints;
    }

    public void setRankPoints(int rankPoints){
        this.rankPoints = rankPoints;
    }

}