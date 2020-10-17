package org.team2059.scouting.core.frc2020;

import java.io.Serializable;

public class IrAuto implements Serializable
{
    private boolean initLine;
    private int lowerAttempt;
    private int lowerPort;
    private int upperAttempt;
    private int outerPort;
    private int innerPort;
    
    
    public IrAuto(boolean initLine, int lowerAttempt, int lowerPort, int upperAttempt, int outerPort, int innerPort)
    {
        this.initLine = initLine;
        this.lowerAttempt = lowerAttempt;
        this.lowerPort = lowerPort;
        this.upperAttempt = upperAttempt;
        this.outerPort = outerPort;
        this.innerPort = innerPort;
    }
    
    public boolean getInitLine()
    {return initLine;}
    public int getLowerAttempt()
    {return lowerAttempt;} 
    public int getLowerPort()
    {return lowerPort;}
    public int getUpperAttempt()
    {return upperAttempt;}
    public int getOuterPort()
    {return outerPort;}
    public int getInnerPort()
    {return innerPort;}
}