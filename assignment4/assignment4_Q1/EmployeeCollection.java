package assignment4_Q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeCollection {
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	
	/**
	 * To add an employee to the employeeList
	 * @param emp
	 * 		Employee object to be added
	 * @return boolean
	 * 		if employee is added then true otherwise false
	 */
	public boolean addEmployee(Employee emp){
		for(int index = 0; index<employeeList.size(); index++){
			if(employeeList.get(index).getEmpId()==emp.getEmpId())
				return false;
		}
		employeeList.add(emp);
		return true;
		
	}
	
	/**
	 * Sort the Employee List by their ID.
	 */
	public void sortByEmpId(){
		Comparator<Employee> idComparator = new Comparator<Employee>() {
			public int compare(Employee empOne, Employee empTwo){
				if(empOne.getEmpId()>=empTwo.getEmpId()){
					return 1;
				}else{
					return -1;
				}
			}
		};
		Collections.sort(employeeList, idComparator);
	}
	
	/**
	 * Sort the employee list by their names.
	 */
	public void sortByEmpName(){
		Comparator<Employee> idComparator = new Comparator<Employee>() {
			public int compare(Employee empOne, Employee empTwo){
				return empOne.getName().compareTo(empTwo.getName());
			}
		};
		Collections.sort(employeeList, idComparator);
	}
	
	
	/**
	 * Display all the employees present in the employee list.
	 */
	public void displayEmployees(){
		for(int index = 0; index<employeeList.size(); index++){
			employeeList.get(index).print();
		}
	}
}
