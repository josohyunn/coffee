package shop.mtcoding.projectcoffeebackend.cart.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.projectcoffeebackend._core.errors.exception.Exception401;
import shop.mtcoding.projectcoffeebackend._core.utils.ApiUtils;
import shop.mtcoding.projectcoffeebackend.cart.Cart;
import shop.mtcoding.projectcoffeebackend.cart.CartService;
import shop.mtcoding.projectcoffeebackend.cart.api.CartRestResponse.ViewCartListDTO;
import shop.mtcoding.projectcoffeebackend.user.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class CartRestController {

    private final CartService cartService;
    private final HttpSession session;

    @PostMapping("/carts/addcartlist")
    public ResponseEntity<?> addCartList(@RequestBody List<CartRestRequest.AddCartListDTO> addCartDTOS, Errors errors) {
        System.out.println("테스트 : add 카트 진입");
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            throw new Exception401("로그인이 필요한 서비스입니다.");
        }
        cartService.addCartList(addCartDTOS, sessionUser);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    @GetMapping("/carts/viewcartlist")
    public ResponseEntity<?> viewCartList() {
        System.out.println("테스트 : view 카트 진입");

        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser == null) {
            throw new Exception401("로그인이 필요한 서비스입니다.");
        }

        ViewCartListDTO response = cartService.viewCartList(sessionUser);

        System.out.println("테스트 : "+ response.getProductList());
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }
}
