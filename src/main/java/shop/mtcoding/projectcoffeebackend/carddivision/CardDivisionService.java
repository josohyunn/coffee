package shop.mtcoding.projectcoffeebackend.carddivision;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CardDivisionService {

    final private CardDivisionJPARepository cardDivisionJPARepository;

    public void registerCardDivision(CardDivisionRequest.RegisterCardDivisionDTO registerCardDivisionDTO) {

        try {
            cardDivisionJPARepository.save(registerCardDivisionDTO.toEntity());
        } catch (Exception e) {
            throw e;
        }
        ;
    }
}
