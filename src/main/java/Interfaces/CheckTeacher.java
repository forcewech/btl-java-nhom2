/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Models.NguoiDung;
import Models.NguoiDungDAO;
/**
 *
 * @author thinh
 */
public class CheckTeacher implements CheckRole{

    @Override
    public NguoiDung checkRole(String account, String password) {
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = nguoiDungDAO.findUserByUsername_Password(account, password);
        
        if(nguoiDung.getRole().equals("Manager")) {
            return nguoiDung;
        }
        return null;
    }
    
}
