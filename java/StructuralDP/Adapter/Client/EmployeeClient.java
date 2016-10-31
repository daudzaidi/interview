package StructuralDP.Adapter.Client;

import StructuralDP.Adapter.AdapterLogic.EmployeeAdapterCSV;
import StructuralDP.Adapter.AdapterLogic.EmployeeAdapterLDAP;
import StructuralDP.Adapter.Employee;
import StructuralDP.Adapter.EmployeeSource.EmployeeCSV;
import StructuralDP.Adapter.EmployeeSource.EmployeeDB;
import StructuralDP.Adapter.EmployeeSource.EmployeeLDAP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalvi on 03/04/16.
 */
public class EmployeeClient {

    public List<Employee> getEmployeeList(){
        List<Employee> employees = new ArrayList<>();

        //Employee list from DB
        Employee employeeFromDB = new EmployeeDB("1234","Shalvi","Pandita","shalvipandita@gmail.com");
        employees.add(employeeFromDB);

        //Employee List from LDAP
        EmployeeLDAP employeeFromLDAP = new EmployeeLDAP("2345","Sunita","Pandita","sunitapandita75@gmail.com");
        employees.add(new EmployeeAdapterLDAP(employeeFromLDAP));

        //Employee from CSV
        EmployeeCSV employeeFromCSV = new EmployeeCSV("5678,Shyam,Pandita,shyampandita@hotmail.com");
        employees.add(new EmployeeAdapterCSV(employeeFromCSV));
        return employees;
    }

}
