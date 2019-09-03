package com.apri.test.controller;

import com.apri.test.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/krs-")
public class KrsController {

    @Autowired
    private KrsService krsService;

    @GetMapping(path = "/update/{nim}")
    public String viewUpdate(Model model, @PathVariable(value = "nim") int nim){
        model.addAttribute("dataSets", krsService.findByNim(nim));
        return "/krs/update";
    }


    @GetMapping(path = "")
    public String viewData(Model model, @RequestParam(value = "search", required = false) Integer param,
                           @RequestParam(value = "filter", required = false) Integer param1) {
        if (param == null && param1 == null) {
            model.addAttribute("dataSets", krsService.findAll());
        } else {
            System.out.println("t");
        }
        return "/krs/list";
    }



}
