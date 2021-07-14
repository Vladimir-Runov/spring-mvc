package ru.gb.runov.spring.model;
import lombok.*;
/* Добавить метод получения продукта по id с использованием Optional
Сделать обработку исключения на случай, если продукта с запрашиваемым id не существует
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private long id;
    private String name;
    private int score;

}
