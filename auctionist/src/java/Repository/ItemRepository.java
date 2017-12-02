/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.Item;
import Utils.RestfulUtility;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author fabri
 */
public class ItemRepository {

    private String itemUrl = "https://auctionist-f4888.firebaseio.com/Item.json?auth=";
    private static final ItemRepository itemRepository = new ItemRepository();

    public static ItemRepository Get() {
        return itemRepository;
    }

    public Item GetItem(String auth, String id) {

        List<Item> items = GetItemList(auth).stream().filter(p->p.getId().equals(id)).collect(Collectors.toList());
        if(items.size()>0){
          return items.get(0);
        }
        return null;
    }

    public List<Item> GetItemList(String auth) {
      
      
       
        List<Item> itemList = new ArrayList();
        
       
       
         try{
           itemList = (List<Item>)RestfulUtility.get(auth, itemUrl, Item.class);
         }catch(IOException ex){}
        
       
        
        return  itemList;
    }

    public List<Item> Search(String auth, String type, String name) {
        List<Item> itemList;

        itemList = GetItemList(auth);
        return itemList;
    }

    public int DeleteItem(String auth, int id) {
        
        return 0;
    }

    public Item Save(String auth, Item item) throws IOException {
      return InsertItem(auth, item);
    }

    private Item InsertItem(String auth, Item item) throws IOException {

        return (Item) RestfulUtility.post(auth, itemUrl, item, Item.class);

    }

    private Item UpdateItem(String auth, Item item) throws IOException {
        return (Item) RestfulUtility.put(auth, itemUrl, item, Item.class);
    }
}
