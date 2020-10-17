package org.team2059.scouting.core.frc2020;

import java.io.Serializable;
import java.util.ArrayList;

import org.team2059.scouting.core.Match;
import org.team2059.scouting.core.Team;

public class IrTeam extends Team implements Serializable{
    
    private ArrayList<IrMatch> matches;
    public IrTeam(String name, String number, String district, ArrayList<Match> mList){
        super(name, number, district, mList);
        matches = super.getIrMatches();
    }
    
    // tot auto points, tot teleop points, tot endgame points
    // balls scored auto, balls scored teleop, number of times climbed, number of times leveled
    // position control count, rotation control count
    // OPR - average point contribution per match
    // ball accuracy
    
    public int getAutoPoints(){
        int autoPoints = 0;
        for(IrMatch match : matches){
            IrAuto auto = match.getAuto();
            if(auto.getInitLine()){
                autoPoints += 5;
            }
            autoPoints += 5 * (auto.getLowerPort() + auto.getOuterPort() + auto.getInnerPort());
        }
        return autoPoints;
    }
    public int getTeleopPoints(){
        int teleopPoints = 0;
        for(IrMatch match : matches){
            IrTeleop teleop = match.getTeleop();
            teleopPoints += 5 * (teleop.getLowerPort() + teleop.getOuterPort() + teleop.getInnerPort());
            if(teleop.getControlPanel().getPosition()){
                teleopPoints += 20;
            }
            if(teleop.getControlPanel().getRotation()){
                teleopPoints += 40;
            }
        }
        return teleopPoints;
    }
    public int getEndgamePoints(){
        int endgamePoints = 0;
        for(IrMatch match : matches){
            IrEndgame endgame = match.getEndgame();
            if(endgame.getLevel()){
                endgamePoints += 40;
            }
            else if(endgame.getClimb()){
                endgamePoints += 25;
            }
            else if(endgame.getPark()){
                endgamePoints += 5;
            }
        }
        return endgamePoints;
    }
    public int getAutoPowercellCount(){
        int autoPowercellCount = 0;
        for(IrMatch match : matches){
            IrAuto auto = match.getAuto();
            autoPowercellCount += auto.getLowerPort() + auto.getOuterPort() + auto.getInnerPort();
        }
        return autoPowercellCount;
    }
    public int getTeleopPowercellCount(){
        int teleopPowercellCount = 0;
        for(IrMatch match : matches){
            IrTeleop teleop = match.getTeleop();
            teleopPowercellCount += teleop.getLowerPort() + teleop.getOuterPort() + teleop.getInnerPort();
        }
        return teleopPowercellCount;
    }
    public int getClimbCount(){
        int climbCount = 0;
        for(IrMatch match : matches){
            if(match.getEndgame().getClimb()){
                climbCount ++;
            }
        }
        return climbCount;
    }
    public int getLevelCount(){
        int levelCount = 0;
        for(IrMatch match : matches){
            if(match.getEndgame().getLevel()){
                levelCount ++;
            }
        }
        return levelCount;
    }
    public int getPositionControlCount(){
        int positionControlCount = 0;
        for(IrMatch match : matches){
            if(match.getTeleop().getControlPanel().getPosition()){
                positionControlCount ++;
            }
        }
        return positionControlCount;
    }
    public int getRotationControlCount(){
        int rotationControlCount = 0;
        for(IrMatch match : matches){
            if(match.getTeleop().getControlPanel().getRotation()){
                rotationControlCount ++;
            }
        }
        return rotationControlCount;
    }
    public double getAutoPowercellAccuracy(){
        int autoPowercellCount = getAutoPowercellCount();
        int autoPowercellAttempts = 0;
        
        for(IrMatch match : matches){
            IrAuto auto = match.getAuto();
            autoPowercellAttempts += auto.getLowerAttempt() + auto.getUpperAttempt();
        }
        if(autoPowercellAttempts == 0){
            return 0;
        }
        double accuracy = (double) autoPowercellCount/autoPowercellAttempts;
        return accuracy;
    }
    public double getTeleopPowercellAccuracy(){
        int teleopPowercellCount = getTeleopPowercellCount();
        int teleopPowercellAttempts = 0;
        
        for(IrMatch match : matches){
            IrTeleop teleop = match.getTeleop();
            teleopPowercellAttempts += teleop.getLowerAttempt() + teleop.getUpperAttempt();
        }
        if(teleopPowercellAttempts == 0){
            return 0;
        }
        double accuracy = (double) teleopPowercellCount/teleopPowercellAttempts;
        return accuracy;
    }
}