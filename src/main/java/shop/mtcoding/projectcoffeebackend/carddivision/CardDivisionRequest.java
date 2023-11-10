package shop.mtcoding.projectcoffeebackend.carddivision;

import lombok.*;

import java.time.LocalDate;

public class CardDivisionRequest {


    @Getter
    @Setter
    public static class RegisterCardDivisionDTO {

        private int id;
        private String picUrl;
        private String name;
        private int money;
        private String startAt;


        public CardDivision toEntity() {
            return CardDivision.builder()
                    .id(id)
                    .picUrl(picUrl)
                    .name(name)
                    .money(money)
                    .startAt(startAt).build();
        }
    }
}