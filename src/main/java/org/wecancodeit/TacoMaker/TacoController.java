package org.wecancodeit.TacoMaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Optional;

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

    @PostMapping("/add-taco")
    public String addTaco(@RequestParam String name, @RequestParam String shell, @RequestParam String topping) {
        Topping toppingToAdd;
        Optional<Topping> toppingToAddOptional = toppingRepo.findByToppingType(topping);

        if (toppingToAddOptional.isEmpty()) {
            toppingToAdd = new Topping(topping);
            toppingRepo.save(toppingToAdd);
        }
        else {
            toppingToAdd = toppingToAddOptional.get();
        }

        Optional<Taco> tacoToAddOptional = tacoRepo.findByName(name);

        if (tacoToAddOptional.isEmpty()) {
            Taco tacoToAdd = new Taco(name, shell, toppingToAdd);
            tacoRepo.save(tacoToAdd);
        }
        return "redirect:/Tacos";
    }
}
