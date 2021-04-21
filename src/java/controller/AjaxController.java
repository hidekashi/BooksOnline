/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.QuanHuyenDAOImpl;
import dao.XaPhuongDAOImpl;
import entities.DevvnQuanhuyen;
import entities.DevvnQuanhuyenForJSon;
import entities.DevvnXaphuongthitran;
import entities.DevvnXaphuongthitranForJson;
import entities.Products;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Hide
 */
@Controller
@RequestMapping(value = "/clientAjax")
public class AjaxController {

    private QuanHuyenDAOImpl quanHuyenDAOImpl;
    private XaPhuongDAOImpl xaPhuongDAOImpl;

    @Autowired
    public void setQuanHuyenDAOImpl(QuanHuyenDAOImpl quanHuyenDAOImpl) {
        this.quanHuyenDAOImpl = quanHuyenDAOImpl;
    }

    @Autowired
    public void setXaPhuongDAOImpl(XaPhuongDAOImpl xaPhuongDAOImpl) {
        this.xaPhuongDAOImpl = xaPhuongDAOImpl;
    }

    //produces = "application/json;chartset=UTF-8"
    //produces = "application/x-www-form-urlencoded;charset=UTF-8"
    @RequestMapping(value = "/loadQuanHuyen", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> loadQuanHuyen(HttpServletRequest request, HttpServletResponse response) {

        String matp = request.getParameter("matp");

        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        List<DevvnQuanhuyen> lstQuanHuyen = quanHuyenDAOImpl.getAllQuanHuyenByTinhTPId(matp);
        for (int i = 0; i < lstQuanHuyen.size(); i++) {
            System.out.println("lstQuanHuyen: " + lstQuanHuyen.get(i).getName());
        }
        List<DevvnQuanhuyenForJSon> listQH = new ArrayList<>();
        for (DevvnQuanhuyen qh : lstQuanHuyen) {
            DevvnQuanhuyenForJSon qhjson = new DevvnQuanhuyenForJSon(qh.getMaqh(), qh.getName(), qh.getType(), qh.getMatp().getMatp());
            listQH.add(qhjson);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(listQH);
            String data = writer.writeValueAsString(json);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "application/json; charset=utf-8");
            return new ResponseEntity<String>(data, responseHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @RequestMapping(value = "/loadXa", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> loadXa(HttpServletRequest request, HttpServletResponse response) {
        String maqh = request.getParameter("maqh");
        ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
        List<DevvnXaphuongthitran> lstXa = xaPhuongDAOImpl.getAllXaByMaQH(maqh);
        List<DevvnXaphuongthitranForJson> listXa = new ArrayList<>();
        for (DevvnXaphuongthitran xa : lstXa) {
            DevvnXaphuongthitranForJson xaJson = new DevvnXaphuongthitranForJson(xa.getXaid(), xa.getName(), xa.getType(), xa.getMaqh().getMaqh());
            listXa.add(xaJson);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(listXa);
            String data = writer.writeValueAsString(json);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("Content-Type", "application/json; charset=utf-8");
            return new ResponseEntity<String>(data, responseHeaders, HttpStatus.CREATED);
//            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
