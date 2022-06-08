package ASSIGNMENT_MODELS;

import ASSIGNMENT_INTERFACE.InterfaceEmployee;
import ASSIGNMENT_SERIALIZABLE.SERIALIZABLE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO implements InterfaceEmployee {

    public static List<Employee> lsEmployees = new ArrayList<>();

    @Override
    public int save(Employee e) {
        int position = findByID(e.getId());
        if (position < 0) {
            lsEmployees.add(e);
        } else {
            lsEmployees.set(position, e);
        }
        return 1;
    }

    @Override
    public int del(String id) {
        int position = findByID(id);
        if (position >= 0) {
            lsEmployees.remove(position);
        }
        return position;
    }

    @Override
    public int findByID(String id) {
        int position = -1;
        for (int i = 0; i < lsEmployees.size(); i++) {
            if (lsEmployees.get(i).getId().equals(id)) {
                position = i;
                break;
            }
        }
        return position;
    }

    @Override
    public Employee getEmployeeByPossition(int index) {
        if (index >= 0 && index < lsEmployees.size()) {
            return lsEmployees.get(index);
        }
        return null;
    }

    @Override
    public List<Employee> openFile() {
        lsEmployees.clear();

        try {
            lsEmployees = SERIALIZABLE.readFile();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
//        lsEmployees.add(new Employee("NV001", "A1", 12, "A1.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV002", "A2", 12, "A2.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV003", "A3", 12, "A3.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV004", "A4", 12, "A4.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV005", "A5", 12, "A5.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV006", "A6", 12, "A6.@FPT.EDU.VN", 5000.0));
//        lsEmployees.add(new Employee("NV007", "A7", 12, "A7.@FPT.EDU.VN", 5000.0));
        return lsEmployees;
    }

    @Override
    public void saveFile() {
        try {
            SERIALIZABLE.writeFile(lsEmployees);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
        }
    }

    @Override
    public List<Employee> getAlls() {
        return lsEmployees;
    }

    @Override
    public int count() {
        return lsEmployees.size();
    }

}
