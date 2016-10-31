package StructuralDP.Adapter;

import StructuralDP.Adapter.Client.EmployeeClient;

import java.util.List;

/**
 * Created by shalvi on 03/04/16.
 */
public class AdapterDemo {

    public static void main(String [] args) {
        EmployeeClient client = new EmployeeClient();
        List<Employee> employees = client.getEmployeeList();
        System.out.println(employees);
    }
}
