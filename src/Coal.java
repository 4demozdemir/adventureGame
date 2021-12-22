import java.util.Random;

public class Coal extends  BatteleLoc{
    private Armor armor = null;
    private Weapon weapon = null;

    public Coal(Player player,boolean won) {

        super(player ,"maden",new Snake(),"",5);
        ranItem();
    }

      void   ranItem() {
        Random ranItem = new Random();
        int ratio =ranItem.nextInt(100)+1;
        int  ratioItem =ranItem.nextInt(100)+1;

        int ostacle=ranItem.nextInt(5)+1;

        this.setMaxObstacle(ostacle);

        if (ratio >0 && ratio<16){

            if (ratioItem>0 && ratioItem<=20){
                this.setWeapon(new Weapon(3, "tüfek", 7, 45));
                this.setAward("tüfek");
                this.setAwardWon(true);
            }else if(ratioItem>20 && ratioItem<=50){
                this.setWeapon(new Weapon(2, "kılıç", 3, 35));
                this.setAward("kılıç");
                this.setAwardWon(true);
            }else if (ratioItem>50 && ratioItem<=100){
                this.setWeapon(new Weapon(1, "tabanca", 2, 25));
                this.setAward("tabanca");
                this.setAwardWon(true);
            }

        }else if(ratio>20 && ratio<=30){
            if (ratioItem>0 && ratioItem<=50){
                this.setArmor(new Armor(1,"haif",1,15));
                this.setAward("hafif zırh");
            }else if(ratioItem>50 && ratioItem<=80){
                this.setArmor(new Armor(2,"orta",3,25));
                this.setAward("orta zırh");
            }else if (ratioItem>80 && ratioItem<=100){
                this.setArmor(new Armor(3,"ağır",5,40));
                this.setAward("ağır zırh");
            }


        }else if(ratio>30 && ratio<=55){
            if (ratioItem>0 && ratioItem <=20){
                this.getPlayer().setMoney(10);
                this.setAward("10 para");
            }else if(ratioItem>20 && ratioItem<=50){
                this.getPlayer().setMoney(5);
                this.setAward("5 para");
            }else if(ratioItem>50  && ratioItem<=100){
                this.getPlayer().setMoney(1);
                this.setAward("1 para");
            }

        }else if (ratio>55 && ratio<=100){
           System.out.println("Ödül alamadınız !");
        }
    }



}
