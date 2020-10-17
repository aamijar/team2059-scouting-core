package org.team2059.scouting.core.frc2020;

public class IrTeleop extends IrAuto
{
    
    private IrControlPanel controlPanel;
    
    public IrTeleop(int lowerAttempt, int lowerPort, int upperAttempt, int outerPort, int innerPort, IrControlPanel controlPanel)
    {
        super(true, lowerAttempt, lowerPort, upperAttempt, outerPort, innerPort);
        this.controlPanel = controlPanel;
    }

    public IrControlPanel getControlPanel()
    {return controlPanel;}
        
}