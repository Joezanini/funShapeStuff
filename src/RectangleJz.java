import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class RectangleJz {
    private int width;
    private int length;
    
    public RectangleJz() {
        width = 1;
        length = 1;
    }
    
    public RectangleJz(int w, int h) {
        width = w;
        length = h;
    }
    
    public void setWidth(int w) {
        width = w;
    }
    
    public void setLength(int l) {
        length = l;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getRecArea() {
        return width * length;
    }
    
    public static Pane displayRectangle(RectangleJz rec) {
        Pane pane = new Pane();
        Rectangle r = new Rectangle(150, 275, Color.TRANSPARENT);
        Text w = new Text(250, 320, "Width : " +
                rec.width);
        Text l = new Text(190, 200, "Length : " +
                rec.length);
        Text a = new Text(240, 20, "Surface Area : " +
                rec.getRecArea());
        
        r.setStroke(Color.BLACK);
        r.setX(230);
        r.setY(30);
        
        w.setStroke(Color.BLACK);
        l.setStroke(Color.BLACK);
        l.setRotate(-90);
        a.setStroke(Color.BLACK);
       
        pane.getChildren().add(r);
        pane.getChildren().add(w);
        pane.getChildren().add(l);
        pane.getChildren().add(a);
        return pane;
    }
}
