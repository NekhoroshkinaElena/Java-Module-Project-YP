public class Calculate {
    public double sum;
    public String allProducts = "";

    public String addProduct(Product product) {
        sum += product.price;
        allProducts += product.name + "\n";
        return "\nТовар успешно добавлен";
    }

    public double getSumForEveryHuman(int amount) {
        return sum / (double) amount;
    }
}
