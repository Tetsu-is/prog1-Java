public class Animation extends MyFrame2 {
	public static void main(String[] args) {
		new Animation();
    }
	public void fillCircleWithCC(int cx, int cy, int r, int c) {
        if (c==0) {
        	setColor(255,0,0);
        	fillOval(cx-r,cy-r,r*2,r*2);
        } else if (c==1) {
        	setColor(0,255,0);
        	fillOval(cx-r,cy-r,r*2,r*2);
        } else {
        	setColor(0,0,255);
        	fillOval(cx-r,cy-r,r*2,r*2);
        }
    }
    public void run() {
    	int n = 7;
    	int w = 300;
    	int h = 230;
        int r = 5;     // 移動する円の半径
        int c = 0;     // 移動する円の色(0 → 赤, 1 → 黄緑, 他 → 青)  

        int x0 = 50;   // 左端の x 座標(移動する円の中心 x 座標の最小値)
        int y0 = 100;   // 左端の y 座標(移動する円の中心 y 座標の最小値)
        int x1 = 350;  // 右端の x 座標(移動する円の中心 x 座標の最大値)
        int y1 = 330; // 右端の y 座標(移動する円の中心 y 座標の最大値)
        int x2 = 105;   // 左端の x 座標(移動する円の中心 x 座標の最小値)
        int y2 = 170;   // 左端の y 座標(移動する円の中心 y 座標の最小値)
        int x3 = 195;  // 右端の x 座標(移動する円の中心 x 座標の最大値)
        int y3 = 260;
        
        int x = 50+r+5*n;    // 移動する円の中心 x 座標
        int y = 100+r+5*n;   // 移動する円の中心 y 座標

        int dx = 5;    // 単位時間あたりの x 座標の変化量
        int dy = 5;		// 単位時間あたりの y 座標の変化量
        
        int point = 6;
        int animeT = 400;   // アニメーションの総コマ数
        double wtime = 0.05; // sleep に与える待機時間(コマの切り替えの間隔)

        for (int t = 0; t <= animeT; t++) {
        	clear();   
            setColor(225,225,225);
            fillRect(50, 100, w, h); // 外側の四角形を描画
            setColor(50,128,128);
            fillRect(w/2-45, 100+h/2-45, 90, 90);
            fillCircleWithCC(x, y, r, c);  // 中心座標(x, y) および半径 r の円を描画(色の設定が変わるので注意)
            setColor(0,0,0);
            drawString(Integer.toString(point),130,235,60);
            if (y == y1 - r || y == y0 + r) { 
         	   c=2;
         	   dy = -dy;
            }
            if (x == x1 - r || x == x0 + r) { 
          	   c=1;
          	   dx = -dx;
             }
            if ((x >= x2 - r && x <= x3 + r && y == y2 - r) || (x >= x2 - r && x <= x3 + r && y == y3 + r) ) { 
           	   c=0;
           	   dy = -dy;
           	   point -= 1;
              }
            if ((x == x2 - r && y >= y2  -r && y <= y3 + r) || (x == x3 + r && y >= y2 - r && y <= y3 + r)) { 
            	   c=0;
            	   dx = -dx;
            	   point -= 1;
               }
            if (point <= 0) {
            	break;
            }
           
           x += dx;
           y += dy;
            sleep(wtime);
        }
    }
}


