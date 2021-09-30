package ru.gb.task7.service.implementation;

import org.springframework.stereotype.Service;
import ru.gb.task7.model.Cart;
import ru.gb.task7.model.CartPosition;
import ru.gb.task7.model.Product;
import ru.gb.task7.repository.CartPositionRepository;
import ru.gb.task7.repository.CartRepository;
import ru.gb.task7.repository.ProductRepository;
import ru.gb.task7.service.CartService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartPositionRepository cartPositionRepository;

    public CartServiceImplementation(CartRepository cartRepository,
                                     ProductRepository productRepository,
                                     CartPositionRepository cartPositionRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartPositionRepository = cartPositionRepository;
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void addProducts(Cart cart, Long[] productIds) {
        for (Long productId : productIds) {
            Optional<Product> productOptional = productRepository.findByIdAndIsDeletedIsFalse(productId);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                boolean isPresentInCart = cart.getCartPositions().stream()
                        .anyMatch(cp -> cp.getProduct().equals(product));
                if (isPresentInCart) {
                    cart.getCartPositions().stream()
                            .filter( cp -> cp.getProduct().equals(product) )
                            .findFirst()
                            .map( cp-> {
                                int q = cp.getQuantity();
                                cp.setQuantity(++q);
                                return cp;
                            } );
                } else {
                    CartPosition cartPosition = CartPosition.create(product);
                    cartPosition.setCart(cart);
                    cart.getCartPositions().add(cartPosition);
                }
            }
        }
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void removeProducts(Cart cart, Long[] productIds) {
        for (Long productId : productIds) {
            Optional<Product> productOptional = productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                Optional<CartPosition> cartPosition = cart.getCartPositions().stream()
                        .filter( cp -> cp.getProduct().equals(product) )
                        .findFirst();
                cartPosition.ifPresent( cp -> {
                    cart.getCartPositions().remove(cp);
                    cartPositionRepository.delete(cp);
                } );
            }
        }
//        cartRepository.save(cart);
    }

}
