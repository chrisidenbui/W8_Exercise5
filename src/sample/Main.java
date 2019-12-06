package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.awt.event.ActionEvent;

class CirclePane extends StackPane{
    private Circle  cir = new Circle(20);

    public CirclePane(){
        getChildren().add(cir);
        cir.setStroke(Color.BLACK);
        cir.setFill(Color.WHITE);
    }
    public void moveUp(){
        if(cir.getTranslateY() > -105) {
            cir.setTranslateY(cir.getTranslateY() - 5);
        }
    }
    public void moveDown(){
        if(cir.getTranslateY() < 105) {
            cir.setTranslateY(cir.getTranslateY() + 5);
        }
    }
    public void moveRight(){
        if(cir.getTranslateX() < 130) {
            cir.setTranslateX(cir.getTranslateX() + 5);
        }
    }
    public void moveLeft(){
        if(cir.getTranslateX() > -130) {
            cir.setTranslateX(cir.getTranslateX() - 5);
        }
    }
}
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        CirclePane circlePane = new CirclePane();
        Circle cir1 = new Circle(30);
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");

        hBox.getChildren().add(btUp);
        hBox.getChildren().add(btDown);
        hBox.getChildren().add(btLeft);
        hBox.getChildren().add(btRight);

        btDown.setOnAction((ActionEvent) -> {
            circlePane.moveDown();
        });

        btUp.setOnAction((ActionEvent) -> {
            circlePane.moveUp();
        });

        btLeft.setOnAction((ActionEvent) -> {
            circlePane.moveLeft();
        });

        btRight.setOnAction((ActionEvent) -> {
            circlePane.moveRight();
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);

        primaryStage.setTitle("Exercise_5");
        primaryStage.setScene(new Scene(borderPane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
