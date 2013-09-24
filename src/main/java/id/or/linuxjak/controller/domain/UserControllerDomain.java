package id.or.linuxjak.controller.domain;

public class UserControllerDomain {

private Long id;
//textbox
private String userName;

//password
private String password;
private String passwordConfirm;

//textbox
private String name;

//textbox
private String lastName;

//areabox
private String address;

//dropbox
private String job;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}


}
