package pl.ttomczyk.sptest;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
public class ShopStart extends AbstractShop {

}
