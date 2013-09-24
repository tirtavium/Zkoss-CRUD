package id.or.linuxjak.controller.vm;

import id.or.linuxjak.domain.User;

public interface ManageUserVM {
	
	void addUser();
	void deleteUser(Long id);
	void editPage(Long id);
	void UserList();
	void editUser();
	void addorUpdate();
	void printPDF();
}
