package asac06.hackathon.weather.service;

import asac06.hackathon.weather.dto.CartDto;
import asac06.hackathon.weather.dto.ProductDto;
import asac06.hackathon.weather.model.Cart;
import asac06.hackathon.weather.model.Product;
import asac06.hackathon.weather.model.Size;
import asac06.hackathon.weather.repository.CartRepository;
import asac06.hackathon.weather.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Cart addProductToCart(Integer productId, Size size) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Cart findCart = cartRepository.findByProductId(productId);

        if (findCart == null) {
            Cart newCart = new Cart(product, size);
            newCart.setCount(1);
            return cartRepository.save(newCart);
        }
        else findCart.setCount(findCart.getCount() + 1);

        return cartRepository.save(findCart);
    }

    @Transactional
    public List<CartDto> findAllCart() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> cartDtos = new ArrayList<>();
        for (Cart cart : carts) {
            cartDtos.add(CartDto.from(cart));
        }
        return cartDtos;
    }
}
