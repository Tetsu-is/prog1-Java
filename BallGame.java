public class BallGame extends MyFrame2 {
    public static void main(String[] args) {
        new BallGame();
    }

    /** 中心座標 (cx, cy) および半径 r の円を描画(色を整数 c = 0, 1, 他で指定)*/
    public void fillCircleWithCC(int cx, int cy, int r, int c) {
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
        int w = 300;
        int h = 230;

        int n = 7;
        //学籍番号の下一桁
        int x0 = 50;   // 左端の x 座標(移動する円の中心 x 座標の最小値)
        int x1 = x0 + w;  // 右端の x 座標(移動する円の中心 x 座標の最大値)
        int y0 = 100;   // 上端の y 座標(移動する円の中心 x 座標の最小値)
        int y1 = y0 + h;  // 下端端の y 座標(移動する円の中心 y 座標の最大値)
        int x = 50 + r + 5*n;    // 移動する円の中心 x 座標
        int y = 100 + r + 5*n;   // 移動する円の中心 y 座標

        int dx = 5;    // 単位時間あたりの x 座標の変化量

        int dy = 5;    // 単位時間あたりの y 座標の変化量

        int animeT = 300;   // アニメーションの総コマ数
        double wtime = 0.1; // sleep に与える待機時間(コマの切り替えの間隔)

        for (int t = 0; t <= animeT; t++) {
            clear();   

            setColor(225,225,225);
            fillRect(x0, y0, w, h); // 円が移動する範囲を示す四角形を描画

            fillCircleWithCC(x, y, r, c);  // 中心座標(x, y) および半径 r の円を描画(色の設定が変わるので注意)
            
            x += dx;  // x 座標の変化
            y += dy;  // y 座標の変化

            if(y == y0 + h - r) {
            	dy = -5;
            	c = 1;
            }
            
            if(x == x0 + w -r) {
            	dx = -5;
            	c = 2;
            }
            
            if(y == y0 + r) {
            	dy = 5;
            	c = 0;
            }
            
            if(x == x0 + r) {
            	dx = 5;
            	c = 1;
            }
            sleep(wtime);
        }
    }
}