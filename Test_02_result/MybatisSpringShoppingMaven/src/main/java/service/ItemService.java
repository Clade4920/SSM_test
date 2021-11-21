package service;

import bean.vo.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemService {
    int getPageCount();
    Integer saveItem(Item newItem);
    Item findItemById(Integer itemId);
    List<Item> findNoIncludedItems();
    Integer modifyItem(Item modifiedItems);
    Integer deleteItem(Integer ItemId);
    Integer deleteItemByIds(List<Integer> deletedItemsIds);
}
