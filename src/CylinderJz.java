import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class CylinderJz {
    private CircleJz base;
    private int height;
    
    public CylinderJz() {
        base = new CircleJz();
        height = 1;
    }
    
    public CylinderJz(CircleJz c, int h) {
        base = c;
        height = h;
    }
    
    public void setBase(CircleJz c) {
        base = c;
    }
    
    public void setHeight(int h) {
        height = h;
    }
    
    public int getBaseRad() {
        return base.getRadius();
    }
    
    public int getHeight() {
        return height;
    }
    
    public double getCylArea() {
        double radSq = base.getRadius() * base.getRadius();
        double pi = 3.14;
        double h = height;
        double two = 2;
        double pt1 = two * pi * base.getRadius() * h;
        double pt2 = two * pi * radSq;
        return pt1 + pt2;
    }
    public static Pane displayCylinder(CylinderJz cyl) {
        Ellipse e1 = new Ellipse(350, 100, 75, 35);
        Ellipse e2 = new Ellipse(350, 10, 75, 35);
        Line l1 = new Line(275, 100, 275, 10);
        Line l2 = new Line(425, 100, 425, 10);
        Line rL = new Line(350, 100, 300, 126);
        Text h = new Text(230, 70, "Height : " + 
                cyl.getHeight());
        Text r = new Text(335, 120, "Radius : " +
                cyl.base.getRadius());
        Text a = new Text(300, 160, "Surface Area apx. : " +
                cyl.getCylArea());
        Pane pane = new Pane();
        
        h.setRotate(-90);
        h.setStroke(Color.BLACK);
        r.setStroke(Color.BLACK);
        a.setStroke(Color.BLACK);
        l1.setStroke(Color.BLACK);
        l1.setStrokeWidth(1);
        l2.setStroke(Color.BLACK);
        l2.setStrokeWidth(1);
        rL.setStroke(Color.BLACK);
        rL.setStrokeWidth(1);
        e1.setStroke(Color.BLACK);
        e1.setFill(Color.TRANSPARENT);
        e2.setStroke(Color.BLACK);
        e2.setFill(Color.TRANSPARENT);
        pane.getChildren().add(e1);
        pane.getChildren().add(e2);
        pane.getChildren().add(l1);
        pane.getChildren().add(l2);
        pane.getChildren().add(h);
        pane.getChildren().add(rL);
        pane.getChildren().add(r);
        pane.getChildren().add(a);
        return pane;
    }
    
    
}
