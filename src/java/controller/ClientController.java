/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AuthorDAO;
import dao.CategoryDAO;
import dao.CountryDAO;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.EmailRegisteredDAO;
import dao.FeedBackDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.PromotionDAO;
import dao.PublisherDAO;
import dao.QuanHuyenDAOImpl;
import dao.TinhTPDAOImpl;
import dao.XaPhuongDAOImpl;
import entities.Authors;
import entities.Cart;
import entities.Customers;
import entities.DevvnQuanhuyen;
import entities.DevvnTinhthanhpho;
import entities.DevvnXaphuongthitran;
import entities.EmailRegistereds;
import entities.FeedBacks;
import entities.OrderDetails;
import entities.Orders;
import entities.Products;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.Common;

/**
 *
 * @author Hide
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {

    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private AuthorDAO authorDAO;
    private CountryDAO countryDAO;
    private PublisherDAO publisherDAO;
    private EmailRegisteredDAO emailRegisteredDAO;
    private FeedBackDAO feedBackDAO;
    private XaPhuongDAOImpl xaPhuongDAOImpl;
    private QuanHuyenDAOImpl quanHuyenDAOImpl;
    private TinhTPDAOImpl tinhTPDAOImpl;
    private PromotionDAO promotionDAO;
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Autowired
    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Autowired
    public void setPublisherDAO(PublisherDAO publisherDAO) {
        this.publisherDAO = publisherDAO;
    }

    @Autowired
    public void setEmailRegisteredDAO(EmailRegisteredDAO emailRegisteredDAO) {
        this.emailRegisteredDAO = emailRegisteredDAO;
    }

    @Autowired
    public void setFeedBackDAO(FeedBackDAO feedBackDAO) {
        this.feedBackDAO = feedBackDAO;
    }

    @Autowired
    public void setXaPhuongDAOImpl(XaPhuongDAOImpl xaPhuongDAOImpl) {
        this.xaPhuongDAOImpl = xaPhuongDAOImpl;
    }

    @Autowired
    public void setQuanHuyenDAOImpl(QuanHuyenDAOImpl quanHuyenDAOImpl) {
        this.quanHuyenDAOImpl = quanHuyenDAOImpl;
    }

    @Autowired
    public void setTinhTPDAOImpl(TinhTPDAOImpl tinhTPDAOImpl) {
        this.tinhTPDAOImpl = tinhTPDAOImpl;
    }

    @Autowired
    public void setPromotionDAO(PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping(value = "/search")
    public String searchProduct(Model model, Integer offset, Integer maxResult, HttpServletRequest request, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            String name = request.getParameter("name");
            List<Products> searchProductByName = productDAO.searchProductByName(name, offset, maxResult);
            model.addAttribute("listSearch", searchProductByName);
            model.addAttribute("totalSearch", productDAO.getTotalSearch(name));
            model.addAttribute("offset", offset);
            model.addAttribute("key", name);
            model.addAttribute("searchMes", "Không có sản phẩm phù hợp");
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/search";
        } else {
            return "redirect:home.htm";
        }

    }

    @RequestMapping(value = "/productByCategoryId")
    public String loadProductByCategory(@RequestParam("cateId") Integer cateId, Model model, Integer offset, Integer maxResult, HttpSession session) {

        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            List<Products> productsByCategoryId = productDAO.getProductsByCategoryId(cateId, offset, maxResult);
            model.addAttribute("pByCateId", productsByCategoryId);
            model.addAttribute("total", productDAO.getTotalByCateId(cateId));
            model.addAttribute("offset", offset);
            if (!productsByCategoryId.isEmpty()) {
                model.addAttribute("title", "Sách thể loại: " + productsByCategoryId.get(0).getCategoryId().getCategoryName());
            } else {
                model.addAttribute("title", "Không có dữ liệu");
            }
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/productByCategoryId";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/productByAuthorId")
    public String loadProductByAuthor(@RequestParam("auId") Integer auId, Model model, Integer offset, Integer maxResult, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            List<Authors> authersByAuthorId = productDAO.getAuthersByAuthorId(auId, offset, maxResult);
            model.addAttribute("pByAuId", authersByAuthorId);
            model.addAttribute("total", productDAO.getTotalByAuId(auId));
            model.addAttribute("offset", offset);
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/productByAuthorId";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/productByCountryId")
    public String loadProductByCountry(@RequestParam("countryId") Integer countryId, Model model, Integer offset, Integer maxResult, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("pByCountryId", productDAO.getCountriesByCountryId(countryId, offset, maxResult));
            model.addAttribute("total", productDAO.getTotalByCountryId(countryId));
            model.addAttribute("offset", offset);
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/productByCountryId";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/productByPublisherId")
    public String loadProductByPublisher(@RequestParam("pubId") Integer pubId, Model model, Integer offset, Integer maxResult, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("pByPubId", productDAO.getPublishersByPublisherId(pubId, offset, maxResult));
            model.addAttribute("total", productDAO.getTotalByPubId(pubId));
            model.addAttribute("offset", offset);
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/productByPublisherId";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/addEmail")
    public String addEmail(@ModelAttribute(value = "em") EmailRegistereds em, Model model) {
        em.setEmailRegisteredStatus(true);
        boolean bl = emailRegisteredDAO.addEmail(em);
        if (bl) {
            model.addAttribute("status", "Đăng ký nhận mail thành công!");
//            return "redirect:/client/home.htm";
            return "frontend/home";
        } else {
            model.addAttribute("status", "Sai cú pháp hoặc mail đã được đăng ký!");
            return "frontend/home";
        }
    }

    @RequestMapping(value = "/productById")
    public String loadProductById(@RequestParam("proId") Integer proId, @RequestParam("auId") Integer auId, @RequestParam("cateId") Integer cateId, @RequestParam("countryId") Integer countryId, @RequestParam("pubId") Integer pubId, Model model, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("single", productDAO.getProductById(proId));
            model.addAttribute("relaAu", productDAO.get4AuthersByAuthorId(auId));
            model.addAttribute("relaCate", productDAO.get4ProductsByCategoryId(cateId, proId));
            model.addAttribute("relaCountry", productDAO.get4CountriesByCountryId(countryId));
            model.addAttribute("relaPub", productDAO.get4PublishersByPublisherId(pubId));
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/productById";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/product")
    public String loadProduct(Model model, HttpSession session, Integer offset, Integer maxResult) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("listP", productDAO.getAllByStatus(offset, maxResult));
            model.addAttribute("total", productDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/product";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/feedback")
    public String preAddFeedBack(Model model, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("fb", new FeedBacks());
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/feedback";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/addFeedback")
    public String addFeedbak(@ModelAttribute(value = "fb") FeedBacks fb, Model model, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("em", new EmailRegistereds());
            fb.setFeedBackStatus(true);
            boolean addFeedBack = feedBackDAO.addFeedBack(fb);
            if (addFeedBack) {
                model.addAttribute("statusfb", "Gửi phản hồi thành công!");
                return "frontend/feedback";
            } else {
                model.addAttribute("statusfb", "Gửi phản hồi thất bại!");
                return "frontend/feedback";
            }
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "initLogin")
    public String initLogin(Model model) {
        Customers cus = new Customers();
        model.addAttribute("account", cus);
        model.addAttribute("em", new EmailRegistereds());
        model.addAttribute("testLogin", "testLogin");

        return "frontend/login";
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute("account") Customers cus, HttpSession session, HttpServletRequest request, Model model) {
        Customers c = customerDAO.checkLogin(cus);
        String action = request.getParameter("action");
        model.addAttribute("em", new EmailRegistereds());
        if (c != null) {
            session.setAttribute("account", cus.getCustomerUser());
            if ("payment".equals(action)) {
                return "redirect:myCart.htm";
            } else if ("history".equals(action)) {
                return "redirect:orderHistory.htm";
            } else {
                return "redirect:home.htm";
            }
        } else {
            model.addAttribute("message", "Sai thông tin đăng nhập.");
            return "frontend/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
//        Customers cus = new Customers();
//        model.addAttribute("account", cus);
        return "redirect:home.htm";
    }

    @RequestMapping(value = "initRegister")
    public String initRegister(Model model) {
        Customers customer = new Customers();
        model.addAttribute("register", customer);
        model.addAttribute("em", new EmailRegistereds());

        return "frontend/register";
    }

    @RequestMapping(value = "/register")
    public String resgiterUser(@ModelAttribute("register") Customers user, HttpServletRequest request, HttpSession session, Model model) {
        if (customerDAO.checkUsername(user.getCustomerUser())) {
            model.addAttribute("regMessage", "Tên đăng nhập đã được dùng. Bạn vui làng điền tên khác để đăng kí.");
            return "frontend/register";
        } else if (customerDAO.checkUserEmail(user.getCustomerEmail())) {
            model.addAttribute("regMessage", "Email đã được dùng để đăng kí.");
            return "frontend/register";
        } else {
            user.setCustomerStatus(true);
            boolean add = customerDAO.add(user);
            if (add) {
                session.setAttribute("account", user.getCustomerUser());
            } else {
                return "frontend/error";
            }
        }
        return "frontend/welcome";

    }

    @RequestMapping(value = "initPayment")
    public String initCheckOut(HttpSession session, Model model) {
        model.addAttribute("tinhtp", tinhTPDAOImpl.getAllTinhTP());
//        model.addAttribute("quanhuyen", quanHuyenDAOImpl.getAllQuanHuyen());
//        model.addAttribute("xaphuong", xaPhuongDAOImpl.getAllXaPhuong());
        model.addAttribute("order", new Orders());
        model.addAttribute("em", new EmailRegistereds());
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        String name = (String) session.getAttribute("account");
        Object sessionAu = session.getAttribute("listA");
        if (name != null && sessionAu != null) {
            Customers user = customerDAO.getCustomerByName(session.getAttribute("account").toString());
            model.addAttribute("us", user);
            model.addAttribute("totalPrice", Common.formatNumber(getTotal(listCart)));

            return "frontend/shoppingConfirm";
        } else {
            model.addAttribute("tb", "Mời bạn đăng nhập để tiếp tục quá trình mua hàng!");
            Customers account = new Customers();
            model.addAttribute("account", account);
            model.addAttribute("action", "payment");
            return "frontend/login";
        }

    }

    @RequestMapping(value = "/checkOutConfirm")
    public String checkOutConfirm(HttpServletRequest request, Model model, HttpSession session) {

        String name = (String) session.getAttribute("account");
        Object sessionAu = session.getAttribute("listA");
        if (name != null && sessionAu != null) {
            String cusId = request.getParameter("customerId");
            String tinh = request.getParameter("orderTinhTP");
            String huyen = request.getParameter("orderQuanHuyen");
            String xa = request.getParameter("orderXaPhuong");
            String so = request.getParameter("orderSoNha");
//        System.out.println("tinh: " + tinh + "\nhuyen: " + huyen);
            DevvnTinhthanhpho tinhById = orderDAO.getTinhById(tinh);
            DevvnQuanhuyen huyenById = orderDAO.getHuyenById(huyen);
            DevvnXaphuongthitran xaById = orderDAO.getXaById(xa);

            Customers c = new Customers(Integer.parseInt(cusId));

            Date date = new Date();
            Orders od = new Orders();
            od.setOrderDate(date);
            od.setOrderSoNha(so);
            od.setOrderXaPhuong(xaById.getName());
            od.setOrderQuanHuyen(huyenById.getName());
            od.setOrderTinhTP(tinhById.getName());
            od.setCustomerId(c);

            boolean add = orderDAO.add(od);
            boolean checkOrderAdd = false;

            Orders newOrderId = orderDAO.getNewOrderId();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            for (int i = 0; i < listCart.size(); i++) {
                OrderDetails odt = new OrderDetails();
                odt.setOrderDetailQuantity(listCart.get(i).getQuantity());
                if (listCart.get(i).getProduct().getProductDiscount() != null) {
                    if (listCart.get(i).getProduct().getProductDiscount() > 0) {
                        odt.setOrderDetailCurrentPrice(listCart.get(i).getProduct().getProductDiscount());
                    } else {
                        odt.setOrderDetailCurrentPrice(listCart.get(i).getProduct().getProductPrice());
                    }
                } else {
                    odt.setOrderDetailCurrentPrice(listCart.get(i).getProduct().getProductPrice());
                }
                Products p = new Products(listCart.get(i).getProduct().getProductId());
                odt.setProductId(p);
                odt.setOrderId(newOrderId);
                checkOrderAdd = orderDAO.add(odt);
            }
            model.addAttribute("em", new EmailRegistereds());
//        select oderid (newest) -> chay vong lap de luu vao orderdetail
            if (add && checkOrderAdd) {
                session.removeAttribute("listCart");
                model.addAttribute("message", "Đặt hàng thành công. Đang chờ xác nhận đơn hàng");
//            orderDAO.getOrderByCusId(Integer.parseInt(cusId));
                return "redirect:orderHistory.htm";
            } else {
                model.addAttribute("message", "Đặt hàng thất bại!");
                return "frontend/error";
            }
        } else {
            model.addAttribute("tb", "Mời bạn đăng nhập để tiếp tục quá trình mua hàng!");
            Customers account = new Customers();
            model.addAttribute("account", account);
            model.addAttribute("action", "payment");
            return "frontend/login";
        }

    }

    @RequestMapping(value = "/orderHistory")
    public String orderHistory(Model model, HttpSession session) {
        String name = (String) session.getAttribute("account");
        Object sessionAu = session.getAttribute("listA");
        if (name != null && sessionAu != null) {
            model.addAttribute("em", new EmailRegistereds());
            Customers user = customerDAO.getCustomerByName(name);
            Integer customerId = user.getCustomerId();
            List<Orders> orderByCusId = orderDAO.getOrderByCusId(customerId);
            model.addAttribute("listHis", orderByCusId);
            return "frontend/shoppingSuccess";
        } else {
            model.addAttribute("tb", "Mời bạn đăng nhập để tiếp tục quá trình mua hàng!");
            Customers account = new Customers();
            model.addAttribute("account", account);
            model.addAttribute("action", "history");
            return "frontend/login";
        }
    }

    public float getTotal(List<Cart> listCart) {
        float total = 0;
        if (listCart.size() > 0) {
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

    @RequestMapping(value = "/about")
    public String about(Model model, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("em", new EmailRegistereds());
            return "frontend/about";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/promotion")
    public String loadPromo(@RequestParam(value = "promoId") Integer id, Model model, HttpSession session) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
            model.addAttribute("em", new EmailRegistereds());
            model.addAttribute("promo", promotionDAO.getPromobyId(id));
            model.addAttribute("listPromoDt", promotionDAO.getPromoDeById(id)); 
            model.addAttribute("promoDt1", promotionDAO.get1PromoDeById(id));
            return "frontend/promotion";
        } else {
            return "redirect:home.htm";
        }
    }
    
    @RequestMapping (value = "/offerProduct")
    public String loadOfferPro(Model model, HttpSession session, Integer offset, Integer maxResult) {
        Object sessionAu = session.getAttribute("listA");
        if (sessionAu != null) {
           model.addAttribute("lstOrderPro", productDAO.getAllOfferProduct(offset, maxResult));
           model.addAttribute("total", productDAO.getTotalOfferPro());
           model.addAttribute("offset", offset);
           model.addAttribute("em", new EmailRegistereds());
            return "frontend/offerProduct";
        } else {
            return "redirect:home.htm";
        }
    }

    @RequestMapping(value = "/home")
    public String home(Model model, HttpSession session, Integer offset, Integer maxResult) {
//        session.setAttribute("listP", productDAO.getAllByStatus(offset, maxResult));
        session.setAttribute("listA", authorDAO.get8ByStatus());
        session.setAttribute("listC", countryDAO.get6CountryByStatus());
        session.setAttribute("listPub", publisherDAO.get5PublisherByStatus());
        session.setAttribute("listCate", categoryDAO.getAllByStatus());
        session.setAttribute("listNewP", productDAO.getNewestProduct());
        session.setAttribute("listOfferP", productDAO.getOfferProduct());
        model.addAttribute("promotions", promotionDAO.get3Promotion());
        model.addAttribute("em", new EmailRegistereds());
//        model.addAttribute("fb", new FeedBacks());
        return "frontend/home";
    }

}
