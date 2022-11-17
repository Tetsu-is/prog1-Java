//R7_3
public class DisplayFaceObject extends MyFrame2 { 
	int n = 37022497 % 5;
	double a = 1.1 + 0.05*n;
	int w1=20,h1=24,w2=240,h2=200;
    public void run() { 
    	setColor(0,0,255);
        Face face1 = new Face(50,50,w1,h1);
        Face face2 = new Face(200,100,w2,h2);

        for (int i=0; i<150; i++) {
             clear();
             face1.draw(this);
             face2.draw(this);
             face1.w = face1.w * a;
             face1.h = face1.h * a;
             if (face1.w>=w1*10||face1.w<w1) {
            	 a = 1/a;
             }
             face2.w = face2.w/a;
             face2.h = face2.h/a;
             
             sleep(0.1);
        }
    }
    public static void main(String[]args){
    	new DisplayFaceObject();
    }
}