
    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import javafx.scene.layout.BorderPane;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.GridPane;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.paint.Color;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.shape.Line;
    import javafx.scene.shape.Circle;
    import javafx.scene.text.Text;
    import javafx.scene.layout.Pane;
    import javafx.geometry.Point2D;
    
public class funnyShapeApplication extends Application {
    private CircleJz circle;
    private Circle c1;
    private Circle c2;
    private Line dLine;
    private RectangleJz rectangle;
    private CylinderJz cylinder;
    private BoxJz nBox;
    private Point2D show;
    private Point2D howFar; 
    private Text d;
    private Text instructions;
    private double x1;
    private TextField width = new TextField();
    private TextField bWidth = new TextField();
    private TextField length = new TextField();
    private TextField bLength = new TextField();
    private TextField rad = new TextField();
    private TextField cRad = new TextField();
    private TextField height = new TextField();
    private TextField bHeight = new TextField();
    private TextField cHeight = new TextField();
    private Button buildR = new Button("Build Shape");
    private Button buildCi = new Button("Build Shape");
    private Button buildCy = new Button("Build Shape");
    private Button buildBox = new Button("Build Shape");
    private Button calculate = new Button("Calculate Distance");
    private Label posInt = new Label("    Values must be " +
            "\n    POSITIVE Integers");
             
    @Override
    public void start(Stage primaryStage) {
                
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        
        Button rec = new Button("Rectangle");
        Button cir = new Button("Circle");
        Button cyl = new Button("Cylinder");
        Button box = new Button("Box");
        Button game = new Button("Distance Game");
        
        instructions = new Text(50, 50, "CLICK A BUTTON...");
        posInt.setTextFill(Color.web("#ff0000"));
        
        hBox.getChildren().addAll(rec, cir, cyl, box, game);
        pane.setTop(hBox);
        pane.setCenter(instructions);
        
        game.setOnAction(e -> {  
            pane.setBottom(null);
            pane.setCenter(distanceGame());
        });
        
        box.setOnAction(e -> {
            pane.setBottom(null);
            pane.setCenter(createBox());
        });
        
        cyl.setOnAction(e -> {
            pane.setBottom(null);
            pane.setCenter(createCyl());
        });
        
        cir.setOnAction(e -> {
            pane.setBottom(null);
            pane.setCenter(createCircle());
        });
        
        rec.setOnAction(e -> { 
            pane.setBottom(null);
            pane.setCenter(createRectangle());
        });
        
        calculate.setOnAction(e -> { 
            pane.setBottom(null);
            show = new Point2D(c1.getCenterX(), c1.getCenterY());
            howFar = new Point2D(c2.getCenterX(), c2.getCenterY());
            x1 = show.distance(howFar);
            d = new Text(230, 20, "     Distance between the 2 " +
                    "Circles is apx : " + x1);
            d.setStroke(Color.PURPLE);
            pane.setBottom(d);
        });
        
        buildBox.setOnAction(e -> {
            if (isInteger(bLength.getText()) &&
                    isInteger(bWidth.getText()) &&
                    isInteger(bHeight.getText())) {
                if (Integer.parseInt(bWidth.getText()) > 0 &&
                        Integer.parseInt(bLength.getText()) > 0 &&
                        Integer.parseInt(bHeight.getText()) > 0) {
                    nBox = new BoxJz(new RectangleJz(
                        Integer.parseInt(bWidth.getText()),
                        Integer.parseInt(bLength.getText())),
                        Integer.parseInt(bHeight.getText()));
                    pane.setBottom(BoxJz.displayBox(nBox));
                } else {
                    pane.setBottom(posInt);
                }
            } else {
                pane.setBottom(posInt);
            }
        });
        
        buildCy.setOnAction(e -> { 
            if (isInteger(cRad.getText()) && 
                    isInteger(cHeight.getText())) {
                if (Integer.parseInt(cRad.getText()) > 0 &&
                        Integer.parseInt(cHeight.getText()) > 0) {
                    cylinder = 
                            new CylinderJz(new CircleJz(
                                Integer.parseInt(cRad.getText())),
                            Integer.parseInt(cHeight.getText()));
                    pane.setBottom(
                            CylinderJz.displayCylinder(cylinder));
                } else {
                    pane.setBottom(posInt);
                }
            } else {
                pane.setBottom(posInt);
            }
        });
        
        buildCi.setOnAction(e -> { 
            if (isInteger(rad.getText())) {
                if (Integer.parseInt(rad.getText()) > 0) {
                    circle = new CircleJz(
                        Integer.parseInt(rad.getText()));
                    pane.setBottom(CircleJz.displayCircle(circle));
                } else {
                    pane.setBottom(posInt);
                }
            } else {
                pane.setBottom(posInt);
            }
        });
        
        
        buildR.setOnAction(e -> { 
            if(isInteger(width.getText()) &&
                    isInteger(length.getText())) {
                if (Integer.parseInt(width.getText()) > 0 &&
                        Integer.parseInt(length.getText()) > 0) {
                    rectangle = new RectangleJz(
                            Integer.parseInt(width.getText()),
                            Integer.parseInt(length.getText()));
                    pane.setBottom(
                            RectangleJz.displayRectangle(rectangle));
                } else {
                    pane.setBottom(posInt);
                }
            } else {
                pane.setBottom(posInt);
            }
        });
        
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Funny Shape Stuff");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Pane distanceGame() {
        BorderPane pane = new BorderPane();
        c1 = new Circle(200, 150, 10, Color.TRANSPARENT);
        c2 = new Circle(300, 150, 10, Color.TRANSPARENT);
        Text message = new Text(175, 20, "Click & Drag " +
                "Circle to \n Create Desired Distance");
        dLine = new Line(c1.getCenterX(), c1.getCenterY(), 
                c2.getCenterX(), c2.getCenterY());
        dLine.startXProperty().bind(c1.centerXProperty());
        dLine.startYProperty().bind(c1.centerYProperty());
        dLine.endXProperty().bind(c2.centerXProperty());
        dLine.endYProperty().bind(c2.centerYProperty());
        c1.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        message.setStroke(Color.BLUE);
        
        
        c1.setOnMouseDragged(e -> { 
            c1.setCenterX(e.getX());
            c1.setCenterY(e.getY());
        });
        
        c2.setOnMouseDragged(e -> { 
            c2.setCenterX(e.getX());
            c2.setCenterY(e.getY());
        });
        
        
        
        pane.setCenter(calculate);
        pane.getChildren().add(message);
        pane.getChildren().add(c1);
        pane.getChildren().add(c2);
        pane.getChildren().add(dLine);
        return pane;
    }
    
