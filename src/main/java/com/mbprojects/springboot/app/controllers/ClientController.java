package com.mbprojects.springboot.app.controllers;

import com.mbprojects.springboot.app.models.dao.IClientDao;
import com.mbprojects.springboot.app.models.entity.Client;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

  @Autowired
  @Qualifier("clientDaoJpa")
  private IClientDao clientDao;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("title", "List of clients");
    model.addAttribute("clients", clientDao.findAll());
    return "list";
  }

  @RequestMapping(value = "/form")
  public String create(Map<String, Object> model) {
    Client client = new Client();
    model.put("client", client);
    model.put("title", "Client's Form");
    return "form";
  }

  @RequestMapping(value = "/form", method = RequestMethod.POST)
  public String save(@Valid Client client, BindingResult result, Model model) { //THe errors are automatically sent to the view if the parameter is named the same as the class
    if(result.hasErrors()){                                                     //that´s the case here the class is Client and the sent attribute is client. If this wasn´t the case
      model.addAttribute("title", "Client´s Form");      // We will need to indicate springboot what´s the attribute type with tag @ModelAttribute("clientShared")
      return "form";
    }
    clientDao.save(client);
    return "redirect:list";
  }

}
