package Nomor14;

import java.awt.Point;
import java.util.Scanner;

public class RumahKakek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Rumah : ");
        int jumlahRumah = sc.nextInt();
        Point[] posisiRumah = new Point[jumlahRumah];
        Point rumahKakek;
        int D;

        for (int i = 0; i < posisiRumah.length; i++) {
            System.out.println("Rumah Ke- "+(i+1));
            System.out.print("X : ");
            int x = sc.nextInt();
            System.out.print("Y : ");
            int y = sc.nextInt();
            posisiRumah[i] = new Point(x,y);
        }

        System.out.println("Rumah Kakek");
        System.out.print("X : ");
        int x = sc.nextInt();
        System.out.print("Y : ");
        int y = sc.nextInt();
        rumahKakek = new Point(x,y);
        System.out.print("Masukkan Kemampuan Jarak Kakek : ");
        D = sc.nextInt();

        Point solusi = cariLokasi(posisiRumah,rumahKakek,D);
        System.out.println();
        System.out.println("==========SOLUSI==========");
        System.out.println(solusi.x+","+ solusi.y);

    }

    static Point cariLokasi(Point[] rumah,Point rumahKakek,int D){
        Point lokasi = null;
        int xKakek = rumahKakek.x;
        int yKakek = rumahKakek.y;
        int terdekat = Integer.MAX_VALUE;

        for (int i = 0; i < rumah.length; i++) {
            int x1 = rumah[i].x;
            int y1 = rumah[i].y;
            int jarakKakek = cariJarak(x1,y1,xKakek,yKakek);

            if(jarakKakek<(D/2)){
                int totalJarak = 0;
                for (int j = 0; j < rumah.length; j++) {
                    int x2 = rumah[j].x;
                    int y2 = rumah[j].y;

                    int jarakAntarRumah = cariJarak(x2,y2,x1,y1);
                    totalJarak+=jarakAntarRumah;
                }
                if (terdekat>totalJarak){
                    terdekat=totalJarak;
                    lokasi = new Point(x1,y1);
                }
            }
        }
        if(lokasi==null){
            lokasi=new Point(rumahKakek.x,rumahKakek.y);
        }
        return lokasi;
    }
    static int cariJarak(int xRumah,int yRumah,int xKakek,int yKakek){
        int pindah = 0;
        while (!(xRumah==xKakek && yRumah==yKakek)){
            if (xRumah>xKakek && yRumah>yKakek){
                xKakek++;
                yKakek++;
                pindah++;
            } else if (xRumah<xKakek && yRumah<yKakek){
                xKakek--;
                yKakek--;
                pindah++;
            } else if (xRumah>xKakek && yRumah<yKakek) {
                xKakek++;
                yKakek--;
                pindah++;
            } else if (xRumah<xKakek && yRumah>yKakek) {
                xKakek--;
                yKakek++;
                pindah++;
            } else if (xRumah>xKakek && yRumah==yKakek) {
                xKakek++;
                pindah++;
            } else if (xRumah<xKakek && yRumah==yKakek) {
                xKakek--;
                pindah++;
            } else if (xRumah==xKakek && yRumah>yKakek) {
                yKakek++;
                pindah++;
            } else if (xRumah==xKakek && yRumah<yKakek) {
                yKakek--;
                pindah++;
            }
        }
        return pindah;
    }
}