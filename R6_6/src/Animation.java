//R6_6
public class Animation extends MyFrame2 {
    public static void main(String[] args) {
        new Animation();
    }

    /** 中心座標 (cx, cy) および半径 r の円を描画(色を整数 c = 0, 1, 他で指定)*/
    public void fillCircleWithCC(double cx, double cy, int r, int c) {
    	if(c==0){
            setColor(255,0,0);
        }else if(c==1){
            setColor(0,255,0);
        }else{
            setColor(0,0,255);
        }

        fillOval(cx-r,cy-r,2*r,2*r);
    }



    public void run() {

        int r = 5;     // 移動する円の半径
        int c = 0;     // 移動する円の色(0 → 赤, 1 → 黄緑, 他 → 青)  

        int ne = 0;
        int n = 370224977 % 5;
        int ox = 200;
        int oy = 200;
        double x = 0;
        double y = 0; 
        int A = 10 * n + 100;
        int T = 50;

        int animeT = 500;   // アニメーションの総コマ数
        double wtime = 0.04; // sleep に与える待機時間(コマの切り替えの間隔)
       
        for (int t = 0; t <= animeT; t++) {
            clear();   
            
            for(int i=0; i<ne; i++) {
            	x = A * Math.sin(Math.PI / T * (t-i)) + ox;
                y = A * Math.sin(2 * Math.PI / T * (t-i)) + oy;
                fillCircleWithCC(x, y, r, c);
            }
            
            if(t % (T-1)==0) {
            	ne++;
            	if(c == 0) {
            		c = 1;
            	}
            	else if(c==1) {
            		c = 2;
            	}
            	else {
            		c = 0;
            	}
            		
            	
            }
            
            sleep(wtime);
            
        }
    }
}
