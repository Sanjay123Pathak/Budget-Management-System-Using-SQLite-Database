package com.example.homemanagementsystemapp;

import java.io.Serializable;

public class SQLiteModalClass implements Serializable {
    String itemName,itemCost,itemDesc;
    public SQLiteModalClass(String itemName, String itemCost, String itemDesc) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemDesc = itemDesc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
