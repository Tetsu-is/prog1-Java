
public class RectIf extends MyFrame2{
	public void run() {
		int i,x=50;
		setColor(0,0,255);
		for(i=0;i<10;i++)
		{
			if(i%2==0) 
			{
				fillRect(x,100,10,100);
			}
			else 
			{
				fillRect(x,80,10,100);
			
			}
		x += 20;
		}
		
		
	}
	public static void main(String[]args) {
		MyFrame2 frame1 = new RectIf();
	}

}
