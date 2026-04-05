package org.firstinspires.ftc.teamcode.Practices.OpModes;

public class ConstructorClass {
    double angle;
    double x;


    public ConstructorClass(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        double angle = this.angle;

        while (angle > 180) {
            angle -= 360;
        }

        while (angle <= - 180) {
            angle += 360;
        }

        return angle;
    }
    public void changeAngle(double angleChange) {
        angle += angleChange;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public void resetAngle() {
        this.angle = 0;
    }
    double getAngle() {
        return this.angle;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void changeX(double xChange) {
        x += xChange;
    }
    public double getX() {
        return this.x;
    }
}
