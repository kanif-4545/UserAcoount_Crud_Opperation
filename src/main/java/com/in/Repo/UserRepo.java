package com.in.Repo;

import java.awt.print.Pageable;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.in.Model.User;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Integer> {

	
//
//    @Modifying
//   @Transactional
//   @Query("UPDATE user_info set  accStatus =:status WHERE userid = :userId")
//     public void updateUserAccStatus(Integer userid, String status);

	

}
