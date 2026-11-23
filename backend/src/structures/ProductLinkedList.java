package structures;

import model.Product;
import model.ProductCategory;

public class ProductLinkedList {
    private ProductNode head;
    private ProductNode tail;

    public ProductLinkedList() {
        head = null;
        tail = null;
    }


    public void addProduct(Product newProduct) {
        if (newProduct == null) {
            return;
        }

        ProductNode temp = head;

        while (temp != null) {
            if (temp.getProduct().getId() == newProduct.getId()) {
                System.out.println("Bu ID ile bir ürün zaten var.");
                return;
            }

            temp = temp.getNext();
        }

        ProductNode newNode = new ProductNode(newProduct);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void removeProduct (int targetId) {
        if (head == null) {
            System.out.println("Liste boş, silinecek ürün yok.");
            return;
        }


        if (head.getProduct().getId() == targetId) {
            head = head.getNext();


            if (head == null) {
                tail = null;
            }

            System.out.println("Ürün silindi.");
            return;
        }

        ProductNode temp = head;


        while (temp.getNext() != null) {
            if (temp.getNext().getProduct().getId() == targetId) {
                ProductNode deletedNode = temp.getNext();

                temp.setNext(deletedNode.getNext());


                if (deletedNode == tail) {
                    tail = temp;
                }

                System.out.println("Ürün silindi.");
                return;
            }

            temp = temp.getNext();
        }

        System.out.println("Ürün bulunamadı.");
    }

    public Product searchProduct(String targetName) {
        if (targetName == null) {
            return null;
        }

        ProductNode temp = head;

        while (temp != null) {
            if (targetName.equalsIgnoreCase(temp.getProduct().getName())) {
                return temp.getProduct();
            }

            temp = temp.getNext();
        }

        System.out.println("Ürün bulunamadı.");
        return null;
    }


    public ProductLinkedList filterProductsCategory(ProductCategory targetCategory) {
        ProductLinkedList resultList = new ProductLinkedList();

        if (targetCategory == null) {
            return resultList;
        }

        ProductNode temp = head;

        while (temp != null) {
            if (temp.getProduct().getCategory() == targetCategory) {
                resultList.addProduct(temp.getProduct());
            }

            temp = temp.getNext();
        }

        return resultList;
    }

    public void sortProductsPrice() {

        if (head == null || head.getNext() == null) {

            return;

        }

        boolean isSwapped;


        do {

            isSwapped = false;
            ProductNode temp = head;

            while (temp.getNext() != null) {

                if (temp.getProduct().getPrice() > temp.getNext().getProduct().getPrice()) {

                    Product tempProduct = temp.getProduct();
                    temp.setProduct(temp.getNext().getProduct());
                    temp.getNext().setProduct(tempProduct);

                    isSwapped = true;
                }

                temp = temp.getNext();

            }

        } while (isSwapped);

    }




    public void sortProductsName() {

        if (head == null || head.getNext() == null) {
            return;
        }

        boolean isSwapped;

        do {
            isSwapped = false;
            ProductNode temp = head;

            while (temp.getNext() != null) {
                if (temp.getProduct().getName().compareToIgnoreCase(temp.getNext().getProduct().getName()) > 0) {

                    Product tempProduct = temp.getProduct();
                    temp.setProduct(temp.getNext().getProduct());
                    temp.getNext().setProduct(tempProduct);

                    isSwapped = true;
                }

                temp = temp.getNext();
            }
        } while (isSwapped);
    }

    public ProductNode getHead() {

        return head;
    }

    public void updateProduct(int targetId, String newName, ProductCategory newCategory,
                              double newPrice, boolean newAvailable) {

        if (head == null) {

            System.out.println("Liste boş, güncellenecek ürün yok.");

            return;
        }

        ProductNode temp = head;

        while (temp != null) {

            Product product = temp.getProduct();


            if (product.getId() == targetId) {

                product.setName(newName);

                product.setCategory(newCategory);

                product.setPrice(newPrice);

                product.setAvailable(newAvailable);

                System.out.println("Ürün güncellendi.");

                return;

            }

            temp = temp.getNext();

        }


        System.out.println("Ürün bulunamadı.");
    }








}