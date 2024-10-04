package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class ITouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		//use Repo
		int idVal=touristRepo.save(tourist).getTid();
		return "Tourist is registered with the given id::"+idVal;
	}
	
	@Override
	public List<Tourist> showAllTourist() {
		List<Tourist> list=touristRepo.findAll();
		list.sort((t1,t2)->t1.getTname().compareTo(t2.getTname()));
		return list;

	}
	
	@Override
	public List<Tourist> showAllTourist(String city1, String city2, String city3) {
	     return touristRepo.findTouristByCities(city1, city2, city3);
	}
	
	@Override
	public Tourist findTouristById(Integer id) throws TouristNotFoundException {

		 return touristRepo.findById(id)
				           .orElseThrow(()->new TouristNotFoundException(id+"tourist Not found"));
		 
		 
	}
	
	@Override
	public String updateTouristDetails(Tourist tourist) {
		Optional<Tourist> opt=touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+"tourist is updated";
		}
		else {
			throw new TouristNotFoundException(tourist.getTid()+"tourist is not found for updation");
		}
	}
	
	@Override
	public List<Tourist> showTouristByName(String name) {
		//Use repo
		return touristRepo.fetchTuristByName(name);
		
	}
	
}
