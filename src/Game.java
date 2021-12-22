import java.util.Scanner;

public class Game {
private final Scanner sc = new Scanner(System.in);


   void start() {
       System.out.println("-------- HOŞGELDİNİZ ------------");
       System.out.print("Adınızı giriniz :");
       String playerName=sc.nextLine();
    Player player = new Player(playerName);
    player.selectChar();
    Location location= null;

     while (true){


         System.out.println("\n ********** Bölgeler **********\n");
         System.out.println("1- Güvenli ev --> Can yenilenir... ");
         System.out.println("2- Dükkan  -->  Envanter satın alabilirsiniz !");
         System.out.println("3- Mağara  --> Ödül : Yemek");
         System.out.println("4- Orman   --> Ödül : Odun ");
         System.out.println("5- Nehir   --> Ödül : Su");
         System.out.println("6- Maden   --> Ödül : Para, Silah veya Zırh");
         System.out.println("0- Çıkış yap  ");
         System.out.print("Gitmek istediğiniz bölgeyi seçiniz :");
         int selectLoc=sc.nextInt();

         switch (selectLoc){
             case 1 :
                 location = new SafeHouse(player,playerName);
                 break;
             case 2:
                 location = new Toolstore(player,playerName);
                 break;

             case 3:
                 if (player.getInventory().isFood()){
                     System.out.println("Bu bölümü bitirdiniz");
                     System.out.print("Gitmek istediğiniz bölgeyi seçiniz :");
                      selectLoc=sc.nextInt();

                 }else if (!player.getInventory().isFood()){
                     location= new Cave(player);
                 }

                 break;
             case 4 :
                 if (player.getInventory().isFirewood()){
                     System.out.println("Bu bölümü bitirdiniz");
                     System.out.print("Gitmek istediğiniz bölgeyi seçiniz :");
                      selectLoc=sc.nextInt();

                 }else if (!player.getInventory().isWater()){
                     location=new Forest(player);
                 }


                 break;
             case 5 :
                 if (player.getInventory().isWater()==true){
                     System.out.println("Bu bölümü bitirdiniz");
                     System.out.print("Gitmek istediğiniz bölgeyi seçiniz :");
                      selectLoc=sc.nextInt();

                 }else if (!player.getInventory().isWater()){
                     location= new River(player);
                 }
                 break;
             case 6 :
                  location= new Coal(player,false);

                 break;
             case 0:
                 System.out.println("Çıkış yapılıyor...");
                 location=null;
                 break;
             default:
                 System.out.println("Lütfen geçerli bir bölge giriniz");
         }
         if (location==null){
             System.out.println("Çıkış yapıldı...");
             System.out.println("Tekrar görüşmek üzere ");
             break;
         }
         if (!location.onLocation()){
             System.out.println("Game Over!");
             start();
             break;
         }

     }








   }
}

