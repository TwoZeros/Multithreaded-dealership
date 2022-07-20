import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final int SPEND_TIME_FOR_BUY = 500;
    private final Seller seller = new Seller();
    private final List<Car> cars = new ArrayList<>();

    public Seller getSeller() {
        return seller;
    }

    public void buyCar() {
        synchronized (seller) {
            try {
                System.out.println(Thread.currentThread().getName() + " Зашел в магазин");
                while (getCars().size() == 0) {
                    System.out.println("Машин нет");
                    seller.wait();
                }
                Thread.sleep(SPEND_TIME_FOR_BUY);
                getCars().remove(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        }
    }


    public List<Car> getCars() {
        return cars;
    }

}
