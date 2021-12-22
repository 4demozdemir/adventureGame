public class Toolstore extends NormalLocation {



    public Toolstore(Player player, String name) {
        super(player, name);
    }

    @Override
    public   boolean onLocation(){
        boolean showMenu=true;
        while (showMenu){
            System.out.println(" ----------- Mağazaya hoşgeldiniz -----------");
            System.out.println("1-Silahlar \n2-Zırhlar  \n3-Çıkış \n" );
            System.out.print("İşleminiz :");
            int selectCase= input.nextInt();
            while(selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer");
                System.out.print("Seçiminiz : ");
                selectCase=input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz");
                    showMenu=false;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + selectCase);
            }

        }

        return true;
    }


    public void printWeapon(){
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+" - Silah : "+ w.getName()+ " Hasar :" + w.getDamage() +" Fiyat :"+ w.getPrice());
        }
        System.out.println("0 - Çıkış");
        }

        public void buyWeapon(){

        boolean showMenu = true;
        while(showMenu){

            System.out.print("Bir silah seçiniz :");
            int selectWeaponID= input.nextInt();

            if (selectWeaponID != 0){
                while(selectWeaponID<1 || selectWeaponID > Weapon.weapons().length){
                    System.out.print("Bir silah seçiniz :");
                    selectWeaponID=input.nextInt();
                }

                Weapon weapon = Weapon.getWeaponObjById(selectWeaponID);

                if (weapon!=null){
                    if (weapon.getPrice()>player.getMoney()){
                        System.out.println(" Bakiye yetersiz");
                        showMenu=false;
                    }else{
                        player.setMoney(player.getMoney()-weapon.getPrice());
                        System.out.println(weapon.getName()+"satın aldınız.");
                        System.out.println("Bakiye :" +player.getMoney());
                        this.getPlayer().getInventory().setWeapon(weapon);


                    }

                }
            }else {
                showMenu=false;
            }


        }



    }

    public void printArmor(){
        for (Armor  a : Armor.armors()){
            System.out.println(a.getId()+" - Zırh : "+ a.getName()+ " Engelleme  :" + a.getBlock() +" Fiyat :"+ a.getPrice());
        }
        System.out.println("0 - Çıkış");
    }


    void buyArmor() {
        boolean showMenu = true;

        while (showMenu){
            System.out.print("Bir zırh  seçiniz :");
            int selectArmorID = input.nextInt();

            if (selectArmorID !=0){
                while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
                    System.out.print("Bir zırh seçiniz :");
                    selectArmorID = input.nextInt();
                }

                Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

                if (selectedArmor != null) {
                    if (selectedArmor.getPrice() > player.getMoney()) {
                        System.out.println(" Bakiye yetersiz");
                        showMenu=false;
                    } else {
                        player.setMoney(player.getMoney() - selectedArmor.getPrice());
                        System.out.println(selectedArmor.getName() + "zırh satın aldınız.");
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Bakiye :" + player.getMoney());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                    }

                }
            }else {
                showMenu=false;
            }
    }

    }
}