package com.codegym.views;

import com.codegym.controller.ProductController;
import com.codegym.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chuong trinh quan ly san pham");
        ProductController productController = new ProductController();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId() +
                                        " NAME: " + product.getName() +
                                        " PRICE: " + product.getPrice() +
                                        " STATUS: " + product.getStatus() +
                                        " DESCRIPTION: " +product.getDescription()
                        );
                    }
                    break;
                }
                case 2: {
                    System.out.println("Them moi san pham.");
                    Product productObject = inputProduct();
                    productController.addProduct(productObject);
                    break;

                }

                case 3:{
                    System.out.println("Sua san pham co ID = :  ");
                    int idInput = scanner.nextInt();
                    Product productObject = inputProduct();
                    productController.editProduct(idInput,productObject);
                    break;
                }
                case 4:
                {
                    System.out.println("Xoa san pham co ID = : ");
                    int idInput = scanner.nextInt();
                    productController.deleteProduct(idInput);
                    break;
                }
                case 5:
                {
                    /////Search by name
                    System.out.println("Tim kiem san pham theo ten la: ");
                    scanner.nextLine();
                    String nameInput = scanner.nextLine();
                    Product p = productController.searchByName(nameInput);
                    if (p== null) {
                        System.out.println("khong tim thay san pham:"+nameInput);
                    } else {
                        System.out.println("san pham can tim:"+p);
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Sap xep tang dan theo price");
                    productController.sortDescending();
                    break;
                }

            }

        } while (choice != 0);
    }
    private static void menu() {
        System.out.println("1. Hien thi danh sach san pham.");
        System.out.println("2. Them moi san pham.");
        System.out.println("3. Sua san pham.");
        System.out.println("4. Xoa san pham.");
        System.out.println("5. Tim san pham theo ten.");
        System.out.println("6. Sap xep tang dan theo price.");
        System.out.println("0. Thoat");
        System.out.println("Chon chuc nang:");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap NAME:");
        String name = input.nextLine();
        System.out.println("Nhap PRICE:");
        float price = input.nextFloat();
        input.nextLine();
        System.out.println("Nhap STATUS:");
        String status = input.nextLine();
        System.out.println("Nhap DESCRIPTION:");
        String description = input.nextLine();

        Product product = new Product(id, name, price,status,description);
        return product;
    }
}
