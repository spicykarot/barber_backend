package com.man.barber.service;

import java.util.List;
import java.util.Optional;

import com.man.barber.model.DTOloginresponse;
import com.man.barber.model.DTOrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.barber.entity.MsUser;
import com.man.barber.model.UserModel;
import com.man.barber.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private final TokenService tokenService;
	@Autowired
	PasswordEncoder passwordEncoder;

	public UserService(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	public List<MsUser> findUserAll() {
		return userRepository.findAll();
	}

	public MsUser findUserById(long id) {
		return userRepository.findById(id).get();
	}

	public UserModel findUserModelById(Long id) {
		MsUser userTb = userRepository.getById(id);

		UserModel userModel = new UserModel();
		userModel.setId(userTb.getId());
		userModel.setTitle(userTb.getTitle());
		userModel.setFirstName(userTb.getFirstName());
		userModel.setLastName(userTb.getLastName());
		userModel.setEmail(userTb.getEmail());
		userModel.setPassword(userTb.getPassword());
		userModel.setTel(userTb.getTel());
		userModel.setAddress(userTb.getAddress());
		userModel.setUser_type(userTb.getUser_type());

		return userModel;
	}

	public Boolean addUser(UserModel userModel) {
		MsUser userTb = new MsUser();
		Boolean result = false;
		try {

			userTb.setId(userModel.getId());
			userTb.setTitle(userModel.getTitle());
			userTb.setFirstName(userModel.getFirstName());
			userTb.setLastName(userModel.getLastName());
			userTb.setEmail(userModel.getEmail());
			userTb.setPassword(userModel.getPassword());
			userTb.setTel(userModel.getTel());
			userTb.setAddress(userModel.getAddress());
			userTb.setUser_type(userModel.getUser_type());

			userTb = userRepository.save(userTb);

			if (userTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateUser(UserModel userModel) {
		Boolean result = false;
		try {
			MsUser userTb = userRepository.getById(userModel.getId());
			if (userTb != null) {
				if (!ObjectUtils.isEmpty(userModel.getTitle())) {
					userTb.setTitle(userModel.getTitle());
				}
				if (!ObjectUtils.isEmpty(userModel.getFirstName())) {
					userTb.setFirstName(userModel.getFirstName());
				}
				if (!ObjectUtils.isEmpty(userModel.getLastName())) {
					userTb.setLastName(userModel.getLastName());
				}
				if (!ObjectUtils.isEmpty(userModel.getEmail())) {
					userTb.setEmail(userModel.getEmail());
				}
				if (!ObjectUtils.isEmpty(userModel.getPassword())) {
					userTb.setPassword(userModel.getPassword());
				}
				if (!ObjectUtils.isEmpty(userModel.getTel())) {
					userTb.setTel(userModel.getTel());
				}
				if (!ObjectUtils.isEmpty(userModel.getAddress())) {
					userTb.setAddress(userModel.getAddress());
				}
				if (!ObjectUtils.isEmpty(userModel.getUser_type())) {
					userTb.setUser_type(userModel.getUser_type());
				}

				userTb = userRepository.save(userTb);
				if (userTb != null) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public MsUser save(UserModel userModel) {
		MsUser user = new MsUser();
		user.setTitle(userModel.getTitle());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setTel(userModel.getTel());
		user.setAddress(userModel.getAddress());
		user.setUser_type(userModel.getUser_type());
		return userRepository.save(user);
	}

	public boolean check_encode(String rawPassword, String encodedPassword){
		return passwordEncoder.matches(rawPassword,encodedPassword);
	}

	public DTOloginresponse login(DTOrequest request){
		Optional<MsUser> optional = userRepository.findByEmail(request.getEmail());
		if(optional.isEmpty()){
			//throw
		}
		MsUser user = optional.get();
		if(!check_encode(request.getPassword(), user.getPassword())){
			//throw
		}
		DTOloginresponse response = new DTOloginresponse();
		response.setToken(tokenService.crecte(user));
		return response;
	}

}
