package com.sportyshoes.auth.web;

import com.sportyshoes.auth.model.Product;
import com.sportyshoes.auth.model.User;
import com.sportyshoes.auth.model.Users;
import com.sportyshoes.auth.service.ProductService;
import com.sportyshoes.auth.service.SecurityService;
import com.sportyshoes.auth.service.UserService;
import com.sportyshoes.auth.service.UsersListService;
import com.sportyshoes.auth.validator.UserValidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UsersListService usersListService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
    
    @GetMapping("/passChange")
    public String hello1(Model model) {
    	return "passChange";
    }
    
    @PostMapping("/resetPassword")
    public String hello2(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    	securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
    	
    	return "redirect:/welcome";
    }
    
    @GetMapping("/resetPassword")
    public String registration1(Model model) {
        model.addAttribute("userForm", new User());

        return "redirect:/welcome";
    }
    
    @GetMapping("/users")
    public String home(Model model) {
    	List<Users> list = usersListService.findAll();
    	for (Users note : list) {
            System.out.println(note.getEmail());
            System.out.println(note.getFirstName());
            System.out.println(note.getLastName());
            System.out.println(note.getPassword());
        }
    	System.out.println("99999999999999999999999999999999");
        model.addAttribute("users", list);
        return "users";
    }
    
    @GetMapping("/product")
    public String product(Model model) {
    	List<Product> listProducts = productService.findAll();
        model.addAttribute("lists", listProducts);
        System.out.println("---------------------------");
        for (Product note : listProducts) {
            System.out.println(note.getName());
        }
        return "product";
    }

    @RequestMapping("/edit/{id}")
    public String showEditProductPage(Model model, @PathVariable(name = "id") int id) {
        Product product = productService.get(id);
        System.out.println("+++++++++++++++++++++++++++");
        model.addAttribute("product", product);
        System.out.println(product.getName());
        return "edit";
    }
    
    @RequestMapping(value = "/update_product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
    	System.out.println("00000000000000000000000000000000");
    	productService.save(product);
         
        return "redirect:/welcome";
    }

    
}
