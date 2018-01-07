package views;

import controllers.PIPCalcController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import processors.PIPCalcInfixProcessor;
import processors.PIPCalcPostfixProcessor;
import processors.PIPCalcPrefixProcessor;
import processors.PIPCalcProcessor;

import javafx.event.Event;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

/*Rythm Gade
PIPCalcGuiView
 */


public class PIPCalcGUIView extends javafx.application.Application implements java.util.Observer {

    //controller
    private PIPCalcController controller;

    //textfield
    private TextField textField = new TextField();

    //string to hold expression
    public String expression = new String();

    ToggleGroup vb = new ToggleGroup();

    //model
    PIPCalcInfixProcessor model;

    /**
     * Constructor
     *
     * Defaults to a Infix model
     */
    public void init(){
        this.model = new PIPCalcInfixProcessor();
        model.addObserver(this);
        this.controller = new PIPCalcController(model);
    }
    //creates calculator gui
    private FlowPane makeCalc(){
        List<String> buttons = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*",
                "//", "!", "@", "<", "<=", "!=", "^"
                , "==", ">", ">=", "_", "Enter", "Clear", "Space");

        List<String> bigButtons = Arrays.asList("To InFix", "To PreFix", "To PostFix");

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(30, 20, 30, 20));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setMinWidth(500);
        pane.setPrefWidth(500);
        pane.setMaxWidth(800);

        textField.setEditable(false);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setMinSize(336, 40);
        textField.setPadding(new Insets(5, 5, 5, 5));
        textField.setText("0");
        pane.getChildren().add(textField);

        VBox vb1 = new VBox();
        RadioButton rb1 = new RadioButton("Infix");
        rb1.setToggleGroup(vb);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Postfix");
        rb2.setToggleGroup(vb);
        RadioButton rb3 = new RadioButton("Prefix");
        rb3.setToggleGroup(vb);
        FlowPane fp = new FlowPane();
        vb1.getChildren().addAll(rb1, rb2, rb3);
        fp.getChildren().addAll(vb1);

    //event handler for button click
        EventHandler<ActionEvent> onClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Button b = (Button) event.getSource();
                expression.trim();

                if (b.getText().equals("0")) {
                    expression += "0";
                    textField.setText(expression);
                }

                else if (b.getText().equals("1")){
                    expression += "1";
                    textField.setText(expression);
                }

                else if (b.getText().equals("2")){
                    expression += "2";
                    textField.setText(expression);
                }

                else if (b.getText().equals("3")){
                    expression += "3";
                    textField.setText(expression);
                }

                else if (b.getText().equals("4")){
                    expression += "4";
                    textField.setText(expression);
                }

                else if (b.getText().equals("5")){
                    expression += "5";
                    textField.setText(expression);
                }

                else if (b.getText().equals("6")){
                    expression += "6";
                    textField.setText(expression);
                }

                else if (b.getText().equals("7")){
                    expression += "7";
                    textField.setText(expression);
                }

                else if (b.getText().equals("8")){
                    expression += "8";
                    textField.setText(expression);
                }

                else if (b.getText().equals("9")){
                    expression += "9";
                    textField.setText(expression);
                }

                else if (b.getText().equals("+")){
                    expression += "+";
                    textField.setText(expression);
                }

                else if (b.getText().equals("-")){
                    expression += "-";
                    textField.setText(expression);
                }

                else if (b.getText().equals("*")){
                    expression += "*";
                    textField.setText(expression);
                }

                else if (b.getText().equals("//")){
                    expression += "//";
                    textField.setText(expression);
                }

                else if (b.getText().equals("Clear")){
                    expression = "";
                    textField.setText(expression);
                }

                else if (b.getText().equals("Enter")){
                    controller.process(expression);

                }

                else if (b.getText().equals("Space")){
                    expression += " ";
                    textField.setText(expression);
                }

                else if (b.getText().equals("<")){
                    expression += "<";
                    textField.setText(expression);
                }

                else if (b.getText().equals("<=")){
                    expression += "<=";
                    textField.setText(expression);
                }

                else if (b.getText().equals("!=")){
                    expression += "!=";
                    textField.setText(expression);
                }

                else if (b.getText().equals("^")){
                    expression += "^";
                    textField.setText(expression);
                }

                else if (b.getText().equals("==")){
                    expression += "==";
                    textField.setText(expression);
                }

                else if (b.getText().equals(">")){
                    expression += ">=";
                    textField.setText(expression);
                }

                else if (b.getText().equals("_")){
                    expression += "_";
                    textField.setText(expression);
                }

                else if (b.getText().equals("@")){
                    expression += "@";
                    textField.setText(expression);
                }

                else if (b.getText().equals("|")){
                    expression += "|";
                    textField.setText(expression);
                }

                else if (b.getText().equals(">=")){
                    expression += ">=";
                    textField.setText(expression);
                }

                else  if (b.getText().equals("!")){
                    expression += "!";
                    textField.setText(expression);
                }

                else  if (b.getText().equals("To InFix")){
                    controller.convert(expression, "infix");
                    rb1.setSelected(true);
                }

                else  if (b.getText().equals("To PreFix")){
                    controller.convert(expression, "prefix");
                    rb3.setSelected(true);
                }


                else  if (b.getText().equals("To PostFix")){
                    controller.convert(expression, "postfix");
                    rb2.setSelected(true);
                }


            }
        };


        for (String button : buttons) {
            Button b = new Button(button);
            b.setMinSize(50, 50);
            pane.getChildren().add(b);
            b.setOnAction(onClick);
        }


        for (String button : bigButtons) {
            Button b = new Button(button);
            b.setMinSize(80, 80);
            b.setOnAction(onClick);
            pane.getChildren().add(b);
            b.setStyle("-fx-base: #b6e7c9;");
        }

        pane.getChildren().add(fp);

        return pane;
    }


    //update
    @Override
    public void update(Observable o, Object arg) {
        //this.controller.changeModel();
        //this.controller.process();
        //this.controller.convert();
        if (arg instanceof String){
            expression = (String)arg;
        }

        else
        {expression = (Integer.toString((Integer)arg));}

        textField.setText(expression);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane pane = makeCalc();
        Scene scene = new Scene(pane);
        primaryStage.setTitle("PIP Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
