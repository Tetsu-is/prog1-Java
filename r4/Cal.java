
public class Cal extends MyFrame2{
	public void run() {
		drawString("2003年　11月",80,70,20);
		int x=90,y = 100,a = 30, b = 30;
		for(int i=0;i<30;i++) {
			if(i%17==0 && i!=0) {
				setColor(0,255,0);
				x += a;
			}
			else if(i%7==6) {
				setColor(255,0,0);
				x -= a*6;
				y += b;
			}
			else if(i%7==5) {
				setColor(0,0,255);
				x += a;
			}
			else {
				setColor(0,0,0);
				x += a;
			}
			drawString(""+ i,x,y,20);
		}

	}
	public static void main(String[]args) {
		MyFrame2 frame1 = new Cal();
		frame1.setSize(500,500);
	}
}
