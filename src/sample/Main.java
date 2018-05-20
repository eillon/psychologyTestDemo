package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    private String num,age,sex;
    static Writer out;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Font commFont = Font.font("System",FontWeight.BOLD,26);
        List<Integer> randList = DataList.getRandList();
        List<Integer> preList = DataList.preGetRandList();

        // main scene
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setVgap(50);
        Scene mainScene = new Scene(mainPane);
        mainPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));

        //pre scene
        GridPane prePane = new GridPane();
        prePane.setAlignment(Pos.CENTER);
        prePane.setVgap(50);
        Scene preScene = new Scene(prePane);
        prePane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));

        // begin scene
        GridPane beginPane = new GridPane();
        beginPane.getChildren().add(new ImageView("resources/begin.png"));
        beginPane.setAlignment(Pos.CENTER);
        Scene beginScene = new Scene(beginPane);
        beginPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        beginScene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.SPACE) {
                primaryStage.setScene(preScene);
            }
        });

        // wait scene
        GridPane waitPane = new GridPane();
        waitPane.getChildren().add(new ImageView("resources/wait.png"));
        waitPane.setAlignment(Pos.CENTER);
        waitPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene waitScene = new Scene(waitPane);
        waitScene.setOnMouseMoved(e->{
            try {
                Thread.sleep(750);
            }catch (Exception ex){
                System.exit(-1);
            }
            primaryStage.setScene(mainScene);
            ComFunc.setTimeStart(System.currentTimeMillis());
        });

        // input Scene
        GridPane inputPane = new GridPane();
        inputPane.setAlignment(Pos.CENTER);
        inputPane.setHgap(10);
        inputPane.setVgap(10);
        inputPane.add(new Label("编号:"),0,0);
        TextField numField = new TextField();
        inputPane.add(numField,1,0);
        inputPane.add(new Label("性别:"),0,1);
        TextField sexField = new TextField();
        inputPane.add(sexField,1,1);
        inputPane.add(new Label("年龄:"),0,2);
        TextField ageField = new TextField();
        inputPane.add(ageField,1,2);
        Button btBegin = new Button("开始");
        GridPane.setHalignment(btBegin,HPos.RIGHT);
        inputPane.add(btBegin,1,3);
        Scene inputScene = new Scene(inputPane);
        inputScene.setFill(Color.WHITE);
        btBegin.setOnAction(e->{
            primaryStage.setScene(beginScene);
            num = numField.getText();
            age = ageField.getText();
            sex = sexField.getText();
            try {
                File outfile = new File(num+".txt");
                out = new FileWriter(outfile);
                out.write(num+" "+age+" "+sex+"\n");
            }catch (Exception ex){
                System.exit(-1);
            }
        });

        //end Scene
        ImageView endImage = new ImageView("resources/end.png");
        GridPane endPane = new GridPane();
        endPane.getChildren().add(endImage);
        endPane.setAlignment(Pos.CENTER);
        endPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene endScene = new Scene(endPane);
        endScene.setOnMouseClicked(e->{
            primaryStage.close();
        });

        // right scene
        ImageView rightImage = new ImageView("resources/right.png");
        GridPane rightPane = new GridPane();
        rightPane.getChildren().add(rightImage);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene rightScene = new Scene(rightPane);
        rightScene.setOnMouseClicked(e->{
            primaryStage.setScene(preScene);
        });

        //wrong scene
        ImageView wrongImage = new ImageView("resources/wrong.png");
        GridPane wrongPane = new GridPane();
        wrongPane.getChildren().add(wrongImage);
        wrongPane.setAlignment(Pos.CENTER);
        wrongPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene wrongScene = new Scene(wrongPane);
        wrongScene.setOnMouseClicked(e->{
            primaryStage.setScene(preScene);
        });

        //relax scene
        ImageView relaxImage = new ImageView("resources/relax.png");
        GridPane relaxPane = new GridPane();
        relaxPane.getChildren().add(relaxImage);
        relaxPane.setAlignment(Pos.CENTER);
        relaxPane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene relaxScene = new Scene(relaxPane);
        relaxScene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.Q) {
                primaryStage.setScene(mainScene);
                ComFunc.setTimeStart(System.currentTimeMillis());
            }
        });

        //pause Scene
        ImageView pauseImage = new ImageView("resources/pause.png");
        GridPane pausePane = new GridPane();
        pausePane.getChildren().add(pauseImage);
        pausePane.setAlignment(Pos.CENTER);
        pausePane.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Scene pauseScene = new Scene(pausePane);
        pauseScene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.SPACE) {
                primaryStage.setScene(mainScene);
                ComFunc.setTimeStart(System.currentTimeMillis());
            }
            else if(e.getCode()==KeyCode.P){
                DataList.preIndex=-1;
                primaryStage.setScene(preScene);

            }
        });



        PicPane prePic = new PicPane();
        prePic.setPicNum(9);
        Text precmd = new Text();
        precmd.setFont(commFont);
        int preNum = DataList.preGetNext(preList);
        precmd.setText(DataList.testCmd[preNum]);
        DataList.preSetRightAns(preNum);
        prePane.add(precmd,0,0);
        prePane.add(prePic,0,1);
        GridPane.setHalignment(precmd,HPos.CENTER);
        GridPane.setHalignment(prePic,HPos.CENTER);
        preScene.setOnMouseClicked(e->{
            if(prePic.getClickCircle()!=0){
                if(prePic.getClickCircle()==DataList.preGetRightAns()){
                    primaryStage.setScene(rightScene);
                }
                else{
                    primaryStage.setScene(wrongScene);
                }
                int t=DataList.preGetNext(preList);
                if(t==-1){
                    primaryStage.setScene(pauseScene);
                }
                precmd.setText(DataList.testCmd[t]);
                prePic.setPicNum(9);
                DataList.preSetRightAns(t);
            }
        });



        // changed main scene
        PicPane pic = new PicPane();
        Text cmd = new Text();
        cmd.setFont(commFont);
        int dataNum = DataList.getNext(randList);

        cmd.setText(DataList.textList[dataNum / 100 - 1][dataNum % 100]);
        pic.setPicNum(dataNum/100);
        DataList.setRightAns(dataNum);
        mainPane.add(cmd, 0, 0);
        GridPane.setHalignment(cmd,HPos.CENTER);
        mainPane.add(pic, 0, 1);
        GridPane.setHalignment(pic,HPos.CENTER);
        mainScene.setOnMousePressed(e -> {

            if(pic.getClickCircle()!=0){
                boolean isRight = false;
                if(pic.getClickCircle()==DataList.getRightAns()) isRight =true;
             //   System.out.println(DataList.getRightAns()+" "+pic.getClickCircle());

                ComFunc.setTimeEnd(System.currentTimeMillis());
             //   System.out.println(ComFunc.getTimeEnd() - ComFunc.getTimeStart());
                try{
                    out.write(pic.getPicNum()+" "+cmd.getText()+" "+isRight+" "+(ComFunc.getTimeEnd() - ComFunc.getTimeStart())+"\n");
                }catch (Exception ex){
                    System.exit(-1);
                }
                int t = DataList.getNext(randList);

                if(DataList.index%45==0){
                    primaryStage.setScene(relaxScene);
                }

             //   System.out.println(t);
                if(t==-1){
                    primaryStage.setScene(endScene);
                }

                cmd.setText(DataList.textList[t / 100 - 1][t % 100]);
                pic.setPicNum(t/100);
                DataList.setRightAns(t);
             //   primaryStage.setScene(waitScene);
                try {
                    Thread.sleep(750);
                }catch (Exception ex){
                    System.exit(-1);
                }
                ComFunc.setTimeStart(System.currentTimeMillis());
            }
        });

        primaryStage.setTitle("心理学测试");
        primaryStage.setMaximized(true);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setScene(inputScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        try {
            out.close();
        }catch (Exception ex){
            System.out.println("save file error!");
        }

    }
}

