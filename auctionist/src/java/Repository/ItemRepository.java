/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.Item;
import Utils.RestfulUtility;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class ItemRepository {

    private String itemUrl = "";
    private static final ItemRepository itemRepository = new ItemRepository();

    public static ItemRepository Get() {
        return itemRepository;
    }

    public Item GetItem(int id) {

        return null;
    }

    public List<Item> GetItemList(String selector) {
        List<Item> itemList = new ArrayList<>();

        return itemList;
    }

    public List<Item> Search(String type, String name) {
        List<Item> itemList;

        itemList = GetItemList("");
        return itemList;
    }

    public int DeleteItem(int id) {
        
        return 0;
    }

    public Item Save(Item item) throws IOException {
        if (item.getId() != null) {
            return InsertItem(item);
        } else {
            return UpdateItem(item);
        }
    }

    private Item InsertItem(Item item) throws IOException {

        return (Item) RestfulUtility.post(itemUrl, item, Item.class);

    }

    private Item UpdateItem(Item item) throws IOException {
        return (Item) RestfulUtility.put(itemUrl, item, Item.class);
    }
}
