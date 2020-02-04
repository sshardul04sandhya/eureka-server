package com.redis.repo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.model.Item;

import java.io.Serializable;
import java.util.Map;

@Repository
public class ItemRepository{

    public static final String KEY = "Product";
    private RedisTemplate<String,Item> redisTemplate;
    private HashOperations hashOperations;
    

    public ItemRepository(RedisTemplate<String, Item> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Cacheable("listItems")
    public Map<Integer,Item> getAllItems(){
        return hashOperations.entries(KEY);
    }
    
    @Cacheable("item")
    public Item getItem(int itemId){
        return (Item) hashOperations.get(KEY,itemId);
    }

    
    public void addItem(Item item){
        hashOperations.put(KEY,item.getId(),item);
    }
    
    
    public void deleteItem(int id){
        hashOperations.delete(KEY,id);
    }

    
    public void updateItem(Item item){
        addItem(item);
    }
}
