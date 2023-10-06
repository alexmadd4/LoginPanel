package com.loginpanel.loginpanel;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginUI extends Application {

    private final int WIDTH = 1080;
    private final int HEIGHT = 720;
   private String emailadd;
   private int password;
    private TextField textField1;
   private Stage secondStage;
   private Pane pane3;
   private Pane pane4;

    @Override
    public void start(Stage stage){

        Pane WindowPane = new Pane();

        //decoration
        Rectangle decor1 = new Rectangle(1080,100);
        decor1.setFill(Color.LIGHTCYAN);
        Label label = new Label("Login Panel");
        label.setFont(Font.font("Impact", 40));
        label.setLayoutX(450);
        label.setLayoutY(15);

        WindowPane.getChildren().add(decor1);
        WindowPane.getChildren().add(label);

        Pane loginUI = new Pane();
        Rectangle loginBox = new Rectangle(400,400);
        loginBox.setFill(Color.WHITE);
        loginBox.setStyle("-fx-stroke-width: 5px; -fx-stroke: lightcyan;");
        loginBox.setX(350);
        loginBox.setY(130);

        Label email = new Label("Email Address");
        email.setFont(Font.font("Arial",15));
        email.setLayoutX(360);
        email.setLayoutY(150);

        TextField textField1 = new TextField();
        textField1.setPrefHeight(20);
        textField1.setPrefWidth(300);
        textField1.setLayoutX(360);
        textField1.setLayoutY(170);
        textField1.setFont(Font.font("Arial",15));

        Label password = new Label("Password");
        password.setFont(Font.font("Arial",15));
        password.setLayoutX(360);
        password.setLayoutY(200);

        TextField textField2 = new TextField();
        textField2.setPrefHeight(20);
        textField2.setPrefWidth(300);
        textField2.setLayoutX(360);
        textField2.setLayoutY(220);
        textField2.setFont(Font.font("Arial",15));

        Button button = new Button("Login");
        button.setFont(Font.font("Arial",20));
        button.setOnAction(event ->
         submit(textField1,textField2));

        loginUI.getChildren().add(loginBox);

        VBox vBox = new VBox(12);
        vBox.getChildren().add(email);
        vBox.getChildren().add(textField1);
        vBox.getChildren().add(password);
        vBox.getChildren().add(textField2);
        vBox.getChildren().add(button);
        vBox.setLayoutX(400);
        vBox.setLayoutY(200);
        vBox.setAlignment(Pos.CENTER);

        this.pane3=WrongEmail();
        pane3.setLayoutX(485);
        pane3.setLayoutY(400);
        pane3.setVisible(false);

        this.pane4=WrongPassword();
        pane4.setLayoutX(485);
        pane4.setLayoutY(400);
        pane4.setVisible(false);

        Group group = new Group();
        group.getChildren().addAll(WindowPane,loginUI,vBox,pane3,pane4);

        Scene scene = new Scene(group,WIDTH,HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        this.secondStage=stage;
    }
        public static void main(String[] args) {
        launch();
    }
    private void submit(TextField textField1,TextField textField2){
            String text = textField1.getText();
            String text2 = textField2.getText();

            emailadd = "alex@mail.com"; //Change the email.
            password = 2023; //Change this password. :/
            if(text.equals(emailadd) && Integer.parseInt(text2) == password){
                System.out.println("Successfully logged in.\n");
                System.out.println("Email: "+ text + "\n");
                System.out.println("Password: "+ text2 + "\n");
                Scene2();

            }else if (!text.equals(emailadd) && Integer.parseInt(text2) == password){

                System.out.println("Email is wrong");
                EmailIsWrong();
                WrongEmail();
                pane3.setVisible(true);
                pane4.setVisible(false);

            } else if  (text.equals(emailadd) && Integer.parseInt(text2) != password) {
                System.out.println("Password is Wrong.");
                WrongPassword();
                pane4.setVisible(true);
                pane3.setVisible(false);

            } else{
                System.out.println("Email and Password are wrong.");
            }
    }
    private Scene Scene2(){

        Label label2 = new Label("Successfully logged in!");
        label2.setFont(Font.font("Arial",40));
        label2.setVisible(true);

        HBox hBox = new HBox();
        hBox.getChildren().add(label2);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        Pane pane2 = new Pane();
        pane2.getChildren().add(hBox);

        Scene scene2 = new Scene(pane2,WIDTH,HEIGHT);
        secondStage.setScene(scene2);
        secondStage.show();
        return scene2;
    }
    private Pane WrongEmail(){

        Label wrongEmail =new Label("Email is wrong!");
        wrongEmail.setStyle("-fx-font-family: 'Courier New';  -fx-background-color: transparent; -fx-text-fill: red; -fx-font-size: 15px;");
        Pane pane3 = new Pane();
        pane3.getChildren().add(wrongEmail);
        return pane3;
    }
    private Pane WrongPassword(){

        Label wrongPassword =new Label("Password is wrong!");
        wrongPassword.setStyle("-fx-font-family: 'Courier New';  -fx-background-color: transparent; -fx-text-fill: red; -fx-font-size: 15px;");
        Pane pane4 = new Pane();
        pane4.getChildren().add(wrongPassword);
        return pane4;
    }

    private TextField EmailIsWrong(){
        TextField tx1 = new TextField();
        this.textField1=tx1;
        tx1.setStyle("-fx-border-color: #ff0000");
        return tx1;
    }
}