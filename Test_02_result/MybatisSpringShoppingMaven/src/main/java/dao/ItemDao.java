package dao;

import bean.vo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository("itemDao")
@Mapper
public interface ItemDao {

    List<Item> findNoIncludedItems();
    Item findItemById(Integer itemId);
    Integer saveItem(Item newItem);
    Integer modifyItem(Item modifiedItems);
    Integer deleteItem(Integer ItemId);
    Integer deleteItemsByIds(List<Integer> ids);
}
