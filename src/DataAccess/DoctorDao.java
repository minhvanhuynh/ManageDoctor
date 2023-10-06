/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.util.ArrayList;
import model.Doctor;
import view.Validation;

/**
 *
 * @author This PC
 */
public class DoctorDao {
    
    private static DoctorDao instance= null;
    private Validation validation;
    public DoctorDao(){
        validation= new Validation();
    }
    
    public static DoctorDao Instance(){
        if(instance==null){
            synchronized(DoctorDao.class){
                if(instance==null){
                    instance= new DoctorDao();
                }
            }
        }
        return instance;
    }
    
    public void createDoctor(ArrayList<Doctor> doctors){
        System.out.println("-------- Add Doctor --------");
        while(true){
            System.out.print("Enter Code: ");
            String code= validation.checkInputString();
            if(validation.checkIdExist(doctors, code)){
                return;
            }
            System.out.print("Enter Name: ");
            String Name= validation.checkInputString();
            System.out.print("Enter Specialization: ");
            String specialization= validation.checkInputString();            
            int availability= validation.checkInputInt("Enter Availability: ");
            Doctor doctor= new Doctor(code, Name, specialization, availability);
            doctors.add(doctor);
            System.out.println("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen");
            if(!validation.checkInputYesNo()){
                return;
            }
        }
    }
    
    public void update(ArrayList<Doctor> doctors){
        System.out.println("-------- Update Doctor --------");
        System.out.print("Enter code want to update: ");
        String code_find= validation.checkInputString();
        Doctor doctor_find= findCodeDoctor(doctors, code_find);
        if(doctor_find==null){
            System.err.println("Code no exist in list!");
            return;
        }else{
            System.out.println("Please enter information update of doctor.");           
            System.out.println("Enter Name: ");
            String name= validation.checkInputString();
            doctor_find.setName(name);
            System.out.println("Enter Specialization: ");
            String specialization= validation.checkInputString();
            doctor_find.setSpecialization(specialization);            
            int availability= validation.checkInputInt("Enter Availability: ");
            doctor_find.setAvailability(availability);
            System.err.println("Updated successful!");
        }
    }
    
    public Doctor findCodeDoctor(ArrayList<Doctor> doctors, String code){
        Doctor doctor_find=null;
        for (Doctor doctor : doctors) {
            if(doctor.getCode().equalsIgnoreCase(code)){
                doctor_find= doctor;
                break;
            }
        }
        return doctor_find;
    }
    
    public void deleteDoctor(ArrayList<Doctor> doctors){
        System.out.println("-------- Delete Doctor --------");
        System.out.println("Enter code want to delete: ");
        String code_find= validation.checkInputString();
        Doctor doctor_find= findCodeDoctor(doctors, code_find);
        if(doctor_find==null){
            System.err.println("Code no exist in list!");
            return;
        }else{
            doctors.remove(doctor_find);
            System.err.println("Deleted Successful!");
        }
    }
    
    
    public void searchDoctor(ArrayList<Doctor> doctors){
        System.out.println("-------- Search Doctor --------");
        System.out.println("Enter name want to search: ");
        String name_find= validation.checkInputString();
        ArrayList<Doctor> doctor_find= findNameDoctor(doctors, name_find);
        if(doctor_find.isEmpty()){
            System.err.println("No finded name of Doctor");
            return;
        }else{
            System.out.println("----- Result -----");
            display(doctor_find);
        }
    }
    
    public ArrayList<Doctor> findNameDoctor(ArrayList<Doctor> doctors, String name){
        ArrayList<Doctor> doctor_findName= new ArrayList<>();
        for (Doctor doctor : doctors) {
            if(doctor.getName().contains(name)){
                doctor_findName.add(doctor);
            }
        }
        return doctor_findName;        
    }
    
    public void display(ArrayList<Doctor> doctors){
        System.out.println("Code     Name      Specialization      Availability");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }
}
