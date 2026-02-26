package com.Staff.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Staff.Entity.Staff;
import com.Staff.Service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService serv;

	@PostMapping("/addstaff")
	public String addallEmployee(@RequestBody Staff stf) {
		serv.addallEmployee(stf);
		return " add employee successfully ";
	}

	@GetMapping("/getmsg")
	public String getmds() {
		return "hello";
	}

	@GetMapping("/getallstaff")
	public List<Staff> getstaff() {
		List<Staff> lt = serv.getstaff();
		for (Staff staff : lt) {
			System.out.println(staff);
		}
		return lt;
	}

	@GetMapping("/getstaffbyId/{staffid}")
	public String getstaffbyId(@PathVariable int staffid) {
		Staff sf = serv.getstaffbyId(staffid);
		System.out.println(sf);
		return sf + " get employee by id successfully";
	}

	@GetMapping("/staffsalaryMore20k")
	public List<Staff> getsalarymore20k() {
		List<Staff> lt = serv.getsalarymore20k();
		for (Staff staff : lt) {
			System.out.println(staff);
		}
		return lt;
	}

	@GetMapping("/expBetween10to20")
	public List<Staff> getexpBetween10To20() {
		List<Staff> lt = serv.getexpBetween10To20();
		for (Staff staff : lt) {
			System.out.println(staff);
		}
		return lt;
	}

	@GetMapping("/getMaxSalary")
	public Staff getMaxSalary() {
		Staff lt = serv.getMaxSalary();
		System.out.println(lt);
		return lt;
	}

	@PutMapping("/updataById/{salary}/{staffid}")
	public String updateSalarybyId(@PathVariable double salary, @PathVariable int staffid) {
		String msg = serv.updateSalarybyId(salary, staffid);
		System.out.println(msg);
		return msg;
	}

	@GetMapping("/getMinExp")
	public String getnameMinExp() {
		String name = serv.getnameMinExp();
		return name + " Minimum Experience Staff";
	}

	@GetMapping("/getTrainer")
	public List<Staff> getTrainer() {
		return serv.getTrainer();
	}

	@GetMapping("/notgetProfileTrainer")
	public List<Staff> notGetTrainer() {
		return serv.notGetTrainer();
	}
	
	
	@GetMapping("/getbyName")
	public Staff getbyname() {
		Staff stf= serv.getbyname();
		return stf;
	}
}
