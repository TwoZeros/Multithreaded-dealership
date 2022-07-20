public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        Maker toyota = new Maker(shop);
        Thread makerDemon =  new Thread(null,toyota::buildCar, "Производитель1");
        makerDemon.setDaemon(true);
        makerDemon.start();

        new Thread(null, shop::buyCar,"Покупатель 1").start();
        new Thread(null, shop::buyCar,"Покупатель 2").start();
        new Thread(null, shop::buyCar,"Покупатель 3").start();
        new Thread(null, shop::buyCar,"Покупатель 4").start();
        new Thread(null, shop::buyCar,"Покупатель 5").start();
    }
}
