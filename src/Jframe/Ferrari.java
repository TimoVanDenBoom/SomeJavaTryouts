package Jframe;

/**
 * Created by Timo on 8-3-2016.
 */
public class Ferrari {

    private int speed;
    private int xPosition;
    private int yPosition;
    private int lastRectX;
    private int lastRectY;
    private int lastXTri;
    private int lastYTri;

    public Ferrari(int speed){
        this.speed = speed;
        this.xPosition = 170;
        this.yPosition = 300;
        this.lastRectX = this.xPosition;
        this.lastRectY = this.yPosition;
        this.lastXTri = this.xPosition;
        this.lastYTri = this.yPosition;
    }

    public void increaseSpeed(int increase){
        this.speed = this.speed + increase;
    }

    public void moveCircle(double degrees) {
        double r = 30;

        this.xPosition = (int) (r * Math.cos(degrees * Math.PI / 180)) + 180;
        this.yPosition = (int) (r * Math.sin(degrees * Math.PI / 180)) + 320;

    }

    public void moveTriangle(int speed){
        int scaledSpeed = speed / 10;

        if (this.xPosition >= 170 && this.xPosition < 220 && this.yPosition >= 300 && this.yPosition < 350){
            if (this.xPosition + scaledSpeed > 220){
                scaledSpeed = 220 - this.xPosition;
            }
            this.xPosition = this.xPosition + scaledSpeed;

            if(this.yPosition + scaledSpeed > 350){
                scaledSpeed = 350 - this.yPosition;
            }
            this.yPosition = this.yPosition + scaledSpeed;
        }

        else if (this.yPosition == 350 && this.xPosition > 120){
            if (this.xPosition - scaledSpeed < 120){
                scaledSpeed = this.xPosition - 120;
            }
            this.xPosition = this.xPosition - scaledSpeed;
        }

        else if (this.xPosition >= 120 && this.xPosition < 170 && this.yPosition <= 350 && this.yPosition >= 300){
            if (this.xPosition + scaledSpeed > 170){
                scaledSpeed = 170 - this.xPosition;
            }
            this.xPosition = this.xPosition + scaledSpeed;
            if (this.yPosition - scaledSpeed < 300){
                scaledSpeed = 300 - this.yPosition;
            }
            this.yPosition = this.yPosition - scaledSpeed;
        }

    }

    public void moveRectangle(int speed){
        int scaledSpeed = speed / 10;

        if (this.yPosition == 300 && this.xPosition <= 300) {
            if (this.xPosition + scaledSpeed > 300){
               scaledSpeed = 300 - this.xPosition;
            }
            this.xPosition = this.xPosition + scaledSpeed;
        }

        if (this.xPosition == 300 && this.yPosition <= 350) {
            if (this.yPosition + scaledSpeed > 350){
                scaledSpeed = 350 - this.yPosition;
            }
            this.yPosition = this.yPosition + scaledSpeed;
        }

        if (this.yPosition == 350 && this.xPosition >= 100) {
            if (this.xPosition - scaledSpeed < 100){
                scaledSpeed = this.xPosition - 100;
            }
            this.xPosition = this.xPosition - scaledSpeed;
        }

        if (this.xPosition == 100 && this.yPosition >= 300) {
            if (this.yPosition - scaledSpeed < 300){
                scaledSpeed = this.yPosition - 300;
            }
            this.yPosition = this.yPosition - scaledSpeed;
        }

    }

    public int getLastRectX() {
        return lastRectX;
    }

    public void setLastRectX(int lastRectX) {
        this.lastRectX = lastRectX;
    }

    public int getLastRectY() {
        return lastRectY;
    }

    public void setLastRectY(int lastRectY) {
        this.lastRectY = lastRectY;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getLastXTri() {
        return lastXTri;
    }

    public void setLastXTri(int lastXTri) {
        this.lastXTri = lastXTri;
    }

    public int getLastYTri() {
        return lastYTri;
    }

    public void setLastYTri(int lastYTri) {
        this.lastYTri = lastYTri;
    }
}
