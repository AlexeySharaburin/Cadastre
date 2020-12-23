import java.util.function.Function;

public class Deal {
    private int number;
    private int lenght;
    private int width;
    private int price;
    private int pricePro;

    public Deal(int number, int lenght, int width, int price) {
        this.number = number;
        this.lenght = lenght;
        this.width = width;
        this.price = price;
        this.pricePro = (price / (width * lenght));
    }

    public int pricePro() {
        return pricePro;
    }

    @Override
    public String toString() {
        return " Данные по сделке номер " + number +
                ": цена продажи (за кв.метр) = " + pricePro +
                " руб, длина участка = " + lenght +
                " м, ширина участка = " + width +
                " м, общая цена продажи = " + price +
                " руб.";
    }
}

