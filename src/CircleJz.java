import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
public class CircleJz {
    private int radius;
    
    public CircleJz() {
        radius = 1;
    }
    
    public CircleJz(int r) {
        radius = r;
    }
    
    public void setRadius(int r) {
        radius = r;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public double getArea() {
        int raSq = radius * radius;
        double area = 3.14 * raSq;
        return area;
    }
    
    public static Pane displayCircle(CircleJz cir) {
        Pane pane = new Pane();
        Circle c = new Circle(350, 50, 75, Color.TRANSPARENT);
        Line rL = new Line(350, 50, 300, 104);
        Text r = new Text(335, 90, "Radius : " +
                cir.getRadius());
        Text a = new Text(300, 150, "Surface Area apx. : " +
                cir.getArea());
        
        c.setStroke(Color.BLACK);
        rL.setStroke(Color.BLACK);
        r.setStroke(Color.BLACK);
        a.setStroke(Color.BLACK);
        
        pane.getChildren().add(c);
        pane.getChildren().add(rL);
        pane.getChildren().add(r);
        pane.getChildren().add(a);
        return pane;
    }
}
