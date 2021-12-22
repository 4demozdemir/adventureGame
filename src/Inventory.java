public class Inventory {

    Weapon weapon;
    Armor armor;

    private boolean food;
    private boolean firewood;
    private boolean water;
    private boolean awardWon;

    public Inventory() {
        this.armor=new Armor(0,"paçavra",0,0);
        this.weapon=new Weapon(0,"Yumruk",0,0);
        this.awardWon=isAwardWon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isAwardWon() {
        return awardWon;
    }

    public void setAwardWon(boolean awardWon) {
        this.awardWon = awardWon;
    }
}
