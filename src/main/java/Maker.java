public class Maker {
    private final static int TIME_BUILD_CAR = 3000;
    private final static int MAX_BUILD_CAR = 5;
    private final Shop shop;

    public Maker(Shop shop) {
        this.shop = shop;
    }

    public void buildCar() {
        while (true) {
            try {
                Thread.sleep(TIME_BUILD_CAR);
                synchronized (shop.getSeller()) {
                    shop.getCars().add(new Car());
                    shop.getSeller().notify();
                }
                System.out.println("Производитель Toyota выпустил 1 авто");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
