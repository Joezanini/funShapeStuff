import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
public class BoxJz {
    private RectangleJz base;
    private int height;
    
    public BoxJz() {
        base = new RectangleJz();
        height = 1;
    }
    
    public BoxJz(RectangleJz r, int h) {
        base = r;
        height = h;
    }
    
    public void setBase(RectangleJz r) {
        base = r;
    }
    
    public RectangleJz getBase() {
        return base;
    }
    
    public void setHeight(int h) {
        height = h;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getBoxArea() {
        int pt1 = 2 * base.getLength() * height;
        int pt2 = 2 * height * base.getWidth();
        int pt3 = 2 * base.getLength() * base.getWidth();
        return pt1 + pt2 + pt3;
    }
    
    public static Pane displayBox(BoxJz box) {
        Pane pane = new Pane();
        Line l1 = new Line(275, 90, 125, 20);
        Line l2 = new Line(375, 70, 225, 0);
        Line l3 = new Line(275, 190, 125, 120);
        Line l4 = new Line(375, 170, 225, 100);
        Line w1 = new Line(275, 90, 375, 70);
        Line w2 = new Line(225, 0, 125, 20);
        Line w3 = new Line(275, 190, 375, 170);
        Line w4 = new Line(125, 120, 225, 100);
        Line h1 = new Line(275, 90, 275, 190);
        Line h2 = new Line(375, 70, 375, 170);
        Line h3 = new Line(125, 20, 125, 120);
        Line h4 = new Line(225, 100, 225, 0);
        Text h = new Text(80, 80, "Height : " +
                box.height);
        Text l = new Text(125, 155, "Length : " +
                box.base.getLength());
        Text w = new Text(155, 125, "Width : " +
                box.base.getWidth());
        Text a = new Text(190, 230, "Surface Area : " +
                box.getBoxArea());
        
        h.setRotate(-90);
        l.setRotate(27);
        w.setRotate(-12);
        
        h.setStroke(Color.BLACK);
        l.setStroke(Color.BLACK);
        w.setStroke(Color.BLACK);
        a.setStroke(Color.BLACK);
        
        pane.getChildren().add(l1);
        pane.getChildren().add(l2);
        pane.getChildren().add(l3);
        pane.getChildren().add(l4);
        pane.getChildren().add(w1);
        pane.getChildren().add(w2);
        pane.getChildren().add(w3);
        pane.getChildren().add(w4);
        pane.getChildren().add(h1);
        pane.getChildren().add(h2);
        pane.getChildren().add(h3);
        pane.getChildren().add(h4);
        pane.getChildren().add(h);
        pane.getChildren().add(l);
        pane.getChildren().add(w);
        pane.getChildren().add(a);
        return pane;
    }
}
