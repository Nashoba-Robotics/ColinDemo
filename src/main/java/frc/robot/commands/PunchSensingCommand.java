package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PistonArm;

public class PunchSensingCommand extends CommandBase {
    private PistonArm pistonArm;

    public PunchSensingCommand(PistonArm pistonArm) {
        this.pistonArm = pistonArm;
        addRequirements(pistonArm);

        SendableRegistry.setName(this, SendableRegistry.getSubsystem(pistonArm), "Punch Sensing Command");
    }

    @Override
    public void execute() {
        double distanceToBall = pistonArm.getDistanceToBall();
        if (distanceToBall < 3.0 && distanceToBall > 1.0) {
            pistonArm.extendArm();
        } else {
            pistonArm.retractArm();
        }
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
