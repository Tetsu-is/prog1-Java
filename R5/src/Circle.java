
public class Circle extends MyFrame2 {

    public void fillOvalWithBorder(int x, int y, int r, int w) {
        // TODO: 枠線がある円(塗りつぶし有り)を描画
    	int R;
    	R = 2*r;
    	setColor(0,0,0);
		fillOval(x,y,R,R);
		
		setColor(255,255,255);
		fillOval(x+w,y+w,R-2*w,R-2*w);
    		
    	}

    public void run() {
       // TODO: fillOvalWithBorder メソッドを呼び出す
    	int r = 20, n = 37022497 % 5 + 3;
    	for(int i = 0; i < n; i ++) {
    		int w = i + 1;
    		fillOvalWithBorder(45*i+20,80,r,w);	
    	}
    	
    }

    public static void main(String[] args) {
        new Circle();
    }

}