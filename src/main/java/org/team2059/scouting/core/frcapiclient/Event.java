package org.team2059.scouting.core.frcapiclient;

import org.team2059.scouting.core.Team;

public class Event {

    private String name;
    private String code;
    private Team [] teams;

    public Event(String name, String code){
        this.name = name;
        this.code = code;
    }
    
    public Event(String name, String code, Team [] teams){
        this.name = name;
        this.code = code;
        this.teams = teams;
    }
    
    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public Team [] getTeams(){
        return teams;
    }

    public void setTeams(Team [] teams){
        this.teams = teams;
    }

}