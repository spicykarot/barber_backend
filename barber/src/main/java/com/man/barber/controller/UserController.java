package com.man.barber.controller;

import com.man.barber.entity.MsUser;
import com.man.barber.model.DTOloginresponse;
import com.man.barber.model.DTOrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.man.barber.model.UserModel;
import com.man.barber.service.UserService;

@RestController
@RequestMapping("/apiUser")
public class UserController {
	
	@Autowired
	private UserService userService ;
	
	@GetMapping("/getUserById/{id}")
	public UserModel getUserAll(@PathVariable Long id) {
		return userService.findUserModelById(id);
	}
	
	@PostMapping("/addUser")
	public Boolean addMainTimesheet(@RequestBody(required = true) UserModel UserModel) {
		return userService.addUser(UserModel);
	}
	
	@PutMapping("/updateUser")
    public Boolean updateMainTimesheet(@RequestBody(required = true) UserModel mainTimesheetModel) {
        return userService.updateUser(mainTimesheetModel);
    }

	@PostMapping("/login")
	public ResponseEntity<DTOloginresponse>  login(@RequestBody DTOrequest request){
		DTOloginresponse response = userService.login(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/registra")
	public ResponseEntity<MsUser>  login(@RequestBody UserModel request){
		MsUser response = userService.save(request);
		return ResponseEntity.ok(response);
	}
}
