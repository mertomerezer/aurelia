package persistence;


import model.Product;
import model.ProductCategory;
import structures.ProductLinkedList;
import structures.ProductNode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class ProductFileManager {


    public ProductLinkedList loadProducts(String filePath) {
        ProductLinkedList productList = new ProductLinkedList();


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }


                String[] parts = line.split(",");


                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                ProductCategory category = ProductCategory.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                boolean isAvailable = Boolean.parseBoolean(parts[4]);

                Product product = new Product(id, name, category, price, isAvailable);
                productList.add(product);
            }


        } catch (IOException exception) {
            System.out.println("Dosya okunamadı: " + exception.getMessage());
        }


        return productList;

    }


    public void saveProducts(ProductLinkedList productList, String filePath) {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            ProductNode temp = productList.getHead();


            while (temp != null) {

                Product product = temp.getProduct();

                writer.write(product.getId() + ","
                        + product.getName() + ","
                        + product.getCategory().name() + ","
                        + product.getPrice() + ","
                        + product.isAvailable());

                writer.newLine();
                temp = temp.getNext();
            }

        }
        catch (IOException exception) {
            System.out.println("Dosyaya yazılamadı: " + exception.getMessage());
        }


    }



}