//R8_5
import java.awt.Color;
import java.util.Vector;
public class DisplayTriangleObject extends MyFrame2{
	public void run() {
		bgColor = Color.black;
		int ww = 400, wh = 400;     // ウィンドウの幅と高さ
		int n = 37022497%5;

        int size = 10;
        int animeT = 200;
        double wtime = 0.1;
		setSize(ww,wh);
		setColor(255,255,0);
        
        Vector<Triangle> triangles = new Vector<Triangle>();
        
		for(int t=0;t<animeT;t++) {
			clear();
			if(t%5==0) {
		        int x = 30+10*n, y = 50;
		        int vx = (int)(Math.random()*10);
				int vy = (int)(Math.random()*10);
				triangles.add(new Triangle(x, y, vx, vy, size));
			}
			
			for(int j=0;j<triangles.size();j++){
				triangles.get(j).draw(this);
				triangles.get(j).move();
			}

				
				sleep(wtime);
			

				
			}
		
	}
	public static void main(String[]args) {
		new DisplayTriangleObject();
	}

}
