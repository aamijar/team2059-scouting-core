package org.team2059.scouting.core.frc2020;

import java.io.Serializable;

public class IrPostGame implements Serializable {
    
    private String matchResult;
    private boolean climbRankPoint;
    private boolean stageThreeActivated;
    private String notes;

    public IrPostGame(String matchResult, boolean climbRankPoint, boolean stageThreeActivated, String notes){
        
        this.matchResult = matchResult;
        this.climbRankPoint = climbRankPoint;
        this.stageThreeActivated = stageThreeActivated;
        this.notes = notes;
    }
    
    public String getMatchResult(){
        return matchResult;
    }

    public boolean isClimbRankPoint(){
        return climbRankPoint;
    }

    public boolean isStageThreeActivated(){
        return stageThreeActivated;
    }
    public String getNotes(){
        return notes;
    }
}