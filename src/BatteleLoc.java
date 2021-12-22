import java.util.Random;

public  abstract  class BatteleLoc  extends  Location{

private Obstacle obstacle;
private String award;
private int maxObstacle;
private Armor armor;
private Weapon weapon;
private boolean awardWon;





    public BatteleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomOstacleNumber();
        System.out.println("Şuan buradasınız : "+this.getName());
        System.out.println("Dikkat ol !  Burada "+obsNumber+" tane " +this.getObstacle().getName()+" yaşıyor...");
        System.out.print("<S>avaş  veya  <K>aç");
        String command = input.nextLine().toUpperCase();
        if (command.equals("S")){
           if ( combat(obsNumber)){
               System.out.println(this.getName()+" Temizlendi");
               return true;
           }
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz..");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for (int i =0 ; i <=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            Random random =new Random();
            int first=random.nextInt(2);

            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() >0){
              System.out.println("<V>ur yada <K>aç");
              String selectCombat=input.nextLine().toUpperCase();
                if (first==0){
                    if(selectCombat.equals("V")){
                        if (getPlayer().getHealth()>0){
                            System.out.println("Siz vurdunuz !");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                            if (getPlayer().getHealth()<0){
                                System.out.println("Öldünüz..");
                                getPlayer().setHealth(0);
                                return false;

                            }
                        }else{

                        }


                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0 ) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }else{
                    if(selectCombat.equals("V")){
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage < 0 ) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        System.out.println("Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                    } else {
                        return false;
                    }
                }


            }
                    if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                        System.out.println("Düşmanı yendiniz....");
                        switch (this.getName().toLowerCase()) {
                            case "mağara" -> {
                                player.getInventory().setFood(true);
                                System.out.println("Ödülünüz : " + this.getAward().toUpperCase());
                            }
                            case "orman" -> {
                                player.getInventory().setFirewood(true);
                                System.out.println("Ödülünüz : " + this.getAward().toUpperCase());

                            }
                            case "nehir" -> {
                                System.out.println("Ödülünüz : " + this.getAward().toUpperCase());
                                player.getInventory().setWater(true);

                            }
                            case "maden" -> {
                                System.out.println("Ödülünüz : " + this.getAward().toUpperCase());
                                player.getInventory().setAwardWon(true);

                            }

                        }
                        this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                        System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                    }

        }
        return false;
    }



    public void  afterHit(){
        System.out.println("Canınız : "+ this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" canı "+this.getObstacle().getHealth());
        System.out.println();
    }

    public void obstacleStats(int i ){
    System.out.println(i + "." +this.getObstacle().getName()+ " Değerleri ");
    System.out.println("----------------------------------------");
    System.out.println("Sağlık : "+ this.getObstacle().getHealth());
    System.out.println("Hasar : "+this.getObstacle().getDamage());
    System.out.println("Ödül    :"+this.getObstacle().getAward());


    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Sağlık :"+this.player.getHealth());
        System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar"+this.player.getTotalDamage());
        System.out.println("Para :" + this.player.getMoney());
    }
    public int randomOstacleNumber(){
        Random random= new Random();
        return random.nextInt(this.getMaxObstacle())+1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isAwardWon() {
        return awardWon;
    }

    public void setAwardWon(boolean awardWon) {
        this.awardWon = awardWon;
    }


}
