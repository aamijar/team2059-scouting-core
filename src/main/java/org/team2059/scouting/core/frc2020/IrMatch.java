package org.team2059.scouting.core.frc2020;

import java.io.Serializable;

import org.team2059.scouting.core.Match;

/**
 * rank points:
 * Win Game = 2 RP, TIE = 1 RP
 * 65 Endgame Points = 1RP
 * Stage 3 activated = 1RP
 * 
 */

public class IrMatch extends Match implements Serializable
{
    private IrAuto auto;
    private IrTeleop teleop;
    private IrEndgame endgame;
    private IrPostGame postGame;

    public IrMatch(String name, int number, IrAuto auto, IrTeleop teleop, IrEndgame endgame, IrPostGame postGame)
    {
        super(name, number, postGame.getMatchResult());
        this.auto = auto;
        this.teleop = teleop;
        this.endgame = endgame;
        this.postGame = postGame;
        super.setTeamPoints(calTotalPoints());
        super.setRankPoints(calRankPoints());
    }

    public IrAuto getAuto()
    {return auto;}
    public IrTeleop getTeleop()
    {return teleop;}
    public IrEndgame getEndgame()
    {return endgame;}
    public IrPostGame getPostGame()
    {return postGame;}
    
    /*calculated methods*/
    private int calTotalPoints(){
        int total = 0;
        if(auto.getInitLine()){
            total += 5;
        }
        total += (auto.getLowerAttempt() * 2) + (auto.getOuterPort() * 4) + (auto.getInnerPort() * 6);
        total += teleop.getLowerPort() + (teleop.getOuterPort() * 2) + (teleop.getInnerPort() * 3);
        if(teleop.getControlPanel().getPosition()){
            total += 10;
        }
        if(teleop.getControlPanel().getRotation()){
            total += 20;
        }
        if(endgame.getLevel()){
            total += 40;
        }
        else if(endgame.getClimb()){
            total += 25;
        }
        else if(endgame.getPark()){
            total += 5;
        }
        return total;
    }
    
    int calRankPoints(){
        int total = 0;
        if(postGame.getMatchResult().equals("win")){
            total += 2;
        }
        else if(postGame.getMatchResult().equals("tie")){
            total += 1;
        }
        if(postGame.isStageThreeActivated()){
            total += 1;
        }
        if(postGame.isClimbRankPoint()){
            total += 1;
        }
        return total;
    }
}