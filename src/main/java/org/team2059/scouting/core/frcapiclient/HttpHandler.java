package org.team2059.scouting.core.frcapiclient;

import java.io.IOException;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.team2059.scouting.core.Team;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHandler
{
    
    private final String HOST = "https://frc-api.firstinspires.org/v2.0/";
    private String AUTHORIZATION_KEY = "";
    
    private ArrayList<Competition> comps;

    public HttpHandler()
    {}


    public static void main(String [] args)
    {
        OkHttpClient client = new OkHttpClient();
        final HttpHandler hh = new HttpHandler();

        Request request = hh.getRequest("2020/districts");

        client.newCall(request).enqueue(new Callback(){
        
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    try{
                        JSONArray jsonArray = hh.fetchAsJsonArr(response.body().string(), "districts");
                        hh.comps = hh.getDistricts(jsonArray);
                        System.out.println(hh.comps.get(0).getName()); 

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println(response.message());
                }
            }
        
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure");
            }
        });
        
        
    }

    public Request getRequest(String query)
    {
        String [] credentials = AUTHORIZATION_KEY.split(":");
        
        String encodedKey = Credentials.basic(credentials[0], credentials[1]);
        
        Request request = new Request.Builder()
        .url(HOST + query)
        .addHeader("Authorization", encodedKey)
        .build();
        
        return request;
    }
    
    public JSONArray fetchAsJsonArr(String jsonStr, String key) throws Exception
    {
        JSONParser jp = new JSONParser();
        JSONObject jsonObject = (JSONObject) jp.parse(jsonStr);

        JSONArray jsonArray = (JSONArray) jsonObject.get(key);
        return jsonArray;
    }

    public ArrayList<Competition> getDistricts(JSONArray jsonArray)
    {
        ArrayList<Competition> comps = new ArrayList<Competition>();
        
        for(Object obj : jsonArray)
        {
            JSONObject district = (JSONObject) obj;
            comps.add(new Competition("District", district.get("name").toString(), district.get("code").toString()));
        }
        return comps;
    }
    public ArrayList<Competition> getChampionships(JSONArray jsonArray)
    {
        
        ArrayList<Competition> comps = new ArrayList<Competition>();
        
        for(Object obj : jsonArray)
        {
            JSONObject division = (JSONObject) obj;
            
            if(division.get("divisionCode") != null)
            {
                comps.add(new Competition("Championship Division", division.get("name").toString(), division.get("code").toString()));    
            }
        }
        return comps;
    }
    public ArrayList<Competition> getRegionals(JSONArray jsonArray)
    {
        
        ArrayList<Competition> comps = new ArrayList<Competition>();
        
        for(Object obj : jsonArray)
        {
            JSONObject regional = (JSONObject) obj;
            if(regional.get("type").toString().equals("Regional"))
            {
                comps.add(new Competition("Regional", regional.get("name").toString(), regional.get("code").toString()));
            }
        }
        return comps;
    }
    public Event [] getEvents(Competition comp, JSONArray jsonArray)
    {
        
        Event [] events = new Event[jsonArray.size()];
        
        for(int i = 0; i < jsonArray.size(); i++)
        {
            JSONObject event = (JSONObject) jsonArray.get(i);
            events[i] = new Event(event.get("name").toString(), event.get("code").toString());
        }
        comp.setEvents(events);
        
        return events;
    }

    // public String [] getTeams(Event event, JSONArray jsonArray)
    // {
    //     String [] teams = new String[jsonArray.size()];
        
    //     for(int i = 0; i < jsonArray.size(); i++)
    //     {
    //         JSONObject team = (JSONObject) jsonArray.get(i);
    //         teams[i] = team.get("nameShort").toString() + ", " + team.get("teamNumber").toString();
    //     }
        
    //     event.setTeams(teams);
    //     return teams;
    // }
    // /* overloaded method */
    // public String [] getTeams(Competition comp, JSONArray jsonArray)
    // {
    //     String [] teams = new String[jsonArray.size()];
    //     for(int i = 0; i < jsonArray.size(); i++)
    //     {
    //         JSONObject team = (JSONObject) jsonArray.get(i);
    //         teams[i] = team.get("nameShort").toString() + ", " + team.get("teamNumber").toString();
    //     }
    //     comp.setTeams(teams);
    //     return teams;
    // }

    public void setTeams(Event event, JSONArray teamJsonArray, JSONArray avatarJsonArray){
        
        Team [] teams = new Team[teamJsonArray.size()];
        for(int i = 0; i < teamJsonArray.size(); i ++){
            JSONObject team = (JSONObject) teamJsonArray.get(i);
            JSONObject teamAvatar = (JSONObject) avatarJsonArray.get(i);
            teams[i] = new Team(team.get("nameShort").toString(), team.get("teamNumber").toString(), 
            teamAvatar.get("encodedAvatar").toString());
        }
        event.setTeams(teams);
    }
    
    /*Overloaded Method*/
    public void setTeams(Competition comp, JSONArray teamJsonArray, JSONArray avatarJsonArray){
        
        Team [] teams = new Team[teamJsonArray.size()];
        for(int i = 0; i < teamJsonArray.size(); i ++){
            JSONObject team = (JSONObject) teamJsonArray.get(i);
            JSONObject teamAvatar = (JSONObject) avatarJsonArray.get(i);
            teams[i] = new Team(team.get("nameShort").toString(), team.get("teamNumber").toString(), 
            teamAvatar.get("encodedAvatar").toString());
        }
        comp.setTeams(teams);
    }

    public void setToken(String token)
    {
        AUTHORIZATION_KEY = token;
    }


}