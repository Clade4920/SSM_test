package service.impl;

import bean.vo.Item;
import dao.ItemDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.ItemService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource(name="itemDao")
    ItemDao itemDao;

    @Override
    public int getPageCount() {
        return 0;
    }

    @Override
    public Integer saveItem(Item newItem) {
        return itemDao.saveItem(newItem);
    }

    @Override
    public Item findItemById(Integer itemId) {
        return itemDao.findItemById(itemId);
    }


    @Override
    public List<Item> findNoIncludedItems() {
        return itemDao.findNoIncludedItems();
    }

    @Override
    public Integer modifyItem(Item modifiedItems) {
        return itemDao.modifyItem(modifiedItems);
    }

    @Override
    public Integer deleteItem(Integer ItemId) {
        return itemDao.deleteItem(ItemId);
    }

    @Override
    public Integer deleteItemByIds(List<Integer> deletedItemsIds) {
        return itemDao.deleteItemsByIds(deletedItemsIds);
    }
}
