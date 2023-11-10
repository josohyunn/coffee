package shop.mtcoding.projectcoffeebackend.product;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shop.mtcoding.projectcoffeebackend.category.Category;
import shop.mtcoding.projectcoffeebackend.product.option.Option;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "product_tb")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 100)
    private String engName;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column(nullable = true, length = 1000)
    private String tip;
    @Column(nullable = true, length = 10)
    private Integer isIced; // 0 : hot, 1 : iced, 2 : both
    @Column(nullable = false, length = 500)
    private String picUrl;
    // @Column
    // private String caption; // new/ hot/ best

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Option> options;

    @Builder
    public Product(int id, String name, String engName, String description, String tip, int isIced, String picUrl,
            Category category) {
        this.id = id;
        this.name = name;
        this.engName = engName;
        this.description = description;
        this.tip = tip;
        this.isIced = isIced;
        this.picUrl = picUrl;
        // this.caption = caption;
        this.category = category;
    }

    // TODO: 추가기능 - 상품정보제공고시
    // private FoodInfo foodInfo;

    // TODO: 추가기능 - 워밍옵션(빵류)

    // TODO: 추가기능 - 메뉴 추가(루어팍버터, 크림치즈28g)

    // TODO: 추가기능 - NEW/HOT/BEST

    // TODO: 추가기능 - 알러지(알러지tb 생성)

    // TODO: 비슷한 다른 메뉴 추천

}