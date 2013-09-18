package id.or.linuxjak.controller.vm;

import java.util.Date;
import java.util.List;

import id.or.linuxjak.controller.domain.UserControllerDomain;
import id.or.linuxjak.controller.util.DomaintoControllerDomain;
import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zkoss.bind.annotation.NotifyChange;


@Component("manageUserVM")
public class ManageUserVMImpl implements ManageUserVM {

	
	private String username;
	private String name;
	private String password;
	private String passwordConfirm;
	private String lastName;
	private String alamat;
	private String job;
	private Long idUser = null;
	private List<UserControllerDomain> ucd;
	
	@Autowired
	private UserService userService;
	
	
	public void addorUpdate(){
		if(idUser == null){
			addUser();
		}else{
			editUser();
		}
		clearField();
		
	}
	
	public void addUser() {
		// TODO Auto-generated method stub
		
		User usr = new User();
		UserInfo usrInfo = new UserInfo();
		
		usr.setPassword(password);
		usr.setUsername(username);
		
		usrInfo.setAddress(alamat);
		usrInfo.setJob(job);
		usrInfo.setLastName(lastName);
		usrInfo.setListedDate(new Date());
		usrInfo.setName(name);
		usrInfo.setUser(usr);
		
		usr.setUserInfo(usrInfo);
		
	
		userService.create(usr);
		
	
	
	}

	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		userService.delete(userService.findUserbyId(id));
		
		
	}

	public void editPage(Long id) {
		// TODO Auto-generated method stub
		idUser = id;
		User usr =userService.findUserbyId(id);
	
		username = usr.getUsername();
		 name = usr.getUserInfo().getName();
		password = usr.getPassword();
	passwordConfirm = usr.getPassword();
		lastName = usr.getUserInfo().getLastName();
		alamat = usr.getUserInfo().getAddress();
		job = usr.getUserInfo().getJob();
		
	}
	public void editUser(){
		User usr =userService.findUserbyId(idUser);
		UserInfo usrInfo = usr.getUserInfo();
		usr.setPassword(password);
		usr.setUsername(username);
		usr.setUserInfo(usrInfo);
		usrInfo.setAddress(alamat);
		usrInfo.setJob(job);
		usrInfo.setLastName(lastName);
		usrInfo.setUser(usr);
		
		userService.update(usr);
	
	}

	@NotifyChange("ucd")
	public void UserList(){
		  this.ucd = DomaintoControllerDomain.domaintoControllerList(userService.getAll());
	}
	
	
	private void clearField(){
		idUser = null;
		username = null;
		 name = null;
		password = null;
		passwordConfirm = null;
		lastName = null;
		alamat =null;
		job = null;
	}
	
	public List<UserControllerDomain> getUcd() {
		return ucd;
	}

	public void setUcd(List<UserControllerDomain> ucd) {
		this.ucd = ucd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	
	
}
