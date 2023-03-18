package org.team2059.scouting.core.frc2023;

import org.team2059.scouting.core.Match;

/**
 * rank points:
 * Win Game = 2 RP, TIE = 1 RP
 * 26 Grid Points = 1RP
 * Sustainibility Bonus = 1RP
 * 
 */

public class CuMatch extends Match {
    private CuAuto auto;
    private CuTeleop teleop;
    private CuEndgame endgame;
    private CuPostGame postGame;

    public CuMatch(String name, int number, CuAuto auto, CuTeleop teleop,
            CuEndgame endgame, CuPostGame postGame) {
        super(name, number, postGame.getMatchResult());
        this.auto = auto;
        this.teleop = teleop;
        this.endgame = endgame;
        this.postGame = postGame;
        super.setTeamPoints(calTotalPoints());
        super.setRankPoints(calRankPoints());
    }

    public CuAuto getAuto() {
        return auto;
    }

    public CuTeleop getTeleop() {
        return teleop;
    }

    public CuEndgame getEndgame() {
        return endgame;
    }

    public CuPostGame getPostGame() {
        return postGame;
    }

    /* calculated methods */
    private int calTotalPoints() {
        int total = 0;
        if (auto.getInitLine()) {
            total += 3;
        }
        total += ((auto.getBotCube() + auto.getBotCone()) * 3) + ((auto.getMidCube() + auto.getMidCone()) * 4)
                + ((auto.getTopCube() + auto.getTopCone()) * 6);

        if (auto.getDockedNotEngaged())
            total += 8;
        if (auto.getDockedEngaged())
            total += 12;

        total += ((teleop.getBotCube() + teleop.getBotCone()) * 2)
                + ((teleop.getMidCube() + teleop.getMidCone()) * 3)
                + ((teleop.getTopCube() + teleop.getTopCone()) * 5) + (teleop.getLinks() * 5);

        if (endgame.getPark())
            total += 2;
        if (endgame.getDockedNotEngaged())
            total += 6;
        if (endgame.getDockedEngaged())
            total += 10;
        return total;
    }

    private int calRankPoints() {
        int total = 0;
        if (postGame.getMatchResult().equals("win")) {
            total += 2;
        } else if (postGame.getMatchResult().equals("tie")) {
            total += 1;
        }
        if (postGame.getSustainibilityBonus())
            total += 1;

        if (postGame.getActivationBonus())
            total += 1;

        return total;
    }
}