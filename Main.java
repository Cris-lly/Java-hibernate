import java.util.List;

public class Main {

  public static void main(String[] args) {

    System.out.println("Hello world!");

    ProductModel productModel = new ProductModel();
    List<Product> products = productModel.findAll();
    System.out.println("Size: " + products.size());
  }
}