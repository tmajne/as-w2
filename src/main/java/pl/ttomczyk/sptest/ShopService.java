package pl.ttomczyk.sptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private Shop shop;

    @Autowired
    public ShopService(Shop shop) {
        this.shop = shop;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void process() {

        this.shop.addToCart(this.fakeProductFactory("Doom"));
        this.shop.addToCart(this.fakeProductFactory("Tomb Raider"));
        this.shop.addToCart(this.fakeProductFactory("Oblivion"));
        this.shop.addToCart(this.fakeProductFactory("Shogun: Total War"));
        this.shop.addToCart(this.fakeProductFactory("HM&M3"));

        this.shop.showCart();
    }

    private Product fakeProductFactory(String name) {
        int price = 50 + (int) (Math.random() * (300 - 50));
        return new Product(name, price);
    }
}
