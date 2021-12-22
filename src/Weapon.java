public class Weapon   {
   private  int id ;
  private String name;
   private  int damage;
   private int price;

    public Weapon(int id, String name,int damage, int money) {
        this.id = id;
        this.name=name;
        this.damage = damage;
        this.price = money;
    }
    public  static Weapon[] weapons(){
            Weapon[] weponList = new Weapon[3];
            weponList[0]=new Weapon(1,"Tabanca",2,25);
            weponList[1]=new Weapon(2,"kılıç  ",3,35);
            weponList[2]=new Weapon(3,"Tüfek  ",7,45);

        return weponList;
    }


    public static Weapon getWeaponObjById(int id){
        for (Weapon w : Weapon.weapons()){
                if (w.getId()==id){
                    return  w;
                }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
