package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> showAllTourist();
	public List<Tourist> showAllTourist(String city1,String city2,String city3);
	public Tourist findTouristById(Integer id)throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist);
	public List<Tourist> showTouristByName(String name);
}
