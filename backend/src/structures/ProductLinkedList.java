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


    public void add(Product newProduct) {
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

    public void removeById(int targetId) {
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

    public Product searchByName(String targetName) {
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


    public ProductLinkedList filterByCategory(ProductCategory targetCategory) {
        ProductLinkedList resultList = new ProductLinkedList();

        if (targetCategory == null) {
            return resultList;
        }

        ProductNode temp = head;

        while (temp != null) {
            if (temp.getProduct().getCategory() == targetCategory) {
                resultList.add(temp.getProduct());
            }

            temp = temp.getNext();
        }

        return resultList;
    }


    public void sortByPrice() {
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
}