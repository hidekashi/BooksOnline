/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.FeedBacks;
import java.util.List;

/**
 *
 * @author Hide
 */
public interface FeedBackDAO {
    public boolean addFeedBack(FeedBacks fb);
    public int getFeedbackRecord();
    public List<FeedBacks> getAllByStatus();
    public List<FeedBacks> getAll(Integer offset, Integer maxResult);
    public boolean del(Integer cateId);
    public boolean update(FeedBacks fb);
    public FeedBacks getFeedBackById(Integer feedBackId);
    public List<FeedBacks> search(String name, Integer offset, Integer maxResult);
    public int getTotalSearch(String name);
}
