import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 

public class Pea{
    private int type, damage;
    private int x, y; //공격 배열 설정 [5][9]
    private int coorX, coorY; //추사체 위치설정
    private static Point[][] pea_f = new Point[5][9]; //투사체 위치를 정하는 배열
    private Clip clip;
    
    public Pea(int type, int x, int y){
        this.type=type;
        this.x=x;
        this.y=y;
        convert(x,y);
        if(type==2){ //Peashooter
        	damage=6;
        }
        else if(type==3){ //Repeater
        	damage=5;
        }
    }

    //static initialization block
    static{
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                //투사체 위치 설정
                pea_f[i][j] = new Point(296+j*81+28, 117+i*98-19);
            }
        }
    }

    //getter
    public int getCoorX(){return coorX;}
    public int getCoorY(){return coorY;}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getType(){return type;}
    public int getDamage(){return damage;}

    public void move(){
        coorX+=6; // 투사체 속도
    }
    public void convert(int i, int j){ // 투사체 위치를 coor에 따라 변경
        coorX=pea_f[i][j].getX();
        coorY=pea_f[i][j].getY();
    }

    public void splat(){ // 타격음 재생
        try{
            // clip reference 생성 
            clip = AudioSystem.getClip();
            // clip 에서 소리 재생 
            clip.open(AudioSystem.getAudioInputStream(Audio.class.getResource(("Assets/wav/Splat.wav")))); 
        }catch(Exception ex){ 
            ex.printStackTrace();
        }
        clip.start();
    }
    public void shieldhit(){ //play shieldhit sound
        try{
            // create clip reference 
            clip = AudioSystem.getClip();
            // open audioInputStream to the clip 
            clip.open(AudioSystem.getAudioInputStream(Audio.class.getResource(("Assets/wav/Shieldhit.wav")))); 
        }catch(Exception ex){ 
            ex.printStackTrace();
        }
        clip.start();
    }
}