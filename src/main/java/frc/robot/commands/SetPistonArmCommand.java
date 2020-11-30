package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PistonArm;

public class SetPistonArmCommand extends CommandBase {
    private final PistonArm pistonArm;
    private final boolean extended;

    public SetPistonArmCommand(PistonArm pistonArm, boolean extended) {
        addRequirements(pistonArm);

        this.pistonArm = pistonArm;
        this.extended = extended;

        SendableRegistry.setName(this, SendableRegistry.getSubsystem(pistonArm), extended ? "Extend Piston Arm" : "Retract Piston Arm");
    }

    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (extended) {
        pistonArm.extendArm();
    } else {
        pistonArm.retractArm();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}