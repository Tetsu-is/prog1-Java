import java.awt.Color;  // bgColor = Color.black の実行に必要

public class Star {

    int x, y;      // 三角形の中心座標
    int nPoints ;  // 三角形の頂点数
    double[] xPoints; // 三角形の頂点 x 座標を格納する配列
    double[] yPoints; // 三角形の頂点 y 座標を格納する配列
    int vx, vy;    // 三角形の中心座標の変化量
    int size;      // 三角形の大きさ

    /** コンストラクタ */
    public Star(int x, int y, int vx, int vy, int size) {

        this.x = x;
        this.y = y;
        
        this.nPoints = nPoints;
        this.xPoints = xPoints;
        this.yPoints = yPoints;

        this.vx = vx;
        this.vy = vy;

        this.size = size;

        nPoints = 5;     // 三角形なので頂点数に 3 を代入している

        xPoints = new double[nPoints]; // double 型の配列(要素数 nPoints)を作成
        yPoints = new double[nPoints]; // double 型の配列(要素数 nPoints)を作成

        setPoints();  // 頂点の座標を更新
    }

    /** 中心座標(x, y) を持つ三角形の頂点座標を設定する */
    public void setPoints() {

        // 頂点 0 の座標
        xPoints[0] = x;
        yPoints[0] = y - size;

        // 頂点 1 の座標
        xPoints[1] = x + (int)(Math.sin(Math.toRadians(72))*size);
        yPoints[1] = y - (int)(Math.cos(Math.toRadians(72))*size);
        
        xPoints[2] = x + (int)(Math.sin(Math.toRadians(144))*size);
        yPoints[2] = y - (int)(Math.cos(Math.toRadians(144))*size);
        
        xPoints[3] = x - (int)(Math.sin(Math.toRadians(144))*size);
        yPoints[3] = y - (int)(Math.cos(Math.toRadians(144))*size);
        
        xPoints[4] = x - (int)(Math.sin(Math.toRadians(72))*size);
        yPoints[4] = y - (int)(Math.cos(Math.toRadians(72))*size);
        
        

    }

    /** 頂点座標の配列 xPoints および yPoints を用いて三角形を描画 */
    public void draw(MyFrame2 frame) {

        // TODO: (その 1.1) 以下の手順で線を引く for 文を書く
        //   頂点 0 から頂点 1 に drawLine で線を引く
        //   頂点 1 から頂点 2 に drawLine で線を引く
        //      :
        //   頂点 nPoints-2 から頂点 nPoints-1 に drawLine で線を引く
    	for(int i=0;i<nPoints-2;i++) {
    		frame.drawLine(xPoints[i],yPoints[i],xPoints[i+2],yPoints[i+2]);
    	}

        // TODO: (その 1.2) 頂点 nPoints-1 から頂点 0 に drawLine で線を引く
    	frame.drawLine(xPoints[nPoints-2],yPoints[nPoints-2],xPoints[0],yPoints[0]);
    	frame.drawLine(xPoints[nPoints-1],yPoints[nPoints-1],xPoints[1],yPoints[1]);
    	frame.drawLine(x-vx,y-vy,x-vx*3,y-vy*3);
    	frame.drawLine(x-vx,y-vy+5,x-vx*3,y-vy*3+5);
    	frame.drawLine(x-vx,y-vy-5,x-vx*3,y-vy*3-5);



    }

    /** 中心座標(x, y) を (vx, vy) だけ変化させる */
    public void move() {
        x += vx;
        y += vy;

        setPoints(); // 頂点の座標を再設定

        // TODO: (その 2) 三角形の移動を加速させる(変化量 (vx, vy) をそれぞれ 1 ずつ増やす)
        vx += 1;
        vy += 1;


    }

    /** テスト用の main メソッド(一つの三角形が流れ落ちていく) */
    public static void main(String[] args) {

        int ww = 400, wh = 400;     // ウィンドウの幅と高さ
        MyFrame2 f = new MyFrame2();
        f.bgColor = Color.black;    //背景色を黒に変更

        int x = 50, y = 50;
        int vx = 0, vy = 0;
        int size = 20;

        Star s = new Star(x, y, vx, vy, size);  // Triangle クラスのオブジェクト作成

        int animeT = 20;
        double wtime = 0.1;

        for(int t = 0; t < animeT; t++) {
            f.clear();

            // 三角形を黄色で描画
            f.setColor(255,255, 0);  
            s.draw(f);

            // 正しい中心座標 (x, y) を通る赤い十字を描画(軌道確認用)
            f.setColor(255, 0, 0);
            f.drawLine(x, 0, x, wh);
            f.drawLine(0, y, ww, y);

            // 三角形の中心座標を通る緑の十字を描画(レイアウト確認用)
            f.setColor(0, 255, 0);
            f.drawLine(s.x, 0, s.x, wh);
            f.drawLine(0, s.y, ww, s.y);

            x += vx; y += vy;
            vx += 1; vy += 1;

            // 三角形の移動
            s.move();
            f.sleep(wtime);
        }
    }
}
