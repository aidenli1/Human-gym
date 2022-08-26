package com.spring.dao;

import java.util.List;

import com.spring.dto.UserDTO;

public interface UserDAO {

	public void userJoin(UserDTO dto) throws Exception;
	
	public UserDTO userLogin(UserDTO dto) throws Exception;
	
	public UserDTO idCheck(String userID) throws Exception;
	
	public int checkId(String userID) throws Exception;
	
	public List<UserDTO> userList() throws Exception;
	
	public UserDTO userDetail(int userNum) throws Exception;
	
	public  void userUpdate(UserDTO dto) throws Exception;
	
	public void userDelete(int userNum) throws Exception;
	
	public UserDTO findAccount(UserDTO dto) throws Exception;
}
