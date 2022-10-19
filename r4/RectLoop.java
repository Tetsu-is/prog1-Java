
public class RectLoop extends MyFrame2{
	public void run() {
		
		int y=50;
		for(int i=0;i<10;i++) {
			
			int x = 30;
			for(int j = 0; j < 10; j++) {
				setColor(0,0,100+15*i+15*j);
				fillRect(x,y,10,10);
				x += 20;
			}
			y += 20;
		}
	}
	
	public static void main(String[]args) {
		MyFrame2 frame1 = new RectLoop();
	}

}