package StructuralDP.Adapter.EmployeeSource;

import StructuralDP.Adapter.Employee;

/**
 * Created by shalvi on 03/04/16.
 */
public class EmployeeDB implements Employee {

    private String id;
    private String firstName;
    private String lastname;
    private String email;

    public EmployeeDB(String id, String firstName, String lastname, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String toString(){
        return "ID: "+getId()+"|  Firsname: "+getFirstName()+ " |  Lastname: "+getLastName()+" |  email: "+getEmail();
    }
}
