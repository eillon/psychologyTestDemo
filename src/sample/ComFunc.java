package sample;

import javafx.scene.shape.Circle;

public class ComFunc {
    private static long timeStart=0;
    private static long timeEnd =0 ;

    public static boolean inCircle(double x, double y, Circle circle){
        double cx= circle.getCenterX(),cy = circle.getCenterY(),cr = circle.getRadius();
        if(cx==0 || cy==0) return false;
        if((x-cx)*(x-cx)+(y-cy)*(y-cy)>cr*cr) return false;
        return true;
    }


    public static long getTimeStart() {
        return timeStart;
    }

    public static void setTimeStart(long i) {
        timeStart = i;
    }

    public static long getTimeEnd() {
        return timeEnd;
    }

    public static void setTimeEnd(long i) {
        timeEnd = i;
    }
}
