/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.DoctorDao;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author This PC
 */
public class DoctorRepository implements IDoctorRepository{
    
    private ArrayList<Doctor> doctors;
    
    public DoctorRepository(){
        doctors= new ArrayList<>();
    }

    @Override
    public void addDoctor() {
        DoctorDao.Instance().createDoctor(doctors);            
    }

   
    @Override
    public void updateDoctor() {
        DoctorDao.Instance().update(doctors);
    }

    @Override
    public void deletedDoctor() {
        DoctorDao.Instance().deleteDoctor(doctors);
    }

    @Override
    public void searchDoctor() {
        DoctorDao.Instance().searchDoctor(doctors);
    }
    
    
    
}
