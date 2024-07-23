package com.Alice_and_her_Bakery.Alice_and_her_Bakery.Frosting;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "flavour.frosting", havingValue = "chocolate")
public class FrostingChocolate implements Frosting{

    @Override
    public String getFrostingType(){
        return "Chocolate Frosting";
    }
}
