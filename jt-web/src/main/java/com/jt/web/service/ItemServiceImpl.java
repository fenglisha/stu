package com.jt.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.service.HttpClientService;
import com.jt.web.pojo.Item;
import com.jt.web.pojo.ItemDesc;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private HttpClientService httpClient;
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	
	//急需发送http请求
	@Override
	public Item findItemById(Long itemId) {
		Item item = null;
		try {
			String url = "http://manage.jt.com/web/item/"+itemId;
			//ItemJSON串
			String result = httpClient.doGet(url);
			item = objectMapper.readValue(result,Item.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}


	@Override
	public ItemDesc findItemDescById(Long itemId) {
		String url = "http://manage.jt.com/web/item/desc/"+itemId;
		ItemDesc itemDesc = null;
		try {
			//JSON串
			String result = httpClient.doGet(url);
			itemDesc = objectMapper.readValue(result,ItemDesc.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemDesc;
	}
	
	
	
	
	
	
	
	

}
