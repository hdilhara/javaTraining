package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterringWithotStream {

    public static void main(String[] args) {
        List<Product> products=new ArrayList<>();

        products.add(new Product(1,"HP",12500));
        products.add(new Product(1,"DELL",13500));
        products.add(new Product(1,"Asuze",15400));
        products.add(new Product(1,"Lenovo",4500));

        System.out.println(products);

        List<Float> prizes=new ArrayList<>();
        for(Product p:products){
            prizes.add(p.getPrice());
        }

        System.out.println(prizes);


    }

}

class Product{
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}