/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import dao.AuthorDAO;
import dao.CategoryDAO;
import dao.CountryDAO;
import dao.CustomerDAO;
import dao.FeedBackDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.PublisherDAO;
import entities.Admins;
import entities.Authors;
import entities.Categories;
import entities.Countries;
import entities.Customers;
import entities.OrderDetails;
import entities.Orders;
import entities.Products;
import entities.ProductsExt;
import entities.Publishers;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Hide
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private AdminDAO adminDAO;
    private CategoryDAO categoryDAO;
    private AuthorDAO authorDAO;
    private CountryDAO countryDAO;
    private PublisherDAO publisherDAO;
    private CustomerDAO customerDAO;
    private FeedBackDAO feedBackDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Autowired
    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
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
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setFeedBackDAO(FeedBackDAO feedBackDAO) {
        this.feedBackDAO = feedBackDAO;
    }

    //Dashboard
    @RequestMapping(value = "/home")
    public String homeAdmin(Model model, HttpSession session, Integer offset, Integer maxResult) {
        String view;
        System.out.println("aaaaaaaaaaa :" + session.getAttribute("admin"));
//        session.removeAttribute("message");
        if (CheckUrl.check(session)) {
            view = "backend/home";
            model.addAttribute("orderRecord", orderDAO.getOrderRecord());
            model.addAttribute("listP", productDAO.getAll(offset, maxResult));
            model.addAttribute("total", productDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("listOrder", orderDAO.getAllOrders(offset, maxResult));
            model.addAttribute("totalod", orderDAO.getOrderRecord());
            model.addAttribute("offsetod", offset);
            model.addAttribute("totalfb", feedBackDAO.getFeedbackRecord());
            model.addAttribute("lstfb", feedBackDAO.getAll(offset, maxResult));
            model.addAttribute("totalfb", feedBackDAO.getFeedbackRecord());
            model.addAttribute("offsetfb", offset);
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    //Product table
    @RequestMapping(value = "/product")
    public String loadProduct(Model model, Integer offset, Integer maxResult, HttpSession session) {
        String view;
        if (CheckUrl.check(session)) {
            view = "backend/product";
            model.addAttribute("listP", productDAO.getAll(offset, maxResult));
            model.addAttribute("total", productDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchPro.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }

        return view;
    }

    @RequestMapping(value = "/initInsertProduct")
    public String initInsertProduct(Model model) {
        model.addAttribute("newProduct", new Products());
        model.addAttribute("listCate", categoryDAO.getAllByStatus());
        model.addAttribute("listA", authorDAO.getAllByStatus());
        model.addAttribute("listC", countryDAO.getAllByStatus());
        model.addAttribute("listPub", publisherDAO.getAllByStatus());
        return "backend/insertProduct";
    }

    @RequestMapping(value = "/insertProduct")
    public String insertProduct(@ModelAttribute(value = "newProduct") Products product, Model model, HttpServletRequest request) {

        String path = request.getRealPath("/views/frontend/assets/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\views\\frontend\\assets\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    //path
                    if ("productFeatureImage".equals(fileItem.getFieldName())) {
                        product.setProductFeatureImage(fileItem.getName());
                    }
                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("productName")) {
                        product.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("productQuantity")) {
                        product.setProductQuantity(Integer.parseInt(value));
                    } else if (name.equals("productPrice")) {
                        product.setProductPrice(Double.parseDouble(value));
                    } else if (name.equals("productDiscount")) {
                        product.setProductDiscount(Double.parseDouble(value));
                    } else if (name.equals("productDescription")) {
                        product.setProductDescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("categoryId.categoryId")) {
                        Categories cate = new Categories(Integer.parseInt(value));
                        product.setCategoryId(cate);
                    } else if (name.equals("authorId.authorId")) {
                        Authors au = new Authors(Integer.parseInt(value));
                        product.setAuthorId(au);
                    } else if (name.equals("publisherId.publisherId")) {
                        Publishers p = new Publishers(Integer.parseInt(value));
                        product.setPublisherId(p);
                    } else if (name.equals("countryId.countryId")) {
                        Countries c = new Countries(Integer.parseInt(value));
                        product.setCountryId(c);
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String format = dateFormat.format(date);
        System.out.println("dateeeeeeeeee : " + date + "\ndsafasd : " + format);
        product.setProductAddedTime(date);
        product.setProductStatus(true);

        boolean check = productDAO.add(product);

        if (check) {
            model.addAttribute("message", "Thêm mới thành công!");
            return "redirect:/admin/product.htm";
        } else {
            model.addAttribute("message", "Thêm mới không thành công!");
            model.addAttribute("newProduct", new Products());
            model.addAttribute("listCate", categoryDAO.getAllByStatus());
            model.addAttribute("listA", authorDAO.getAllByStatus());
            model.addAttribute("listC", countryDAO.getAllByStatus());
            model.addAttribute("listPub", publisherDAO.getAllByStatus());
            return "backend/insertProduct";
        }
    }

    @RequestMapping(value = "/preUpdateProduct")
    public String UpdateP(@RequestParam("productId") Integer productId, Model model) {
        Products p = productDAO.getProductById(productId);
        ProductsExt pr = new ProductsExt();
        pr.setAuthorId(p.getAuthorId());
        pr.setCategoryId(p.getCategoryId());
        pr.setCountryId(p.getCountryId());
        pr.setProductQuantity(p.getProductQuantity());
        pr.setImageOld(p.getProductFeatureImage());
        pr.setProductAddedTime(p.getProductAddedTime());
        pr.setProductDescription(p.getProductDescription());
        pr.setProductDiscount(p.getProductDiscount());
        pr.setProductFeatureImage(p.getProductFeatureImage());
        pr.setProductId(p.getProductId());
        pr.setProductName(p.getProductName());
        pr.setProductPrice(p.getProductPrice());
        pr.setProductStatus(p.getProductStatus());
        pr.setPublisherId(p.getPublisherId());
        model.addAttribute("productId", pr);
        List<Authors> allAuthor = authorDAO.getAllByStatus();
        model.addAttribute("listAuthor", allAuthor);
        List<Categories> allCate = categoryDAO.getAllByStatus();
        model.addAttribute("listCate", allCate);
        List<Publishers> allPublisher = publisherDAO.getAllByStatus();
        model.addAttribute("listPub", allPublisher);
        List<Countries> allCountry = countryDAO.getAllByStatus();
        model.addAttribute("listCountry", allCountry);

        return "backend/updateProduct";
    }

    @InitBinder
    public void initBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(value = "/updateProduct")
    public String doUpdateP(@ModelAttribute("productId") ProductsExt p, Model model, HttpServletRequest request, Integer offset, Integer maxResult) {

        String path = request.getRealPath("/views/backend/assets/images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\views\\backend\\assets\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    //path
                    if ("productFeatureImage".equals(fileItem.getFieldName())) {
                        String value = fileItem.getName();
                        if (value != null && value.trim().length() > 0) {
                            p.setProductFeatureImage(value);
                            //upload to folder
                            fileItem.write(new File(path + "/" + value));
                        }
                    }

                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("productId")) {
                        p.setProductId(Integer.parseInt(value));
                    } else if (name.equals("productName")) {
                        p.setProductName(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("productQuantity")) {
                        p.setProductQuantity(Integer.parseInt(value));
                    } else if (name.equals("productAddedTime")) {
                        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                        p.setProductAddedTime(s.parse(value));
                    } else if (name.equals("productPrice")) {
                        p.setProductPrice(Double.parseDouble(value));
                    } else if (name.equals("productDiscount")) {
                        p.setProductDiscount(Double.parseDouble(value));
                    } else if (name.equals("productDescription")) {
                        p.setProductDescription(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("categoryId.categoryId")) {
                        Categories cate = new Categories(Integer.parseInt(value));
                        p.setCategoryId(cate);
                    } else if (name.equals("authorId.authorId")) {
                        Authors au = new Authors(Integer.parseInt(value));
                        p.setAuthorId(au);
                    } else if (name.equals("publisherId.publisherId")) {
                        Publishers pb = new Publishers(Integer.parseInt(value));
                        p.setPublisherId(pb);
                    } else if (name.equals("countryId.countryId")) {
                        Countries c = new Countries(Integer.parseInt(value));
                        p.setCountryId(c);
                    } else if (name.equals("imageOld")) {
                        p.setImageOld(new String(value.getBytes("iso-8859-1"), "UTF-8"));
                    } else if (name.equals("productStatus")) {
                        p.setProductStatus(Boolean.parseBoolean(value));
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Products pr = new Products();
        pr.setAuthorId(p.getAuthorId());
        pr.setCategoryId(p.getCategoryId());
        pr.setCountryId(p.getCountryId());
        pr.setProductAddedTime(p.getProductAddedTime());
        pr.setProductDescription(p.getProductDescription());
        pr.setProductDiscount(p.getProductDiscount());
        pr.setProductQuantity(p.getProductQuantity());
        if (p.getProductFeatureImage() == null) {
            pr.setProductFeatureImage(p.getImageOld());
        } else {
            pr.setProductFeatureImage(p.getProductFeatureImage());
        }
        pr.setProductId(p.getProductId());
        pr.setProductName(p.getProductName());
        pr.setProductPrice(p.getProductPrice());
        pr.setProductStatus(p.getProductStatus());
        pr.setPublisherId(p.getPublisherId());

        boolean bl = productDAO.updateProduct(pr);
        if (bl) {
            model.addAttribute("message", "Update Sussucessfully!");
            model.addAttribute("listP", productDAO.getAll(offset, maxResult));
            model.addAttribute("total", productDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/product";
        } else {
            model.addAttribute("message", "Update Fails!");
            model.addAttribute("productId", p);
            return "/backend/updateProduct";
        }
    }

    @RequestMapping(value = "/detailProduct")
    public String detailsProduct(@RequestParam("productId") Integer productId, Model model) {
        model.addAttribute("p", productDAO.getProductById(productId));
        return "backend/detailProduct";
    }

    @RequestMapping(value = "/delProduct")
    public String delProduct(@RequestParam("productId") Integer productId, Model model) {
        boolean bl = productDAO.del(productId);

        if (bl) {
            model.addAttribute("delMessage", "Xóa thành công!");
            return "redirect:/admin/product.htm";
        } else {
            model.addAttribute("delMessage", "Xóa thất bại!");
            return "backend/product";
        }
    }

    //Author table
    @RequestMapping(value = "/author")
    public String loadAuthor(Model model, Integer offset, Integer maxResult, HttpSession session) {
//        model.addAttribute("listAu", authorDAO.getAll(offset, maxResult));
//        model.addAttribute("total", authorDAO.getTotal());
//        model.addAttribute("offset", offset);
//        return "backend/author";

        String view;
        if (CheckUrl.check(session)) {
            view = "backend/author";
            model.addAttribute("listAu", authorDAO.getAll(offset, maxResult));
            model.addAttribute("total", authorDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchAu.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertAuthor")
    public String initInsertAuthor(Model model) {
        model.addAttribute("newAuthor", new Authors());
        return "backend/insertAuthor";
    }

    @RequestMapping(value = "/insertAuthor") //produces = "application/x-www-form-urlencoded;charset=UTF-8"
    public String insertAuthor(@ModelAttribute(value = "newAuthor") Authors au, Model model) {
        boolean check = authorDAO.add(au);
        if (check) {
            model.addAttribute("message", "Thêm mới thành công!");
            return "redirect:/admin/author.htm";
        } else {
            model.addAttribute("message", "Thêm mới không thành công!");
            return "backend/insertAuthor";
        }
    }

    @RequestMapping(value = "/delAuthor")
    public String delAuthor(@RequestParam("auId") Integer auId, Model model) {
        boolean bl = authorDAO.del(auId);

        if (bl) {
            model.addAttribute("delMessage", "Xóa tác giả thành công!");
            return "redirect:/admin/author.htm";
        } else {
            model.addAttribute("delMessage", "Xóa tác giả thất bại!");
            return "backend/author";
        }
    }

    @RequestMapping(value = "/preUpdateAuthor")
    public String preUpdateAuthor(@RequestParam("authorId") Integer authorId, Model model) {
        model.addAttribute("auth", authorDAO.getAuthorById(authorId));
        return "/backend/updateAuthor";
    }

    @RequestMapping(value = "/updateAuthor")
    public String doUpdateAuthor(@ModelAttribute("auth") Authors auth, Model model, Integer offset, Integer maxResult) {
        boolean bl = authorDAO.update(auth);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listAu", authorDAO.getAll(offset, maxResult));
            model.addAttribute("total", authorDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/author";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updateAuthor";
        }
    }

    //Categories table
    @RequestMapping(value = "/category")
    public String loadCategory(Model model, Integer offset, Integer maxResult, HttpSession session) {

        String view;
        if (CheckUrl.check(session)) {
            view = "backend/category";
            model.addAttribute("listCate", categoryDAO.getAll(offset, maxResult));
            model.addAttribute("total", categoryDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchCate.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertCate")
    public String initInsertCate(Model model) {
        model.addAttribute("newCate", new Categories());
        return "backend/insertCategory";
    }

    @RequestMapping(value = "/insertCate")
    public String insertCate(@ModelAttribute(value = "newCate") Categories cate, Model model) {
        boolean check = categoryDAO.add(cate);
        if (check) {
//            model.addAttribute("message", "Thêm mới thành công!");
            return "redirect:/admin/category.htm";
        } else {
            model.addAttribute("message", "Thêm mới thất bại!");
            return "backend/insertCategory";
        }
    }

    @RequestMapping(value = "/delCate")
    public String delCate(@RequestParam("cateId") Integer cateId, Model model) {
        boolean bl = categoryDAO.del(cateId);

        if (bl) {
//            model.addAttribute("delMessage", "Xóa danh mục thành công!");
            return "redirect:/admin/category.htm";
        } else {
            model.addAttribute("delMessage", "Xóa danh mục thất bại!");
            return "backend/category";
        }
    }

    //Publishers table
    @RequestMapping(value = "/publisher")
    public String loadPub(Model model, Integer offset, Integer maxResult, HttpSession session) {

        String view;
        if (CheckUrl.check(session)) {
            view = "backend/publisher";
            model.addAttribute("listPub", publisherDAO.getAll(offset, maxResult));
            model.addAttribute("total", publisherDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchPub.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertPub")
    public String initInsertPub(Model model) {
        model.addAttribute("newPub", new Publishers());
        return "backend/insertPublisher";
    }

    @RequestMapping(value = "/insertPub")
    public String insertPub(@ModelAttribute(value = "newPub") Publishers pub, Model model) {
        boolean check = publisherDAO.add(pub);
        if (check) {
            return "redirect:/admin/publisher.htm";
        } else {
            model.addAttribute("message", "Thêm mới thất bại!");
            return "backend/insertPublisher";
        }
    }

    @RequestMapping(value = "/delPub")
    public String delPub(@RequestParam("pubId") Integer pubId, Model model) {
        boolean bl = publisherDAO.del(pubId);

        if (bl) {
            return "redirect:/admin/publisher.htm";
        } else {
            model.addAttribute("delMessage", "Xóa danh mục thất bại!");
            return "backend/publisher";
        }
    }

    //Countries table
    @RequestMapping(value = "/country")
    public String loadCountry(Model model, Integer offset, Integer maxResult, HttpSession session) {

        String view;
        if (CheckUrl.check(session)) {
            view = "backend/country";
            model.addAttribute("listC", countryDAO.getAll(offset, maxResult));
            model.addAttribute("total", countryDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchC.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertCountry")
    public String initInsertCountry(Model model) {
        model.addAttribute("newCountry", new Countries());
        return "backend/insertCountry";
    }

    @RequestMapping(value = "/insertCountry")
    public String insertCountry(@ModelAttribute(value = "newCountry") Countries c, Model model) {
        boolean check = countryDAO.add(c);
        if (check) {
            return "redirect:/admin/country.htm";
        } else {
            model.addAttribute("message", "Thêm mới thất bại!");
            return "backend/insertCountry";
        }
    }

    @RequestMapping(value = "/delCountry")
    public String delCountry(@RequestParam("countryId") Integer countryId, Model model) {
        boolean bl = countryDAO.del(countryId);

        if (bl) {
            return "redirect:/admin/country.htm";
        } else {
            model.addAttribute("delMessage", "Xóa thất bại!");
            return "backend/country";
        }
    }

    //Bảng Orders
    @RequestMapping(value = "/order")
    public String loadOrder(Model model, Integer offset, Integer maxResult, HttpSession session) {

        String view;
        if (CheckUrl.check(session)) {
            view = "backend/order";
            model.addAttribute("listOrder", orderDAO.getAllOrders(offset, maxResult));
            model.addAttribute("total", orderDAO.getOrderRecord());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchOd.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/orderDetail")
    public String loadOrderDetail(@RequestParam(value = "id") Integer id, Model model, Integer offset, Integer maxResult, HttpSession session) {
        List<OrderDetails> orderDetailsByOrderId = orderDAO.getOrderDetailsByOrderId(id, offset, maxResult);
        model.addAttribute("lstOrderDetails", orderDetailsByOrderId);
        model.addAttribute("total", orderDAO.getTotalOdtByOdId(id));
        model.addAttribute("offset", offset);
        model.addAttribute("totalPrice", getTotal(orderDetailsByOrderId));
//        model.addAttribute("action", "searchOdt.htm");
        model.addAttribute("odtid", id);
        return "backend/orderDetail";
    }

    @RequestMapping(value = "/orderConfirm")
    public String orderConfirm(@RequestParam(value = "orderId") Integer orderId, Model model, Integer offset, Integer maxResult, HttpSession session) {
        String view;
        if (CheckUrl.check(session)) {
            view = "backend/order";
            Admins admin = adminDAO.getAdminByName(session.getAttribute("admin").toString());
            boolean updateOrderAdminId = orderDAO.updateOrderAdminId(admin, orderId);
            model.addAttribute("listOrder", orderDAO.getAllOrders(offset, maxResult));
            model.addAttribute("total", orderDAO.getOrderRecord());
            model.addAttribute("offset", offset);

            List<OrderDetails> orderDetailsByOrderId = orderDAO.getOrderDetailsByOrderId(orderId);
            boolean updateProQuan = false;
            if (orderDetailsByOrderId.size() > 0) {
                for (int i = 0; i < orderDetailsByOrderId.size(); i++) {
                    int quantity = orderDetailsByOrderId.get(i).getOrderDetailQuantity();
                    int proId = orderDetailsByOrderId.get(i).getProductId().getProductId();
                    updateProQuan = orderDAO.updateProQuan(proId, quantity);
                }
            }

            if (updateOrderAdminId && updateProQuan) {
                model.addAttribute("updateAdminIdStt", "Duyệt đơn hàng thành công!");
            } else {
                model.addAttribute("updateAdminIdStt", "Duyệt đơn hàng thất bại!");
            }
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    public float getTotal(List<OrderDetails> odt) {
        float totalPrice = 0;
        for (OrderDetails o : odt) {
            totalPrice += o.getOrderDetailCurrentPrice() * o.getOrderDetailQuantity();
        }
        return totalPrice;
    }

    //Bảng Customers
    @RequestMapping(value = "customer")
    public String loadCus(Model model, Integer offset, Integer maxResult, HttpSession session) {
        String view;
        if (CheckUrl.check(session)) {
            view = "backend/customer";
            model.addAttribute("listCus", customerDAO.getAll(offset, maxResult));
            model.addAttribute("total", customerDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchCus.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertCus")
    public String initInsertCus(Model model) {
        model.addAttribute("newCus", new Customers());
        return "backend/insertCustomer";
    }

    @RequestMapping(value = "/insertCustomer")
    public String insertCus(@ModelAttribute(value = "newCus") Customers newCus, Model model) {
        boolean check = customerDAO.add(newCus);
        if (check) {
            return "redirect:/admin/customer.htm";
        } else {
            model.addAttribute("message", "Thêm mới thất bại!");
            return "backend/insertCustomer";
        }
    }

    @RequestMapping(value = "/delCus")
    public String delCus(@RequestParam("cusId") Integer cusId, Model model) {
        boolean bl = customerDAO.del(cusId);

        if (bl) {
            return "redirect:/admin/customer.htm";
        } else {
            model.addAttribute("delMessage", "Xóa danh mục thất bại!");
            return "backend/customer";
        }
    }

    //Feedbacks
    @RequestMapping(value = "/feedback")
    public String loadfb(Model model, Integer offset, Integer maxResult, HttpSession session) {
        String view;
        if (CheckUrl.check(session)) {
            view = "backend/feedback";
            model.addAttribute("listF", feedBackDAO.getAll(offset, maxResult));
            model.addAttribute("total", feedBackDAO.getFeedbackRecord());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchfb.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "delfb")
    public String delfb(@RequestParam(value = "id") Integer id, Model model) {
        boolean del = feedBackDAO.del(id);
        if (del) {
            return "redirect:/admin/feedback.htm";
        } else {
            model.addAttribute("delMessage", "Xóa danh mục thất bại!");
            return "backend/feedback";
        }
    }

    /**
     * Xư lí khi đăng nhập
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/initLogin")
    public String initBackendLogin(Model model) {
        Admins admin = new Admins();
        model.addAttribute("admin", admin);
        return "backend/login";
    }

    /**
     * Kiểm tra thông tin đăng nhập
     *
     * @param admin
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String backendLogin(@ModelAttribute("admin") Admins admin, HttpSession session, Model model) {
        Admins ad = adminDAO.checkLogin(admin);
        if (ad != null) {
            session.setAttribute("admin", ad.getAdminName());
            return "redirect:/admin/home.htm";
        } else {
            model.addAttribute("message", "Sai thông tin đăng nhập.");
            return "backend/login";
        }
    }

    /**
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/logout")
    public String backendLogout(HttpSession session, Model model) {
        session.invalidate();
        Admins admin = new Admins();
        model.addAttribute("admin", admin);
        return "backend/login";
    }

    @RequestMapping(value = "/preUpdateCategory")
    public String preUpdateCategory(@RequestParam("categoryId") Integer categoryId, Model model) {
        model.addAttribute("cate", categoryDAO.getCategoryById(categoryId));
        return "/backend/updateCategory";
    }

    @RequestMapping(value = "/updateCategory")
    public String doUpdateCategory(@ModelAttribute("cate") Categories c, Model model, Integer offset, Integer maxResult) {
        boolean bl = categoryDAO.update(c);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listCate", categoryDAO.getAll(offset, maxResult));
            model.addAttribute("total", categoryDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/category";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updateCategory";
        }
    }

    @RequestMapping(value = "/preUpdatePublisher")
    public String preUpdatePublisher(@RequestParam("publisherId") Integer publisherId, Model model) {
        model.addAttribute("pub", publisherDAO.getPublisherById(publisherId));
        return "/backend/updatePublisher";
    }

    @RequestMapping(value = "/updatePublisher")
    public String doUpdatePublisher(@ModelAttribute("pub") Publishers p, Model model, Integer offset, Integer maxResult) {
        boolean bl = publisherDAO.update(p);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listPub", publisherDAO.getAll(offset, maxResult));
            model.addAttribute("total", publisherDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/publisher";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updatePublisher";
        }
    }

    @RequestMapping(value = "/preUpdateCountry")
    public String preUpdateCountry(@RequestParam("countryId") Integer countryId, Model model) {
        model.addAttribute("country", countryDAO.getCountryById(countryId));
        return "/backend/updateCountry";
    }

    @RequestMapping(value = "/updateCountry")
    public String doUpdateCountry(@ModelAttribute("country") Countries c, Model model, Integer offset, Integer maxResult) {
        boolean bl = countryDAO.update(c);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listC", countryDAO.getAll(offset, maxResult));
            model.addAttribute("total", countryDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/country";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updateCountry";
        }
    }

    @RequestMapping(value = "/preUpdateCustomer")
    public String preUpdateCustomer(@RequestParam("customerId") Integer customerId, Model model) {
        model.addAttribute("customer", customerDAO.getCustomerById(customerId));
        return "/backend/updateCustomer";
    }

    @RequestMapping(value = "/updateCustomer")
    public String doUpdateCustomer(@ModelAttribute("customer") Customers c, Model model, Integer offset, Integer maxResult) {
        boolean bl = customerDAO.update(c);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listCus", customerDAO.getAll(offset, maxResult));
            model.addAttribute("total", customerDAO.getTotal());
            model.addAttribute("offset", offset);
            return "/backend/customer";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updateCustomer";
        }
    }

    @RequestMapping(value = "/preUpdateAdmin")
    public String preUpdateAdmin(@RequestParam("id") Integer id, Model model
    ) {
        model.addAttribute("adminn", adminDAO.getAdminById(id));
        return "/backend/updateAdmin";
    }

    @RequestMapping(value = "/updateAdmin")
    public String doUpdateAdmin(@ModelAttribute("adminn") Admins a, Model model, Integer offset, Integer maxResult) {
        boolean bl = adminDAO.update(a);
        if (bl) {
            model.addAttribute("status", "Update successfully!");
            model.addAttribute("listA", adminDAO.getAll(offset, maxResult));
            return "/backend/admin";
        } else {
            model.addAttribute("status", "Update failed!");
            return "/backend/updateAdmin";
        }
    }

    @RequestMapping(value = "/admin")
    public String loadAdmin(Model model, Integer offset, Integer maxResult, HttpSession session) {
        String view;
        if (CheckUrl.check(session)) {
            view = "backend/admin";
            model.addAttribute("listA", adminDAO.getAll(offset, maxResult));
            model.addAttribute("total", adminDAO.getTotal());
            model.addAttribute("offset", offset);
            model.addAttribute("action", "searchAdmin.htm");
        } else {
            view = "backend/login";
            Admins admin = new Admins();
            model.addAttribute("admin", admin);
        }
        return view;
    }

    @RequestMapping(value = "/initInsertAdmin")
    public String initInsertAdmin(Model model) {
        model.addAttribute("newAdmin", new Admins());
        return "backend/insertAdmin";
    }

    @RequestMapping(value = "/insertAdmin")
    public String insertAdmin(@ModelAttribute(value = "newAdmin") Admins newAdmin, Model model) {
        boolean add = adminDAO.add(newAdmin);
        if (add) {
            return "redirect:/admin/admin.htm";
        } else {
            model.addAttribute("message", "Thêm mới thất bại!");
            return "backend/insertAdmin";
        }
    }

    @RequestMapping(value = "/delAdmin")
    public String delAdmin(@RequestParam(value = "id") Integer id, Model model) {
        boolean del = adminDAO.del(id);
        if (del) {
            return "redirect:/admin/admin.htm";
        } else {
            model.addAttribute("delMessage", "Xóa thất bại!");
            return "backend/admin";
        }
    }

    @RequestMapping(value = "/searchPro")
    public String searchPro(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listP", productDAO.searchProductByName(name, offset, maxResult));
        model.addAttribute("total", productDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        model.addAttribute("key", name);
        model.addAttribute("action", "searchPro.htm");
        return "backend/searchPro";
    }

    @RequestMapping(value = "/searchCate")
    public String searchCate(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listCate", categoryDAO.search(name, offset, maxResult));
        model.addAttribute("total", categoryDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/category";
    }

    @RequestMapping(value = "/searchAu")
    public String searchAu(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listAu", authorDAO.search(name, offset, maxResult));
        model.addAttribute("total", authorDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/author";
    }

    @RequestMapping(value = "/searchC")
    public String searchC(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listC", countryDAO.search(name, offset, maxResult));
        model.addAttribute("total", countryDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/country";
    }

    @RequestMapping(value = "/searchPub")
    public String searchPub(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listPub", publisherDAO.search(name, offset, maxResult));
        model.addAttribute("total", publisherDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/publisher";
    }

    @RequestMapping(value = "/searchAdmin")
    public String searchAdmin(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listA", adminDAO.search(name, offset, maxResult));
        model.addAttribute("total", adminDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/admin";
    }

    @RequestMapping(value = "/searchfb")
    public String searchfb(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listF", feedBackDAO.search(name, offset, maxResult));
        model.addAttribute("total", feedBackDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/feedback";
    }

    @RequestMapping(value = "/searchCus")
    public String searchCus(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listCus", customerDAO.search(name, offset, maxResult));
        model.addAttribute("total", customerDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/customer";
    }

    @RequestMapping(value = "/searchOd")
    public String searchOd(Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
        String name = request.getParameter("name");
        model.addAttribute("listOrder", orderDAO.search(name, offset, maxResult));
        model.addAttribute("total", orderDAO.getTotalSearch(name));
        model.addAttribute("offset", offset);
        return "backend/order";
    }

//    @RequestMapping (value = "/searchOdt")
//    public String searchOdt (Model model, Integer offset, Integer maxResult, HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String id = request.getParameter("id");
//        model.addAttribute("lstOrderDetails", orderDAO.searchOdt(Integer.parseInt(id), name, offset, maxResult));
//        model.addAttribute("total", orderDAO.getTotalSearchOdt(Integer.parseInt(id), name));
//        model.addAttribute("offset", offset);
//        return "backend/order";
//    }
}
