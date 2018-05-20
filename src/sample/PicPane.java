package sample;


import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PicPane extends Pane {
    private static double radius = 20;
    private int clickCircle=0;
    private int picNum = 0;

    public PicPane(){
        picNum = 0;
        clickCircle =0 ;
    }

    private void update(){
        ImageView image = new ImageView("resources/"+picNum+".png");

        // create circle, set color to null
        final Circle c1=new Circle(radius);
        final Circle c2=new Circle(radius);
        final Circle c3=new Circle(radius);
        final Circle c4=new Circle(radius);
        final Circle c5=new Circle(radius);
        final Circle c6=new Circle(radius);

        c1.setStyle("-fx-stroke:null;-fx-fill:null;");
        c2.setStyle("-fx-stroke:null;-fx-fill:null;");
        c3.setStyle("-fx-stroke:null;-fx-fill:null;");
        c4.setStyle("-fx-stroke:null;-fx-fill:null;");
        c5.setStyle("-fx-stroke:null;-fx-fill:null;");
        c6.setStyle("-fx-stroke:null;-fx-fill:null;");

        switch (picNum){
            case 1:
                c1.setCenterX(187);c1.setCenterY(159);
                c2.setCenterX(187);c2.setCenterY(191);
                c3.setCenterX(305);c3.setCenterY(199);
                c4.setCenterX(305);c4.setCenterY(230);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 2:
                c1.setCenterX(162);c1.setCenterY(195);
                c2.setCenterX(250);c2.setCenterY(250);
                c3.setCenterX(338);c3.setCenterY(194);
                c4.setCenterX(0);c4.setCenterY(0);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 3:
                c1.setCenterX(167);c1.setCenterY(225);
                c2.setCenterX(400);c2.setCenterY(228);
                c3.setCenterX(0);c3.setCenterY(0);
                c4.setCenterX(0);c4.setCenterY(0);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 4:
                c1.setCenterX(156);c1.setCenterY(197);
                c2.setCenterX(135);c2.setCenterY(236);
                c3.setCenterX(346);c3.setCenterY(188);
                c4.setCenterX(346);c4.setCenterY(214);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 5:
                c1.setCenterX(141);c1.setCenterY(195);
                c2.setCenterX(177);c2.setCenterY(230);
                c3.setCenterX(303);c3.setCenterY(211);
                c4.setCenterX(362);c4.setCenterY(205);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 6:
                c1.setCenterX(159);c1.setCenterY(166);
                c2.setCenterX(205);c2.setCenterY(205);
                c3.setCenterX(254);c3.setCenterY(248);
                c4.setCenterX(323);c4.setCenterY(171);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 7:
                c1.setCenterX(115);c1.setCenterY(177);
                c2.setCenterX(129);c2.setCenterY(228);
                c3.setCenterX(314);c3.setCenterY(193);
                c4.setCenterX(363);c4.setCenterY(193);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            case 8:
                c1.setCenterX(161);c1.setCenterY(163);
                c2.setCenterX(163);c2.setCenterY(191);
                c3.setCenterX(254);c3.setCenterY(201);
                c4.setCenterX(252);c4.setCenterY(234);
                c5.setCenterX(336);c5.setCenterY(164);
                c6.setCenterX(341);c6.setCenterY(190);
                break;
            case 9:
                c1.setCenterX(148);c1.setCenterY(172);
                c2.setCenterX(202);c2.setCenterY(197);
                c3.setCenterX(248);c3.setCenterY(161);
                c4.setCenterX(322);c4.setCenterY(224);
                c5.setCenterX(0);c5.setCenterY(0);
                c6.setCenterX(0);c6.setCenterY(0);
                break;
            default:
                break;
        }

        setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x=event.getX(),y=event.getY();
                if(ComFunc.inCircle(x,y,c1)) {c1.setStroke(Color.RED);c2.setStroke(null);c3.setStroke(null);c4.setStroke(null);c5.setStroke(null);c6.setStroke(null);}
                else if(ComFunc.inCircle(x,y,c2)) {c2.setStroke(Color.RED); c1.setStroke(null);c3.setStroke(null);c4.setStroke(null);c5.setStroke(null);c6.setStroke(null);}
                else if(ComFunc.inCircle(x,y,c3)) {c3.setStroke(Color.RED); c2.setStroke(null);c1.setStroke(null);c4.setStroke(null);c5.setStroke(null);c6.setStroke(null);}
                else if(ComFunc.inCircle(x,y,c4)) {c4.setStroke(Color.RED); c2.setStroke(null);c3.setStroke(null);c1.setStroke(null);c5.setStroke(null);c6.setStroke(null);}
                else if(ComFunc.inCircle(x,y,c5)) {c5.setStroke(Color.RED); c2.setStroke(null);c3.setStroke(null);c4.setStroke(null);c1.setStroke(null);c6.setStroke(null);}
                else if(ComFunc.inCircle(x,y,c6)) {c6.setStroke(Color.RED); c2.setStroke(null);c3.setStroke(null);c4.setStroke(null);c5.setStroke(null);c1.setStroke(null);}
                else {c1.setStroke(null);c2.setStroke(null);c3.setStroke(null);c4.setStroke(null);c5.setStroke(null);c6.setStroke(null);}
            }
        });

        setOnMousePressed(e->{
            double x=e.getX(),y=e.getY();
            if(ComFunc.inCircle(x,y,c1)) clickCircle = 1;
            else if(ComFunc.inCircle(x,y,c2)) clickCircle = 2;
            else if(ComFunc.inCircle(x,y,c3)) clickCircle = 3;
            else if(ComFunc.inCircle(x,y,c4)) clickCircle = 4;
            else if(ComFunc.inCircle(x,y,c5)) clickCircle = 5;
            else if(ComFunc.inCircle(x,y,c6)) clickCircle = 6;
            else clickCircle=0;
        });

        getChildren().addAll(image,c1,c2,c3,c4,c5,c6);
    }

    public void setPicNum(int i){
        picNum = i;
        clickCircle =0;
        update();
    }

    public int getPicNum(){
        return picNum;
    }

    public int getClickCircle() {
        return clickCircle;
    }
}
