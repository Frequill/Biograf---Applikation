package basePackage.jpmnbackend;

import basePackage.Service.*;
import basePackage.Service.ShiftService;
import basePackage.dataBaseClasses.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan(basePackages = "basePackage")



@RestController
public class JpmnBackendApplication {


    public static ApplicationContext context;

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    ScreeningService screeningService;

    @Autowired
    SaloonService saloonService;

    @Autowired
    ShiftService shiftService;


    
    public static void main(String[] args) {
        context = SpringApplication.run(JpmnBackendApplication.class, args);
    }



    // All endpoints for Frontend-Backend connectivity:


    @GetMapping ("/hello")
    public String testConnection(@RequestParam(value = "name", defaultValue = "error") String name){
        ThreadsAreCool helloThread = new ThreadsAreCool();
        helloThread.start();

        name = "The connection " + name;

        try {helloThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return name;
    }


    @GetMapping ("/getStaffByID")
    public String getStaffById(@RequestParam(value = "staff_ID", defaultValue = "incorrect input") String staff_id){
        ThreadsAreCool getStaffIDThread = new ThreadsAreCool();
        getStaffIDThread.start();

        StaffService staffService = context.getBean(StaffService.class);
        staff_id = String.valueOf(staffService.getStaffById(Integer.parseInt(staff_id)));

        try {getStaffIDThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return staff_id;
    }


    @GetMapping ("/getAllStaff")
    public String getAllStaff(){
        ThreadsAreCool getAllStaffThread = new ThreadsAreCool();
        getAllStaffThread.start();

        ArrayList allStaff = staffService.getAllStaff();

        ArrayList<String> allStaffString = new ArrayList<>();

        for (int i = 0; i < allStaff.size(); i++){
            allStaffString.add(allStaff.get(i).toString());
        }

        String returnable = allStaffString.toString();

        System.out.println("TEST\n" + returnable);

        try {getAllStaffThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @GetMapping("/addStaff")
    public String addStaff(@RequestParam(value = "valuesAsCSV", defaultValue = "Incomplete statement") String valuesAsCSV){
        ThreadsAreCool addStaffThread = new ThreadsAreCool();
        addStaffThread.start();

        String[] separatedValuesStaff = valuesAsCSV.split(",");

        Staff staff = new Staff(separatedValuesStaff[1], separatedValuesStaff[2], separatedValuesStaff[3], separatedValuesStaff[4], separatedValuesStaff[5]);
        StaffService staffService = context.getBean(StaffService.class);
        staffService.insertStaff(staff);

        try {addStaffThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return staff.toString();
    }


    @DeleteMapping ("/deleteStaffById")
    public void deleteStaffById(@RequestParam(value = "s_ID", defaultValue = "incorrect input") String staff_id) {
        ThreadsAreCool deleteStaffByIdThread = new ThreadsAreCool();
        deleteStaffByIdThread.start();

        staffService.deleteStaff(staff_id);

        try {deleteStaffByIdThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @GetMapping ("/getAllScreenings")
    public String getAllScreenings(){
        ThreadsAreCool getAllScreeningsThread = new ThreadsAreCool();
        getAllScreeningsThread.start();

        ScreeningService screeningService = context.getBean(ScreeningService.class);
        ArrayList allScreenings = screeningService.getAllScreenings();

        ArrayList<String> allScreeningsString = new ArrayList<>();

        for (int i = 0; i < allScreenings.size(); i++){
            allScreeningsString.add(allScreenings.get(i).toString());
        }

        String returnable = allScreeningsString.toString();

        System.out.println("TEST\n" + returnable);

        try {getAllScreeningsThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @RequestMapping ("/addScreening")
    public void addScreening(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        ThreadsAreCool addScreeningThread = new ThreadsAreCool();

        String[] separatedValues = valuesAsCSV.split(",");

        screeningService.addScreening(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]);

        try {addScreeningThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @DeleteMapping ("deleteScreeningById")
    public void deleteScreeningById(@RequestParam(value = "movie_ID", defaultValue = "incorrect input") String movie_ID) {
        ThreadsAreCool deleteScreeningByIdThread = new ThreadsAreCool();
        deleteScreeningByIdThread.start();

        screeningService.deleteScreeningById(movie_ID);

        try {deleteScreeningByIdThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @RequestMapping("/addSaloon")
    public void AddSaloon(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String values){
        ThreadsAreCool addSaloonThread = new ThreadsAreCool();
        addSaloonThread.start();

        String[] separatedValues = values.split(",");

        saloonService.addSaloon(separatedValues[1], separatedValues[2]);

        try {addSaloonThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @DeleteMapping ("/deleteSaloonByID")
    public void deleteSaloonById(@RequestParam(value = "saloon_ID", defaultValue = "incorrect input") String saloon_id) {
        ThreadsAreCool deleteSaloonByIdThread = new ThreadsAreCool();
        deleteSaloonByIdThread.start();

        saloonService.deleteSaloon(saloon_id);

        try {deleteSaloonByIdThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @GetMapping ("/getAllSaloons")
    public String getAllSaloons(){
        ThreadsAreCool getAllSaloonsThread = new ThreadsAreCool();
        getAllSaloonsThread.start();

        StaffService staffService = context.getBean(StaffService.class);
        SaloonService saloonService = context.getBean(SaloonService.class);
        ArrayList allSaloons = saloonService.getAllSaloons();

        ArrayList<String> allSaloonsString = new ArrayList<>();

        for (int i = 0; i < allSaloons.size(); i++){
            allSaloonsString.add(allSaloons.get(i).toString());
        }

        String returnable = allSaloonsString.toString();

        System.out.println("TEST\n" + returnable);

        try {getAllSaloonsThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @DeleteMapping ("/deleteShiftByID")
    public void deleteShiftById(@RequestParam(value = "shift_ID", defaultValue = "incorrect input") String shift_id) {
        ThreadsAreCool deleteShiftByIdThread = new ThreadsAreCool();
        deleteShiftByIdThread.start();

        shiftService.deleteShift(shift_id);

        try {deleteShiftByIdThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @RequestMapping ("/addShift")
    public void addShift(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        ThreadsAreCool addStaffThread = new ThreadsAreCool();
        addStaffThread.start();

        String[] separatedValues = valuesAsCSV.split(",");

        shiftService.addShift(separatedValues[1], separatedValues[2], separatedValues[3]);

        try {addStaffThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @GetMapping ("/getAllShifts")
    public String getAllShifts(){
        ThreadsAreCool getAllShiftThread = new ThreadsAreCool();
        getAllShiftThread.start();

        ShiftService shiftService = context.getBean(ShiftService.class);

        ArrayList allShifts = shiftService.getAllShifts();

        ArrayList<String> allShiftsString = new ArrayList<>();

        for (int i = 0; i < allShifts.size(); i++){
            allShiftsString.add(allShifts.get(i).toString());
        }

        String returnable = allShiftsString.toString();

        System.out.println("TEST\n" + returnable);

        try {getAllShiftThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @RequestMapping ("/addCustomer")
    public void addCustomer(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        ThreadsAreCool addCustomerThread = new ThreadsAreCool();
        addCustomerThread.start();

        String[] separatedValues = valuesAsCSV.split(",");

        customerService.addCustomer(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]);

        try {addCustomerThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @RequestMapping ("/verify_customer")
    public void customerLogin(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        ThreadsAreCool customerLoginThread = new ThreadsAreCool();
        customerLoginThread.start();

        String[] separatedValues = valuesAsCSV.split(",");

        customerService.customerLogin(separatedValues[1], separatedValues[2]);

        try {customerLoginThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @RequestMapping("/getLastValidationNumber")
    public String getValidationNumber(){
        ThreadsAreCool getValidationNumberThread = new ThreadsAreCool();
        getValidationNumberThread.start();

        String returnable = customerService.getValidationNumber();

        try {getValidationNumberThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @RequestMapping ("/getUser_ID")
    public String getCustomerIDByEmail(@RequestParam(value = "userEmailAddress", defaultValue = "incorrect input") String email){
        ThreadsAreCool getCustomerIDByEmailThread = new ThreadsAreCool();
        getCustomerIDByEmailThread.start();

        System.out.println("HOHOHO" + email);
        String returnable = customerService.getCustomerIDByEmail(email);

        try {getCustomerIDByEmailThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @RequestMapping ("/getMyBookings")
    public String getMyBookings(@RequestParam(value = "user_ID", defaultValue = "incorrect input") String user_ID){
        ThreadsAreCool getMyBookingsThread = new ThreadsAreCool();
        getMyBookingsThread.start();

        System.out.println("HOHOHO" + user_ID);
        String returnable = customerService.getMyBookings(user_ID);

        try {getMyBookingsThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return returnable;
    }


    @RequestMapping ("/bookTickets")
    public void bookTickets(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
        ThreadsAreCool bookTicketsThread = new ThreadsAreCool();
        bookTicketsThread.start();

        String[] splitValues = valuesAsCSV.split(",");

        customerService.bookTickets(splitValues[1], splitValues[2], splitValues[3]);

        try {bookTicketsThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @DeleteMapping ("/deleteOrderByID")
    public String deleteOrderById(@RequestParam(value = "orderID", defaultValue = "incorrect input") String orderID) {
        ThreadsAreCool deleteOrderByIdThread = new ThreadsAreCool();
        deleteOrderByIdThread.start();

        String neededInfo = customerService.deleteOrder(orderID);

        try {deleteOrderByIdThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return neededInfo;
    }


    @RequestMapping ("/restoreTickets")
    public void restoreTickets(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV) {
        ThreadsAreCool restoreTicketsThread = new ThreadsAreCool();
        restoreTicketsThread.start();

        String[] splitValues = valuesAsCSV.split(",");
        screeningService.restoreTickets(splitValues[1], splitValues[2]);

        try {restoreTicketsThread.join();} catch (InterruptedException e) {e.printStackTrace();}
    }


    @RequestMapping ("/compareCustomerEmail")
    public String compareCustomerEmail(@RequestParam(value = "email", defaultValue = "incorrect input") String email) {
        ThreadsAreCool compareCustomerEmailThread = new ThreadsAreCool();
        compareCustomerEmailThread.start();

        String answer = customerService.compareCustomerEmail(email);

        try {compareCustomerEmailThread.join();} catch (InterruptedException e) {e.printStackTrace();}
        return answer;
    }


}