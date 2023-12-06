public abstract class Actor{
    protected int health;

    //추상 메소드
    public abstract void attack();

    //피해 판정
    public void hit(int damage){
        health-=damage;
    }

    //사망 확인
    public boolean isDead(){
        return health<=0;
    }
}