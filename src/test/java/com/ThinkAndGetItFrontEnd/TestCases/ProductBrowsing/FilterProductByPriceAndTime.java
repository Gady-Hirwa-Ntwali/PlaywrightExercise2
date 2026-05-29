package com.ThinkAndGetItFrontEnd.TestCases.ProductBrowsing;

import com.ThinkAndGetItFrontEnd.Base.BaseTest;
import com.ThinkAndGetItFrontEnd.ReusableMethods.OrderProductMethods;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.ThinkAndGetItFrontEnd.ReusableMethods.OrderProductMethods.*;
import static org.testng.Assert.assertEquals;
public class FilterProductByPriceAndTime extends BaseTest {
    @Test
    public void byPriceHigh() {

        OrderProductMethods.byPrice(page, "price_desc");
        Collections.sort(localOrder);
        Collections.reverse(localOrder);

        System.out.println("Expected Local Sorted Order: " + localOrder);
        System.out.println("Actual Browser Visual Order: " + browserOrder);
        page.waitForTimeout(7000);

        assertEquals(browserOrder, localOrder, "The web frontend failed to sort the items from high to low correctly!");
    }

    @Test
    public void byPriceLow(){

        OrderProductMethods.byPrice(page, "price_asc");
        Collections.sort(localOrder);

        System.out.println("Expected Local Sorted Order: " + localOrder);
        System.out.println("Actual Browser Visual Order: " + browserOrder);
        page.waitForTimeout(7000);

        assertEquals(browserOrder, localOrder, "The web frontend failed to sort the items from high to low correctly!");
    }

    public void byNewest(){
        byTime(page, "newest");
    }

    public void byPopular(){
        byTime(page, "popular");
    }

    public void byTopRating(){
        byTime(page, "rating");
    }

}
