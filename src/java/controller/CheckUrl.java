/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Hide
 */
public class CheckUrl {
    public static boolean check(HttpSession session){
        if(session.getAttribute("admin") != null){
            return true;
        }else {
            return false;
        }
    }
    
    public static boolean checkCus(HttpSession session){
        if(session.getAttribute("account") != null){
            return true;
        }else {
            return false;
        }
    }
}
