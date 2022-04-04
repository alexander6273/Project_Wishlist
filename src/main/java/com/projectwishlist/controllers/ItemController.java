package com.projectwishlist.controllers;

import com.projectwishlist.models.Item;
import com.projectwishlist.repositories.ItemRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ItemController {
    ItemRep itemRepo = new ItemRep();

    @GetMapping("/showWishlistItems")
    public String showWishlistItems(Model model) {
        ArrayList<Item> itemList = itemRepo.getItemsFromWishlist(1);
        model.addAttribute("items", itemList);
        return "wishlist-items";
    }

    @GetMapping("/wishlist")
    public String wishlist(@RequestParam int id, Model model) {
        ArrayList<Item> itemList = itemRepo.getItemsFromWishlist(id);
        model.addAttribute("items", itemList);
        return "wishlist-items";
    }
}
