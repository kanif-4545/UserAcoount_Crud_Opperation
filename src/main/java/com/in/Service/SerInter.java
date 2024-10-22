package com.in.Service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.in.Model.User;


public interface SerInter {
	
	public  String saveorUpdateUserAcc(User use);
	public List<User> getAllUserAccount();
	public User getUserAcc(Integer userid);
	
	public boolean deleteUserAcc(Integer userId);
	public boolean updateUserAccStatus(Integer userid,String status);
	public Page<User> getEmpReportByPage(Pageable pageable); 

	

}
