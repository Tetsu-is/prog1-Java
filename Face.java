public class Face {
    int x,y;
    double w,h;
    public Face(int x,int y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(MyFrame2 frame) {
        frame.fillOval(x, y, 2*w/5,2*h/3);
        frame.fillOval(x+w-2*w/5, y, 2*w/5,2*h/3);
        frame.fillRect(x, y+5*h/6, w,h/6);
    }
    
}