public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player, String name) {
        super(player, "Güvenli ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz...");
        System.out.println("Canınınz yenilendi ..");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
