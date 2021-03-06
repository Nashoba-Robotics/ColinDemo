package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PistonArm extends SubsystemBase {
    private Solenoid solenoid;

    public PistonArm() {
        solenoid = new Solenoid(1);
        SendableRegistry.setName(this, "Piston Arm");
    }

    public void extendArm() {
        solenoid.set(true);
    }

    public void retractArm() {
        solenoid.set(false);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
