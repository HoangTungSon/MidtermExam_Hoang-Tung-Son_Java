package productManagement_java;

import java.util.ArrayList;


public class ProductTest {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Product A", 12.2f, "Brand new product A"));
        products.add(new Product(2, "Product B", 11.1f, "Brand new product B"));
        products.add(new Product(3, "Product C", 13.0f, "Brand new product C"));
        products.add(new Product(4, "Product D", 14.5f, "Brand new product D"));
        products.add(new Product(5, "Product E", 10.0f, "Brand new product E"));
        products.add(new Product(6, "Product F", 0.2f, "Brand new product F"));
        products.add(new Product(7, "Product G", 0.5f, "Brand new product G"));
        products.add(new Product(8, "Product H", 1f, "Brand new product H"));
        products.add(new Product(9, "Product I", 4f, "Brand new product I"));
        products.add(new Product(10, "Product J", 8f, "Brand new product J"));


        addNewProduct(products, new Product(11, "Product K", 7f, "Brand new product K"));
        editProduct(products, 3, new Product(3, "Product new C", 9f, "Super brand new product C"));
        remove(products, 123);
        viewProduct(products);

        findProduct(products, "Product E");

    }

    private static void viewProduct(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + " Price: " + product.getPrice() + " Description: " + product.getDescription());
        }
    }

    private static void addNewProduct(ArrayList<Product> products, Product newProduct) {
        products.add(newProduct);
        System.out.println("Successfully adding new product");
    }

    private static void editProduct(ArrayList<Product> products, int index, Product updateProduct) {
        try {
            products.add(index, updateProduct);
            products.remove(index + 1);
            System.out.println("Successfully updating the product");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There's no matched index");
        }
    }

    private static void remove(ArrayList<Product> products, int index) {
        try {
            products.remove(index);
            System.out.println("Successfully removing product");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("There's no matched index");
        }
    }

    private static boolean findProduct(ArrayList<Product> products, String nameProduct) {
        for (Product product : products) {
            if (nameProduct.equals(product.getName())) {
                System.out.println("Product: " + product.getName() + " Price: " + product.getPrice() + " Description: " + product.getDescription());
                return true;
            }
        }
        System.out.println("There's no matched product");
        return false;
    }
}
