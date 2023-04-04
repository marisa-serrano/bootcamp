package org.academiadecodigo.wizards.controller;

import org.academiadecodigo.wizards.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String showCustomerDetails (Model model) {
        Customer customer = new Customer();
        customer.setName("Rui Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone(999657890);

        model.addAttribute("customer", customer);
        return "index";
    }
}
