//R7_4
public class DisplayCarObject extends MyFrame2 { 
	int n = 37022497 % 5;
	double a = 1.1 + 0.05*n;
	int w1=20,h1=24,w2=240,h2=200;

    public void run() {
        setSize(600,500);
    	setColor(0,0,255);
        Car Car0 = new Car(50+10*n, 350+10*n,32,24,n+5,-n-5);
        Car Car1 = new Car(450-10*n, 250-10*n,32,24,-n-5, n+5);

        for (int i=0; i<150; i++) {
             clear();
             Car0.draw(this);
             Car1.draw(this);
             Car0.move();
             Car1.move();
             drawLine(300,0,300,500);
             if (Car0.x >= 300) {
            	 Car0.stop();
             }		
             if (Car1.x <= 300){
                Car1.stop();
             }
             sleep(0.1);
        }
    }
    public static void main(String[]args){
    	new DisplayCarObject();
    }
}
