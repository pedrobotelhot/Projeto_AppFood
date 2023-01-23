package food.com.br.appfood.Models;

public class HomeFoodsModel {

    private String name;
    private int img;
    private double price;
    private int rate;

    public HomeFoodsModel(String name, int img, double price, int rate) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public double getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }
}
