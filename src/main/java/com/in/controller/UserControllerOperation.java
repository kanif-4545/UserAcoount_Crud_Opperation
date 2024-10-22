package com.in.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Corrected import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in.Model.User;
import com.in.Service.ServiceImpl;


@Controller
public class UserControllerOperation {

    @Autowired
    private ServiceImpl ser;

    @GetMapping("/mini")
    public String showhome(Map<String, Object>map) {
    	map.put("user",new User());    
      return "index";
    }
    
    @PostMapping("/save_user")
    public String handelSubmitButton(@ModelAttribute("user") User user, Model model)
    {
    	String msg= ser.saveorUpdateUserAcc(user);
    	model.addAttribute("msg",msg);
    	model.addAttribute("user", new User());
    	return "index";
    }
    
    
    @GetMapping("/users")
    public String getUser(Model model)
    {
    List<User> userlist=	ser.getAllUserAccount();
     model.addAttribute("users",userlist);
     return "view-users";
    }
    
    
      @GetMapping("/delete")
  public String deleteUser(@RequestParam("id") Integer  userid,Model model)

   {
 	   ser.deleteUserAcc(userid);
 	   model.addAttribute("msg","User Record Deleted");
 	   
  	
      return "forward:/users";
       }
    

@ GetMapping("/edit")
public String editUser( @RequestParam("id") Integer id,Model model)
{
    User useracc= ser.getUserAcc(id);
    model.addAttribute("user",useracc);
	
	return "index";
	}
 @GetMapping("/update")
 public String statusUpdate(@RequestParam("id")  Integer id,
		                    @RequestParam("status") String status, Model model)
 {
	 ser.updateUserAccStatus(id, status);
	 if("y".equals(status))
	 {
		 model.addAttribute("msg", "user Account Activated");
	 }
	 else
	 {
		 model.addAttribute("msg", "user Account De-Activated");
	 }
	 
	 return "forward:/users";
	 
 }
 @GetMapping("/report_page")
 public String showReportByPage(Map<String, Object> map,@PageableDefault(page=0,size=2,sort="userid"
		 ,direction = Sort.Direction.ASC)Pageable pageable)
 {
	 // get requented page data
	 
	 // get service class
	   Page<User> page= ser.getEmpReportByPage(pageable);
	   // keep model at;
	   map.put("pageData", page);
	   // retun
	   return "show_report_page";
	   
 }
}




