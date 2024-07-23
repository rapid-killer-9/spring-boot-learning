package com.Alice_and_her_Bakery.Alice_and_her_Bakery.Syrup;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "flavour.syrup", havingValue = "strawberry")
public class SyrupStrawberry implements Syrup{

    @Override
    public String getSyrupType(){
        return "strawberry Syrup";
    }
}
