import java.util.Scanner;

public class Player  {


 private Scanner sc = new Scanner(System.in);
 private int damage;
 private int health;
 private int originalHealth;
 private  int money ;
 private String name;
 private String charName;
 private Inventory inventory;



        public  Player(String  name){
            this.name=name;
            this.inventory=new Inventory();

        }



        public void selectChar(){
            Charecters[] charList={new Samurai(),new Archer(),new Knight()};

            System.out.println("Karakterler");
            for (Charecters list : charList) {
                System.out.println("İD : "+list.getId()+"\t Karakter:"+ list.getName()+
                        "\t Hasar:"+list.getDamage()+" " +
                        "\t Sağlık:"+list.getHealthy()+" " +
                        "\t Para:"+list.getMoney()+"");
            }
                System.out.print("Bir karakter seçiniz :");
            int selectChar=sc.nextInt();
            switch (selectChar){
                case 1 :
                    initPlayer(new Samurai());
                    break;
                case 2 :
                    initPlayer(new Knight());
                    break;
                case 3:
                    initPlayer(new Archer());
                    break;
                default:
                    initPlayer(new Samurai());
            }
         /*   System.out.println("Karakter:"+ this.getCharName()+
                    "\t Hasar:"+this.getDamage()+" " +
                    "\t Sağlık:"+this.getHealthy()+" " +
                    "\t Para:"+this.getMoney()+"");
         */
        }
        public void printInfo(){
            System.out.println("\nSilahınız: "+ this.getInventory().getWeapon().getName()+
                    "\nZırhınız:"+ this.getInventory().getArmor().getName()+
                    "\tHasar:"+this.getTotalDamage()+" " +
                    "\tSağlık:"+this.getHealth()+" " +
                    "\tPara:"+this.getMoney()+"");
        }
public void initPlayer(Charecters charecters){
            this.setCharName(charecters.getName());
            this.setDamage(charecters.getDamage());
            this.setHealth(charecters.getHealthy());
            this.setOriginalHealth(charecters.getHealthy());
            this.setMoney(charecters.getMoney());
}
    public int getTotalDamage(){
            return  damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
