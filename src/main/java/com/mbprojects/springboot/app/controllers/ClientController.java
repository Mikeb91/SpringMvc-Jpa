package com.mbprojects.springboot.app.controllers;

import com.mbprojects.springboot.app.models.entity.Client;
import com.mbprojects.springboot.app.models.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("client") //This is how we manage to persist client info without the hidden field "id" in form view
public class ClientController {

  @Autowired
  private IClientService clientService; //Using this class service (facade) we avoid using DAOs directly, which is a good practice

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("title", "List of clients");
    model.addAttribute("clients", clientService.findAll());
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
  public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status) { //THe errors are automatically sent to the view if the parameter is named the same as the class
    if(result.hasErrors()){                                                     //that´s the case here the class is Client and the sent attribute is client. If this wasn´t the case
      model.addAttribute("title", "Client´s Form");      // We will need to indicate springboot what´s the attribute type with tag @ModelAttribute("clientShared")
      return "form";
    }
    clientService.save(client);
    status.setComplete(); //client persisted info is removed from session
    return "redirect:list";
  }

  @RequestMapping(value = "/form/{id}")
  public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model) {
    Client client;
    if(id>0){
      client = clientService.findOne(id);
    } else {
      return "redirect:/list";
    }
    model.put("client", client);
    model.put("title", "Edit a Client");
    return "form";
  }

  @RequestMapping(value = "/delete/{id}")
  public String delete(@PathVariable(value = "id") Long id) {
    if(id > 0) {
      clientService.delete(id);
    }
    return "redirect:/list";
  }
}