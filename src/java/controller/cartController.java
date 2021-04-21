/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import entities.Cart;
import entities.EmailRegistereds;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.Common;

/**
 *
 * @author Hide
 */
@Controller
@RequestMapping(value = "/client")
public class cartController {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    

//    
    @RequestMapping(value = "/addCart")
    public String addCart(@RequestParam("id") int id, @RequestParam(value = "quantity", required = false) String quantity, HttpSession session, HttpServletRequest request, Model model) {

        int productQuantity = productDAO.getQuantity(id);
        int quan = Integer.parseInt(quantity);
        //lay ds sp của user trong session
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        if (productQuantity > 0 && quan > 0 && quan <= productQuantity) {
            if (listCart == null) {
                // case chưa có dsach nào add luôn sp vao cart được chọn
                listCart = new ArrayList<>();
                listCart.add(new Cart(productDAO.getProductById(id), quan));
            } else {
                boolean flag = false;
                for (Cart c : listCart) {
                    if (c.getProduct().getProductId() == id) {
                        int a = c.getQuantity();
                        c.setQuantity(a + 1);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    listCart.add(new Cart(productDAO.getProductById(id), quan));
                }
            }

            // đưa giỏ hàng lên session
            session.setAttribute("listCart", listCart);
            session.setAttribute("totalPrice", Common.formatNumber(getTotal(listCart)));
            model.addAttribute("em", new EmailRegistereds());
            return "/frontend/shoppingCart";
        } else {
            String cateId = request.getParameter("cateId");
            model.addAttribute("single", productDAO.getProductById(id));
            model.addAttribute("relaCate", productDAO.get4ProductsByCategoryId(Integer.parseInt(cateId), id));
            model.addAttribute("quanMes", "Số lượng nhập lớn hơn số lượng trong kho hàng!");
            model.addAttribute("em", new EmailRegistereds());
            return "/frontend/productById";
        }

    }

    public float getTotal(List<Cart> listCart) {
        float total = 0;
        if (listCart != null && listCart.size() > 0) {
            for (Cart c : listCart) {
                if (c.getProduct().getProductDiscount() != null) {
                    if (c.getProduct().getProductDiscount() > 0) {
                        total += c.getQuantity() * c.getProduct().getProductDiscount();
                    } else {
                        total += c.getQuantity() * c.getProduct().getProductPrice();
                    }
                } else {
                    total += c.getQuantity() * c.getProduct().getProductPrice();
                }

            }
        }

        return total;
    }

    private int isExisTing(int id, HttpSession session) {
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getProduct().getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam("id") int id, HttpSession session, Model model) {
        // lấy dssp session kh
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        if (listCart != null) {
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProduct().getProductId() == id) {
                    // neu sp ton tai thi remove
                    listCart.remove(i).getProduct().getProductId();
                    break;
                }
            }
        }
        // luu ds sp va tong tien
        session.setAttribute("listCart", listCart);
        session.setAttribute("total", Common.formatNumber(getTotal(listCart)));
        model.addAttribute("em", new EmailRegistereds());
        return "/frontend/shoppingCart";
    }

    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request, HttpSession session, Model model) {
        // lay dssp khach hang trong session 
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        // lay danh sach sl san pham muon mua
        String[] arrQuantity = request.getParameterValues("quantity");

        for (int i = 0; i < listCart.size(); i++) {
            int productQuantity = listCart.get(i).getProduct().getProductQuantity();
                int quantity = Integer.parseInt(arrQuantity[i]);
                if (quantity <= productQuantity) {
                    listCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));

                    if (Integer.parseInt(arrQuantity[i]) < 1) {
                        listCart.get(i).setQuantity(1);
                    }
                } else {
                    listCart.get(i).setQuantity(listCart.get(i).getQuantity());
                    model.addAttribute("quanMes", "Số lượng nhập lơn hơn số lượng trong kho hàng!");
                }
        }
        // luu ds sp va tong tien
        session.setAttribute("listCart", listCart);
        session.setAttribute("total", Common.formatNumber(getTotal(listCart)));
        model.addAttribute("em", new EmailRegistereds());
        return "/frontend/shoppingCart";
    }

    @RequestMapping(value = "myCart")
    public String myCart(HttpSession session, Model model) {
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        float total = (float) getTotal(listCart);

        model.addAttribute("total", Common.formatNumber(total));
        model.addAttribute("em", new EmailRegistereds());

        return "/frontend/shoppingCart";
    }
}
