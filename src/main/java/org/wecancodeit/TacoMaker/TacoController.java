package org.wecancodeit.TacoMaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TacoController {

    @Resource
    private ToppingRepository toppingRepo;

    @Resource
    private TacoRepository tacoRepo;

    @RequestMapping("/Tacos")
    public String displayAllTacos(Model model) {
        model.addAttribute("TacosModel", tacoRepo.findAll());
        return "TacosView";
    }
}
