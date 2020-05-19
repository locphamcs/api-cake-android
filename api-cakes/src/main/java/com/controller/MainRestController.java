package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CakeDao;
import com.model.Cake;
import com.mysql.cj.log.Log;

@Controller
public class MainRestController {
    @Autowired
    private CakeDao giamkhaoDaoList;
    //private GiamkhaoDao giamkhaoDao;
    @RequestMapping("/hello")
    @ResponseBody
    public String welcome() {
    	System.out.println("ok");
        return "Welcome to Cakes.";
    }

    @RequestMapping(value = "/cakes", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List <Cake> getGiam() {
        List <Cake> list = giamkhaoDaoList.getAllCakes();
        return list;
    }
    
    @RequestMapping(value = "/cakes/{ID}", 
            method = RequestMethod.GET, 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Cake getCake_1(@PathVariable("ID") int ID) {
    	System.out.println("Test Cake cakes/ID OK");
    	return giamkhaoDaoList.getCake(ID);
    }
    
    @RequestMapping(value="/cakes1",
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Cake getCake_2(@RequestParam("ID") int ID) {
    	System.out.println("Test Cake cakes?ID=?");
    	return giamkhaoDaoList.getCake(ID);
    }
    
    @RequestMapping(value="/cakes/mabanh/{ID}",
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Cake> getListMaBanh(@PathVariable("ID") int ID) {
    	List <Cake> list = giamkhaoDaoList.getListMaBanh(ID);
    	System.out.println("Test Get Ma Banh");
    	return list;
    }
    
    @RequestMapping(value = "/addcakes", 
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void addCake(@RequestBody Cake cake) {
        giamkhaoDaoList.addCake(cake);
    }
    
    @RequestMapping(value = "/cakes", 
            method = RequestMethod.PUT, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Cake updateCake(@RequestBody Cake cake) {
 
        return giamkhaoDaoList.updateCake(cake);
    }
 
    @RequestMapping(value = "/cakes/{ID}", 
            method = RequestMethod.DELETE, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteCake(@PathVariable("ID") int ID) {
        giamkhaoDaoList.deleteCake(ID);
    }
    
    
}
