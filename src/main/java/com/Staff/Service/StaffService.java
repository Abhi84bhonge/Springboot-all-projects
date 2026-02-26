package com.Staff.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Staff.DAO.StaffRepository;
import com.Staff.Entity.Staff;

@Service
public class StaffService {

	@Autowired
	private StaffRepository srepo;

	public String addallEmployee(Staff stf) {
		if (srepo.addallEmployee(stf)) {
			return "Employee added successfully";
		} else {
			return "Employee not addedd";
		}

	}

	public List<Staff> getstaff() {

		return srepo.getstaff();
	}

	public Staff getstaffbyId(int staffid) {
		return srepo.getstaffbyId(staffid);

	}

	public List<Staff> getsalarymore20k() {
		return srepo.getsalrymore20k();

	}

	public List<Staff> getexpBetween10To20() {
		return srepo.getexpBetween10To20();

	}

	public Staff getMaxSalary() {
		return srepo.getMaxSalary();

	}

	public String updateSalarybyId(double salary, int staffid) {
		boolean res = srepo.updateSalarybyId(salary, staffid);
		if (res) {
			return "Data Updated Successfully!!";
		} else {
			return "Check Id";

		}

	}

	public String getnameMinExp() {
		String name = srepo.getnameMinExp();
		return name;
	}

	public List<Staff> getTrainer() {
		return srepo.getTrainer();
	}

	public List<Staff> notGetTrainer() {
		return srepo.notGetTrainer();
	}

	public Staff getbyname() {
	   return srepo.getbyname();
	}

}
