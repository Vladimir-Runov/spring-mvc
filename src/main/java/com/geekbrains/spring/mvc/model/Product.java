package com.geekbrains.spring.mvc.model;
    // 2) Создать класс Товар (Product), с полями id, title, cost;
    // 3) Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id;

public class Product {

    private Long id;
    private String title;
    private int cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setColor(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setSize(int val) {
        this.cost = val;
    }

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }
}