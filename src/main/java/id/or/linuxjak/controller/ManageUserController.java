package id.or.linuxjak.controller;

import id.or.linuxjak.controller.domain.UserControllerDomain;
import id.or.linuxjak.controller.util.DomainControllertoDomain;
import id.or.linuxjak.controller.vm.ManageUserVM;
import id.or.linuxjak.controller.vm.ManageUserVMImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.CollectionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;


@Controller("manageUserController")
@Scope("prototype")
public class ManageUserController {

	private List<String> job = new  ArrayList<String>();
	
	@Autowired
	private ManageUserVM manageUserVM;
	
	
	@Init
	public void init(){
		
		job.add("Pelajar");
		job.add("Karyawan");
		job.add("Wirausaha");
		
		manageUserVM.UserList();
	}
	
	@Command
	@NotifyChange("manageUserVM")
	public void add(){
		manageUserVM.addorUpdate();
		manageUserVM.UserList();
	}
	
	@Command
	@NotifyChange("manageUserVM")
	public void delete(@BindingParam("item") Long id){
		System.out.println(id);
		manageUserVM.deleteUser(id);
		manageUserVM.UserList();
	}
	
	@Command
	@NotifyChange("manageUserVM")
	public void edit(@BindingParam("item") Long id){
		manageUserVM.editPage(id);
		manageUserVM.UserList();
	}
	
	@Command
	@NotifyChange("manageUserVM")
	public void editUser(){
		manageUserVM.editUser();
		manageUserVM.UserList();
	}
	public List<String> getJob() {
		return job;
	}


	public void setJob(List<String> job) {
		this.job = job;
	}


	public ManageUserVM getManageUserVM() {
		return manageUserVM;
	}


	public void setManageUserVM(ManageUserVM manageUserVM) {
		this.manageUserVM = manageUserVM;
	}
	
	
	
	
}
