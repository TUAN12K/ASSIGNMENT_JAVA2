package ASSIGNMENT_INTERFACE;

import ASSIGNMENT_MODELS.Employee;
import java.util.List;


public interface InterfaceEmployee {
    int save(Employee e);
    int del(String id);
    int findByID(String id);
    Employee getEmployeeByPossition(int index);
    List<Employee> openFile();
    void saveFile();
    List<Employee> getAlls();
    int count();
}
