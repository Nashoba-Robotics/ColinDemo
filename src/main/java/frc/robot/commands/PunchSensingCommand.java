package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class PunchSensingCommand extends CommandBase {
    PistonArm pistonArm;
    public PunchSensingCommand(PistonArm p){
        this.pistonArm = p;
        addRequirements(pistonArm);
        SendableRegistry.setName(this, SendableRegistry.getSubsystem(pistonArm), "Punch Sensing Command");
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double voltage = pistonArm.getValue();
        if(voltage > 0.5 && voltage < 3){
            pistonArm.extendArm();
        }
        else{
            pistonArm.retractArm();
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}