    public GridPane createBox() {
        GridPane pane = new GridPane();
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("    Create a Box"), 0, 0);
        pane.add(new Label("    Create a Rectangle for Base"), 
                0, 1);
        pane.add(new Label("    Enter a width: "), 0, 2);
        pane.add(bWidth, 1, 2);
        pane.add(new Label("    Enter a length: "), 0, 3);
        pane.add(bLength, 1, 3);
        pane.add(new Label("    Enter a Height: "), 0, 4);
        pane.add(bHeight, 1, 4);
        pane.add(buildBox, 1, 5);
        return pane;
    }
    
    public GridPane createCyl() {
        GridPane pane = new GridPane();
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("    Create a Cylinder"), 0, 0);
        pane.add(new Label("    Create a Circle for Base"), 
                0, 1);
        pane.add(new Label("    Enter a Radius: "), 0, 2);
        pane.add(cRad, 1, 2);
        pane.add(new Label("    Enter a Height: "), 0, 3);
        pane.add(cHeight, 1, 3);
        pane.add(buildCy, 1, 4);
        return pane;
    }
    
    public GridPane createCircle() {
        GridPane pane = new GridPane();
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("    Create a Circle"), 0, 0);
        pane.add(new Label("    Enter a Radius: "), 0, 1);
        pane.add(rad, 1, 1);
        pane.add(buildCi, 1, 2);
        
        return pane;
    }
    
    public GridPane createRectangle() {
        GridPane pane = new GridPane();
        
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("    Create a Rectangle"), 0, 0);
        pane.add(new Label("    Enter Width: "), 0, 1);
        pane.add(width, 1, 1);
        pane.add(new Label("    Enter Length: "), 0 , 2);
        pane.add(length, 1, 2);
        pane.add(buildR, 2, 2);
        
        return pane;
    }
    
    
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

/**COMMENTS
  DRIVER CLASS COULD HAVE DEFINITELY BEEN ARANGED BETTER. 
  
  USING SO MANY DATA MEMBERS MIGHT HAVE BEEN CHEATING
  
  CODE COULD BE MORE EFFICIENT
 */


