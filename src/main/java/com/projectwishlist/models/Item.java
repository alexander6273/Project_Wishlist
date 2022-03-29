package com.projectwishlist.models;

public class Item
{
    private int id;
    private String name;
    private int price;
    private String link;

    public Item(int id, String name, int price, String link) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "item id: " + id + "item name: " + name + "item price: " + price + "item link: " + link;
    }
}
