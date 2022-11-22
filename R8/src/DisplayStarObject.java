import java.awt.Color;
import java.util.Vector;
public class DisplayStarObject extends MyFrame2{
	public void run() {
		bgColor = Color.black;
		int ww = 400, wh = 400;     // ウィンドウの幅と高さ
		int n = 37022497%5;

        int size = 10;
        int animeT = 200;
        double wtime = 0.1;
		setSize(ww,wh);
		setColor(255,255,0);
        
        Vector<Star> stars = new Vector<Star>();
        
		for(int t=0;t<animeT;t++) {
			clear();
				if(t%5==0) {
			        int x = 30+10*n, y = 50;
			        int vx = (int)(Math.random()*10);
					int vy = (int)(Math.random()*10);
					stars.add(new Star(x, y, vx, vy, size));
				}
				for(int j=0;j<stars.size();j++){
					stars.get(j).draw(this);
					stars.get(j).move();
				}
				sleep(wtime);
			

				
			}
		
	}
	public static void main(String[]args) {
		new DisplayStarObject();
	}

}

