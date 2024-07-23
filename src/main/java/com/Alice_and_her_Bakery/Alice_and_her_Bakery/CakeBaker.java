package com.Alice_and_her_Bakery.Alice_and_her_Bakery;

import com.Alice_and_her_Bakery.Alice_and_her_Bakery.Frosting.Frosting;
import com.Alice_and_her_Bakery.Alice_and_her_Bakery.Syrup.Syrup;
import org.springframework.stereotype.Service;

@Service
public class CakeBaker {

  private Frosting frosting;
  private Syrup syrup;

  private CakeBaker(Frosting frosting, Syrup syrup){
      this.frosting = frosting;
      this.syrup = syrup;
  }

    void bakeCake(){
        System.out.println("Baking Cake with "+ frosting.getFrostingType()+ " and " + syrup.getSyrupType());
    }
}
