//R8_2
public class DisplayFaceObject extends MyFrame2 { 
	int n = 37022497 % 5;
    public void run() { 
        Face[] faces=new Face[10];
        for(int j=0;j<10;j++){
            faces[j] = new Face(20,80+24*j,j%3+5,10,12);
        }

        for(int i=0;i<150;i++){
            clear();
            for(int j=0;j<10;j++){
                if(faces[j].x>=400){
                    faces[j].moveOrigin();
                }
                faces[j].draw(this);
                faces[j].move();
            }
            sleep(0.1);
            }
        }
    public static void main(String[]args){
    	new DisplayFaceObject();
    }
}