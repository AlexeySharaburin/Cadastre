import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    final static int countDeals = 100;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 'честную' цену за квадратный метр для вашего региона, руб.: ");
        int fairPrice = scanner.nextInt();

        String unFair = "Нечестная сделка!";
        String fair = "Честная сделка!";

        countFairDeals(generateDeals(), fairPrice);
        Thread.sleep(3000);
        fairDeals(generateDeals(), fairPrice, fair, unFair);

    }

    public static void countFairDeals(List<Deal> listDeals, int price) {
        long countFairDeals = listDeals.stream()
                .filter(x -> x.pricePro() > price)
                .count();
        System.out.println("\nОбщее количество 'сделок в вашем регионе: " + countDeals);
        System.out.println("\nКоличество 'честных' сделок (цена больше " + price + " руб. за кв.метр) в вашем регионе: " + countFairDeals);
    }


    public static void fairDeals(List<Deal> listDeals, int price, String fair, String unFair) {
        System.out.print("\nСписок всех сделок в вашем регионе с указанием 'честности' сделки:\n");
        listDeals.stream()
                .map(x -> {
                    if (x.pricePro() >= price) {
                        return fair + x;
                    } else {
                        return unFair + x;
                    }
                })
                .forEach(System.out::println);
    }

    public static List<Deal> generateDeals() {
        List<Deal> listDeals = new ArrayList<>();
        for (int i = 0; i < countDeals; i++) {
            listDeals.add(new Deal(
                    (i + 1),
                    (new Random().nextInt(50) + 1),
                    (new Random().nextInt(50) + 1),
                    (new Random().nextInt(10000)) + 1000)
            );
        }
        return listDeals;
    }

}
