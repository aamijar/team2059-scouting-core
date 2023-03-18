package org.team2059.scouting.core.frc2023;

import java.util.ArrayList;

import org.team2059.scouting.core.Match;
import org.team2059.scouting.core.Team;

public class CuTeam extends Team {

    private ArrayList<CuMatch> matches;

    public CuTeam(String name, String number, String district, ArrayList<Match> mList) {
        super(name, number, district, mList);
        matches = super.getCuMatches();
    }

    // tot auto points, tot teleop points, tot endgame points
    // balls scored auto, balls scored teleop, number of times climbed, number of
    // times leveled
    // position control count, rotation control count
    // OPR - average point contribution per match
    // ball accuracy

    public int getAutoPoints() {
        int autoPoints = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            if (auto.getInitLine())
                autoPoints += 3;

            autoPoints += ((auto.getBotCube() + auto.getBotCone()) * 3) + ((auto.getMidCube() + auto.getMidCone()) * 4)
                    + ((auto.getTopCube() + auto.getTopCone()) * 6);

            if (auto.getDockedNotEngaged())
                autoPoints += 8;
            if (auto.getDockedEngaged())
                autoPoints += 12;
        }
        return autoPoints;
    }

    public int getTeleopPoints() {
        int teleopPoints = 0;
        for (CuMatch match : matches) {
            CuTeleop teleop = match.getTeleop();
            teleopPoints += ((teleop.getBotCube() + teleop.getBotCone()) * 2)
                    + ((teleop.getMidCube() + teleop.getMidCone()) * 3)
                    + ((teleop.getTopCube() + teleop.getTopCone()) * 5) + (teleop.getLinks() * 5);
        }
        return teleopPoints;
    }

    public int getEndgamePoints() {
        int endgamePoints = 0;
        for (CuMatch match : matches) {
            CuEndgame endgame = match.getEndgame();
            if (endgame.getPark())
                endgamePoints += 2;
            if (endgame.getDockedNotEngaged())
                endgamePoints += 6;
            if (endgame.getDockedEngaged())
                endgamePoints += 10;
        }
        return endgamePoints;
    }

    public int getCubeCount() {
        int cubeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            cubeCount += auto.getBotCube() + auto.getMidCube() + auto.getTopCube();
            cubeCount += teleop.getBotCube() + teleop.getMidCube() + teleop.getTopCube();
        }
        return cubeCount;
    }

    public int getConeCount() {
        int coneCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            coneCount += auto.getBotCone() + auto.getMidCone() + auto.getTopCone();
            coneCount += teleop.getBotCone() + teleop.getMidCone() + teleop.getTopCone();
        }
        return coneCount;
    }

    public int getLinksCount() {
        int linksCount = 0;
        for (CuMatch match : matches) {
            CuTeleop teleop = match.getTeleop();
            linksCount += teleop.getLinks();
        }
        return linksCount;
    }

    public int getTopCount() {
        int topCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            topCount += auto.getTopCube() + auto.getTopCone();
            topCount += teleop.getTopCube() + teleop.getTopCone();
        }
        return topCount;
    }

    public int getMidCount() {
        int midCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            midCount += auto.getMidCube() + auto.getMidCone();
            midCount += teleop.getMidCube() + teleop.getMidCone();
        }
        return midCount;
    }

    public int getBotCount() {
        int botCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            botCount += auto.getBotCube() + auto.getBotCone();
            botCount += teleop.getBotCube() + teleop.getBotCone();
        }
        return botCount;
    }

    public int getBotCubeCount() {
        int botCubeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            botCubeCount += auto.getBotCube();
            botCubeCount += teleop.getBotCube();
        }
        return botCubeCount;
    }

    public int getBotConeCount() {
        int botConeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            botConeCount += auto.getBotCone();
            botConeCount += teleop.getBotCone();
        }
        return botConeCount;
    }

    public int getMidCubeCount() {
        int midCubeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            midCubeCount += auto.getMidCube();
            midCubeCount += teleop.getMidCube();
        }
        return midCubeCount;
    }

    public int getMidConeCount() {
        int midConeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            midConeCount += auto.getMidCone();
            midConeCount += teleop.getMidCone();
        }
        return midConeCount;
    }

    public int getTopCubeCount() {
        int topCubeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            topCubeCount += auto.getTopCube();
            topCubeCount += teleop.getTopCube();
        }
        return topCubeCount;
    }

    public int getTopConeCount() {
        int topConeCount = 0;
        for (CuMatch match : matches) {
            CuAuto auto = match.getAuto();
            CuTeleop teleop = match.getTeleop();
            topConeCount += auto.getTopCone();
            topConeCount += teleop.getTopCone();
        }
        return topConeCount;
    }
}