import java.util.Random;

public class Snake extends Obstacle{

    public Snake() {

        super(4, "yılan",6 , 12, 0);
        this.setDamage(ranDamage());
    }
    int ranDamage(){
        Random random = new Random();
        int damage = random.nextInt(4)+3;
        return damage;
      }

}
