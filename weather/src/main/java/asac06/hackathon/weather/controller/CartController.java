package asac06.hackathon.weather.controller;


import asac06.hackathon.weather.dto.CartDto;
import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.dto.ProductRequestDto;
import asac06.hackathon.weather.model.Cart;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.service.CartService;
import asac06.hackathon.weather.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cart")
@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private final CartService cartService;

    @PostMapping("/example")
    public ResponseEntity<Cart> addProductToCart(@RequestBody ProductRequestDto request) {
        Cart saveCart = cartService.addProductToCart(request.getId(), request.getSize());
        return ResponseEntity.status(HttpStatus.OK).body(saveCart);
    }

    @GetMapping("/find")
    public ResponseEntity<List<CartDto>> findAllCart() {
        List<CartDto> cartDtos = cartService.findAllCart();
        return ResponseEntity.status(HttpStatus.OK).body(cartDtos);
    }
}
