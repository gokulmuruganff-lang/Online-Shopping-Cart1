import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Product List
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 45000));
        products.add(new Product(2, "Mobile", 15000));
        products.add(new Product(3, "Headphones", 1200));
        products.add(new Product(4, "Keyboard", 800));
        products.add(new Product(5, "Pendrive", 550));

        // Cart List
        ArrayList<CartItem> cart = new ArrayList<>();

        int choice;

        while (true) {

            System.out.println("\n===== ONLINE SHOPPING MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill & Exit");
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Available Products ---");
                    for (Product p : products) {
                        System.out.println(p.id + ". " + p.name + " - Rs." + p.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to Add: ");
                    int pid = sc.nextInt();

                    Product selected = null;

                    for (Product p : products) {
                        if (p.id == pid) {
                            selected = p;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println("Invalid Product ID!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    cart.add(new CartItem(selected, qty));
                    System.out.println("✔ Added to Cart Successfully!");
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is Empty!");
                    } else {
                        System.out.println("\n--- Your Cart ---");
                        for (CartItem item : cart) {
                            System.out.println(item.product.name + " x " + item.quantity +
                                    " = Rs." + (item.product.price * item.quantity));
                        }
                    }
                    break;

                case 4:
                    double total = 0;
                    System.out.println("\n===== FINAL BILL =====");

                    for (CartItem item : cart) {
                        double cost = item.product.price * item.quantity;
                        System.out.println(item.product.name + " x " + item.quantity + " = " + cost);
                        total += cost;
                    }

                    System.out.println("Total Amount: Rs." + total);
                    System.out.println("Thank you for shopping!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
