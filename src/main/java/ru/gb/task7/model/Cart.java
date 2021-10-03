package ru.gb.task7.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<CartPosition> cartPositions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Collection<CartPosition> getCartPositions() {
        return cartPositions;
    }

    public void setCartPositions(Collection<CartPosition> cartPositions) {
        this.cartPositions = cartPositions;
    }
}
