/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categories;
import entities.EmailRegistereds;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface EmailRegisteredDAO {
    public boolean addEmail(EmailRegistereds em);
    public int getEmailRegisteredRecord();
    public List<EmailRegistereds> getAllByStatus();
    public List<EmailRegistereds> getAll(Integer offset, Integer maxResult);
    public boolean del(Integer emId);
    public boolean update(EmailRegistereds em);
}
