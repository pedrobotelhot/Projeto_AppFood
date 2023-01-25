package food.com.br.appfood.Models;

public class HomeFoodsModel {

    private String id;
    private String img;
    private String name;
    private String dsc;
    private double price;
    private int rate;
    private String country;


    public HomeFoodsModel(String id, String img, String name, String dsc, double price, int rate, String country) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.dsc = dsc;
        this.price = price;
        this.rate = rate;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDsc() {
        return dsc;
    }

    public double getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }

    public String getCountry() {
        return country;
    }
}
