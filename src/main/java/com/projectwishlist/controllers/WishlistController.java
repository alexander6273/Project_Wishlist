package com.projectwishlist.controllers;

import com.projectwishlist.models.Wishlist;
import com.projectwishlist.repositories.WishlistRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class WishlistController {
    WishlistRep wishListRep = new WishlistRep();

    @GetMapping("/wltest")
    public String wlTest() {
        return wishListRep.getData();
    }

    @GetMapping("/newTest")
    public String newTest() {
        Wishlist wl = wishListRep.getWishListFromDB(1);
        System.out.println(wl);
        return wl.toString();
    }

    @GetMapping("/getWishlist")
    public String getWishlist(Model model) {
        ArrayList<Wishlist> list = wishListRep.getAllWishlistsFromUser();
        model.addAttribute("wishlists", list);
        return "wishlist";
    }


}
