package ASSIGNMENT_SERIALIZABLE;

import ASSIGNMENT_MODELS.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SERIALIZABLE {
    public static final String FILE_NAME = "employee.dat";
    
    
    public static void writeFile(List<Employee> lstEmployees) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lstEmployees);
        oos.close();
    }
    
    public static List<Employee> readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(FILE_NAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Employee> lstEmployeesIn = new ArrayList<>();
        lstEmployeesIn = (ArrayList<Employee>) ois.readObject();
        return lstEmployeesIn;
    }
}
