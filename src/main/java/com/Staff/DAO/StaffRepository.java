package com.Staff.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Staff.Entity.Staff;

@Repository
public class StaffRepository {

	@Autowired
	private SessionFactory sf;

	public boolean addallEmployee(Staff stf) {
		Session sn = sf.openSession();
		sn.beginTransaction();
		sn.save(stf);
		sn.getTransaction().commit();
		sn.close();
		return true;

	}

	public List<Staff> getstaff() {
		Session sn = sf.openSession();
		List<Staff> lt = sn.createQuery("from Staff", Staff.class).list();
		sn.beginTransaction().commit();
		sn.close();
		return lt;

	}

	public Staff getstaffbyId(int staffid) {
		Session sn = sf.openSession();
		Staff stf = sn.get(Staff.class, staffid);
		sn.beginTransaction().commit();
		sn.close();
		return stf;

	}

	public List<Staff> getsalrymore20k() {
		Session sn = sf.openSession();
		Criteria ct = sn.createCriteria(Staff.class);
		ct.add(Restrictions.gt("salary", 20000.0));

		List<Staff> lt = ct.list();
		sn.beginTransaction().commit();
		sn.close();
		return lt;
	}

	public List<Staff> getexpBetween10To20() {
		Session sn = sf.openSession();
		Criteria ct = sn.createCriteria(Staff.class);
		ct.add(Restrictions.between("experience", 10, 20));
		List<Staff> lt = ct.list();
		sn.beginTransaction().commit();
		sn.close();
		return lt;

	}

	public Staff getMaxSalary() {
		Session sn = sf.openSession();

		Double maxsalary = (Double) sn.createCriteria(Staff.class).setProjection(Projections.max("salary"))
				.uniqueResult();
		Criteria ct1 = sn.createCriteria(Staff.class);
		ct1.add(Restrictions.eq("salary", maxsalary));
		Staff staff = (Staff) ct1.uniqueResult();
		sn.beginTransaction().commit();
		sn.close();
		return staff;
	}

	
	public boolean updateSalarybyId(double salary, int staffid) {
		Session sn = sf.openSession();
		sn.beginTransaction();

		Staff st = sn.get(Staff.class, staffid);

		if (st == null) {
			sn.getTransaction().rollback();
			sn.close();
			return false; // staff not found
		}

		st.setSalary(salary); // update salary
		sn.update(st); // save changes

		sn.getTransaction().commit();
		sn.close();
		return true;
	}

	public String getnameMinExp() {
		Session sn = sf.openSession();
		Criteria ct = sn.createCriteria(Staff.class);
		Integer minexp = (Integer) ct.setProjection(Projections.min("experience")).uniqueResult();

		Criteria ct1 = sn.createCriteria(Staff.class);
		ct1.add(Restrictions.eq("experience", minexp));
		String name = (String) ct1.setProjection(Projections.projectionList().add(Projections.property("name")))
				.uniqueResult();
		return name;
	}

	public List<Staff> getTrainer() {
		Session sn = sf.openSession();
		Criteria ct = sn.createCriteria(Staff.class);
		ct.add(Restrictions.eq("profile", "trainer"));
		List<Staff> lt = ct.list();
		return lt;
	}

	public List<Staff> notGetTrainer() {
		Session sn = sf.openSession();
		Criteria ct = sn.createCriteria(Staff.class);
		ct.add(Restrictions.ne("profile", "trainer"));
		List<Staff> lt = ct.list();
		return lt;
	}

	public Staff getbyname() {
	Session sn=sf.openSession();
	 Criteria ct=sn.createCriteria(Staff.class);
     ct.add(Restrictions.eq("name","Kiran"));
	 Staff stf=(Staff)ct.uniqueResult();
     
     return stf;
	}

}
