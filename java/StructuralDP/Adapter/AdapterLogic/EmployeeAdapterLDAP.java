package StructuralDP.Adapter.AdapterLogic;

import StructuralDP.Adapter.Employee;
import StructuralDP.Adapter.EmployeeSource.EmployeeLDAP;

/**
 * Created by shalvi on 03/04/16.
 */
public class EmployeeAdapterLDAP implements Employee {

    private EmployeeLDAP instance;

    public EmployeeAdapterLDAP(EmployeeLDAP employeeFromLDAP) {
        this.instance = employeeFromLDAP;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return instance.getSurname();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }

    public String toString(){
        return "ID: "+getId()+"|  Firsname: "+getFirstName()+ " |  Lastname: "+getLastName()+" |  email: "+getEmail();
    }
}
