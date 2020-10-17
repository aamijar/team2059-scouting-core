package org.team2059.scouting.core.frcapiclient;

import org.team2059.scouting.core.Team;

public class Competition {

    private String type;
    private String name;
    private String code;
    private Event [] events;
    private Team [] teams;

    public Competition(String type, String name, String code){
        this.type = type;
        this.name = name;
        this.code = code;
    }

    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public Event [] getEvents(){
        return events;
    }
    public Team [] getTeams(){
        return teams;
    }

    /*set methods */
    public void setEvents(Event [] events){
        this.events = events;
    }
    public void setTeams(Team [] teams){
        this.teams = teams;
    }
    
}