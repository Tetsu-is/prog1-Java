//R8_4
import java.util.Vector;
public class DisplayCarObject extends MyFrame2 { 
	int n = 37022497 % 5;
	int nc0=0;
	int nc1=0;
	double a = 1.1 + 0.05*n;
	int w1=20,h1=24,w2=240,h2=200;

    public void run() {
        setSize(600,500);
    	setColor(123,321,123);
    	Vector<Car> cars0=new Vector<Car>();
    	Vector<Car> cars1=new Vector<Car>();


        for (int i=0; i<150; i++) {
        	if(i%7==0) {
            	int v0 = (int) (Math.random()*10);
            	cars0.add(new Car(50+10*n,350+10*n,32,24,n+5,-v0));
            	int v1 = (int) (Math.random()*10);
            	cars1.add(new Car(450-10*n,250-10*n,32,24,-n-5,v1));
        	}

             clear();
             drawLine(300,0,300,500);
             for(int j=0;j< cars0.size();j++) {
            	 cars0.get(j).draw(this);
            	 cars0.get(j).move();
            	 if(cars0.get(j).x>=300) {
            		 cars0.get(j).stop();
            	 }
            	 cars1.get(j).draw(this);
            	 cars1.get(j).move();
            	 if(cars1.get(j).x<=300) {
            		 cars1.get(j).stop();
            	 }
             }
             sleep(0.1);
        }
    }
    public static void main(String[]args){
    	new DisplayCarObject();
    }
}

