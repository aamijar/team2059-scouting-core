package org.team2059.scouting.core;

import org.team2059.scouting.core.frc2020.IrMatch;
import java.util.ArrayList;


public class FileManager
{
    public static ArrayList<Team> createTeamsArr(ArrayList<IrMatch> mlist)
    {
        ArrayList<Team> teamList = new ArrayList<Team>();
        ArrayList<String> usedTeams = new ArrayList<String>();
        boolean teamDone = false;
        for(int i = 0; i < mlist.size(); i ++)
        {
            ArrayList<Match> currentMatchList = new ArrayList<Match>();
            
            String defHomeDistrict = "NC";

            teamDone = false;
            for(String t : usedTeams)
            {
                if(mlist.get(i).getTeamName().equals(t))
                {
                    teamDone = true;
                }
            }    

            if(!teamDone)
            {
                
                for(int j = i; j < mlist.size(); j ++)
                {
                    if(mlist.get(i).getTeamName().equals(mlist.get(j).getTeamName()))
                    {
                        currentMatchList.add(mlist.get(j));
                    }
                }
                usedTeams.add(mlist.get(i).getTeamName());
                String [] teamNameSplit = mlist.get(i).getTeamName().split("\\s*,\\s*");
                
                teamList.add(new Team(teamNameSplit[0], teamNameSplit[1], defHomeDistrict, currentMatchList));
            }
        }
        return teamList;
    }
}