package com.in.Service;

import java.awt.print.Pageable;

import java.util.List;
import org.springframework.data.domain.Page;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.Model.User;
import com.in.Repo.UserRepo;


@Service()
public class ServiceImpl implements SerInter{
	
	
	@Autowired
	private UserRepo repo;


	@Override
	public String saveorUpdateUserAcc(User use) 
	{
	  Integer userid=use.getUserid();
	  if(userid ==null)
	  {
		  use.setAccStatus("Y");
	  }
		// UPSERT insert or update mathod 
		 repo.save(use);
		if(userid==null)
		{
			return "User Record Saved";
		}
		else
		{
			return "User Record Updated";
		}
	
	}

	@Override
	public List<User> getAllUserAccount()
	{
		// method to call all user in db
		
			return repo.findAll();
	}
	
	
	@Override
	public User getUserAcc(Integer userid) {
		// to user by id
	Optional<User> findByid=	repo.findById(userid);
	if(findByid.isPresent())
	{
		return findByid.get();
	}
      return null;
      
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		
		// to delete user by id  
		boolean exitsById=repo.existsById(userId);
		if(exitsById)
		{
			repo.deleteById(userId);
			return true;
		}
	
		return false;
	
	}

	@Override
	public boolean updateUserAccStatus(Integer userid, String status) {
		
		
		return false;
	}


	@Override
	public Page<User> getEmpReportByPage(org.springframework.data.domain.Pageable pageable)
	
	{

		return repo.findAll(pageable);
	}

//	@Override
//	public boolean updateUserAccStatus(Integer userid, String status)
//	{
//		repo.updateUserAccStatus(userid, status);
//		
//		return false;
//	}




	

}
