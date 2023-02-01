import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private String code;
    private String name;
    private String peripheralType;
    private String employeeName;


    Main(String code, String name, String peripheralType, String employeeName) {
        this.code = code;
        this.name = name;
        this.peripheralType = peripheralType;
        this.employeeName = employeeName;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getPeripheral() {
        return this.peripheralType;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }
    static int id = 0001;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Main> records = new ArrayList<>();

        boolean loop = true;

        do {
            System.out.println("""
                    Choose an option:
                    a. Create a Record
                    b. Display Records
                    c. Edit Record
                    d. Delete Record
                    e. Show Report
                    f. Exit
                    """);
            System.out.print("Enter: ");
            char condition = in.next().charAt(0);

            switch (condition) {
                case 'a':
                    System.out.print("Enter name: ");
                    String name = in.next();
                    System.out.print("Enter peripheral: ");
                    String peripheral = in.next();

                    in.nextLine();
                    System.out.print("Employee Name or leave blank: ");
                    String employee = in.nextLine();


                    if (employee.isEmpty()) {
                        employee = "unassigned";
                    }



                    Iterator iterate = records.iterator();
                    if (iterate.hasNext()) {
                        id++;
                    }

                    String code = "2023" + String.format("%04d", id);

                    Main record = new Main(code, name, peripheral, employee);
                    records.add(record);

                    break;
                case 'b':

                    System.out.println("a. View all peripherals");
                    System.out.println("b. View available peripherals");
                    System.out.println("c. View not available peripherals");
                    System.out.println("d. View all input devices");
                    System.out.println("e. View all output devices");
                    System.out.println("f. View all input/output devices");
                    System.out.println("g. View all employees");

                    System.out.println("Enter your choice : ");
                    String userPick = in.next();
                    for (var _record : records){
                        switch(userPick){
                            case "a":
                                System.out.println("----------------------------------------------");
                                System.out.println("Code: " + _record.getCode());
                                System.out.println("Peripheral: " + _record.getName());
                                System.out.println("Peripheral Type: " + _record.getPeripheral());
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");
                                break;
                            case "b":
                                System.out.println("----------------------------------------------");
                                if (_record.getEmployeeName().equals("unassigned")){
                                System.out.println("Code: " + _record.getCode());
                                System.out.println("Peripheral: " + _record.getName());
                                System.out.println("Peripheral Type: " + _record.getPeripheral());
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");}
                                break;
                            case "c":
                                System.out.println("----------------------------------------------");
                                if (!_record.getEmployeeName().equals("unassigned")) {
                                    System.out.println("Code: " + _record.getCode());
                                    System.out.println("Peripheral: " + _record.getName());
                                    System.out.println("Peripheral Type: " + _record.getPeripheral());
                                    System.out.println("Employee: " + _record.getEmployeeName());
                                    System.out.println("----------------------------------------------");
                                }
                                break;
                            case "d":
                                System.out.println("----------------------------------------------");
                                if (_record.getPeripheral().equals("input")){
                                    System.out.println("Code: " + _record.getCode());
                                System.out.println("Peripheral: " + _record.getName());
                                System.out.println("Peripheral Type: " + _record.getPeripheral());
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");}
                                break;
                            case "e":
                                System.out.println("----------------------------------------------");
                                if (_record.getPeripheral().equals("output")){
                                    System.out.println("Code: " + _record.getCode());
                                System.out.println("Peripheral: " + _record.getName());
                                System.out.println("Peripheral Type: " + _record.getPeripheral());
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");}
                                break;
                            case "f":

                                System.out.println("----------------------------------------------");
                                if (_record.getPeripheral().equals("input/output")){
                                    System.out.println("Code: " + _record.getCode());
                                System.out.println("Peripheral: " + _record.getName());
                                System.out.println("Peripheral Type: " + _record.getPeripheral());
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");}
                                break;
                            case "g":
                                if(!_record.getEmployeeName().equals("unassigned")){
                                System.out.println("----------------------------------------------");
                                System.out.println("Employee: " + _record.getEmployeeName());
                                System.out.println("----------------------------------------------");}
                                break;
                        }
                    }

                    break;
                case 'c':
                    System.out.println("Enter Id");
                    String idcode = in.next();
                    int index = 0;
                    for (var list : records) {
                        if (idcode.equals(list.getCode())) {
                            if (list.getEmployeeName().equals("unassigned")) {

                                System.out.println("Enter newName : ");
                                String newPeripheralName = in.next();
                                System.out.println("Enter newPeripheralType : ");
                                String newPeripheralType = in.next();
                                System.out.println("Enter newEmployee: ");
                                String newEmployee = in.next();

                                System.out.println(newPeripheralName);
                                System.out.println(newPeripheralType);
                                System.out.println(newEmployee);

                                Main newObject = new Main(list.getCode(), newPeripheralName, newPeripheralType, newEmployee);
                                records.set(index, newObject);


                            } else {

                                System.out.println("It has been already assigned");

                            }

                        }
                        index++;
                    }


                    break;
                case 'd':
                    int i = 0;
                    System.out.println("Enter Peripheral Code : ");
                    String deleteid = in.next();
                    try {
                        for (var list : records){
                            if (deleteid.equals(list.getCode())){
                                records.remove( i );
                                System.out.println("deleted successfully");

                            }
                            i++;

                        }


                    }catch (Exception e){

                    }


                    System.out.println();
                    break;
                case 'e':
                    int availablePeripherals = 0, assignedPeripherals = 0, inputDevices = 0, outputDevices = 0, employees = 0;
                    System.out.println("a. Number of available peripherals");
                    System.out.println("b. Number of assigned peripherals");
                    System.out.println("c. Number of input device");
                    System.out.println("d. Number of output device");
                    System.out.println("e. Number of employees with peripherals assigned");

                    String choice = in.next();
                    for (var _record : records){
                        if (_record.getEmployeeName().equals("unassigned")){
                            availablePeripherals++;
                        }else if(!_record.getEmployeeName().equals("unassigned")){
                            assignedPeripherals++;
                        }else if(_record.getPeripheral().equals("input")){
                            inputDevices++;
                        }else if(_record.getPeripheral().equals("output")){
                            outputDevices++;
                        } else if (!_record.getEmployeeName().equals("unassigned")) {
                            employees++;
                        }
                    }

                    if (choice.equals("a")){
                        System.out.println("Number of available peripherals :" + availablePeripherals);
                    }else if(choice.equals("b")){
                        System.out.println("Number of assigned peripherals :" + assignedPeripherals);
                    }else if(choice.equals("c")){
                        System.out.println("Number of assigned peripherals :" + inputDevices);
                    }
                    else if(choice.equals("d")){
                        System.out.println("Number of assigned peripherals :" + outputDevices);
                    }
                    else if(choice.equals("e")){
                        System.out.println("Number of employees with peripherals assigned :" + employees);
                    }

                    break;
                case 'f':
                    loop = false;
                    System.out.println("Program Terminated");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + condition);
            }
        }
        while (loop);
    }


}
