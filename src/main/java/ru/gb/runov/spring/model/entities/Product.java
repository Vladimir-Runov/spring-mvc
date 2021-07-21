package ru.gb.runov.spring.model.entities;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/* Добавить метод получения продукта по id с использованием Optional
Сделать обработку исключения на случай, если продукта с запрашиваемым id не существует

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
 */

@Entity
@Table(name = "products")
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "price")
        private int price;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;


        @ManyToOne
        @JoinColumn(name = "details_id")
        private ProductDetails product_details;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int cost) {
            this.price = cost;
        }

        @Override
        public String toString() {
            return String.format("Product [id = %d, name = %s]", id, name);
        }

        public ProductDetails getProduct_details() {
            return product_details;
        }

        public void setProduct_details(ProductDetails product_details) {
            this.product_details = product_details;
        }
}

/*
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {

    //public Product(long l, String x1, int i) {
    //    id = l;
    //    name = x1;
    //    score = i;
    //}
 */