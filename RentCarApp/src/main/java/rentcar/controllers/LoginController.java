package rentcar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rentcar.dto.CustomerAddressDataDTO;
import rentcar.dto.CustomerDataDTO;
import rentcar.dto.UserDto;
import rentcar.facade.AddCustomerFullDetailsFacade;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController
{
//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public String getLogin(@RequestParam(value= "testValueName", required = true) String referintaString, Model model) throws ServletException
//    {
//        if (referintaString==null){
//            model.addAttribute("userModel", new UserDto());
//        }
//        return "login";
//    }


//    @RequestMapping(value="/exemplu" , method = RequestMethod.POST)
//    public String postLogin(@ModelAttribute("userModel") UserDto user) throws ServletException
//    {
//       user.getName();
//
//        return "login";
//    }


    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    AddCustomerFullDetailsFacade addCustomerFullDetailsFacade;

    @Autowired


    @RequestMapping(value="/login" , method = RequestMethod.GET)
    public ModelAndView getLogin()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("customerDataString", new CustomerDataDTO());

        return new ModelAndView("login", "loginData", map);
    }

    @RequestMapping(value="/login" , method = RequestMethod.POST)
    public void postRegister(@ModelAttribute("loginData") CustomerDataDTO customerDataDTO)
    {
        addCustomerFullDetailsFacade.addCustomerData(customerDataDTO);
    }
}
