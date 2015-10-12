package drinkup.spring.controllers;

import drinkup.spring.domain.Pub;
import drinkup.spring.services.pub.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PubController {

    private PubService pubService;

    @Autowired
    public void setPubService(PubService pubService) {
        this.pubService = pubService;
    }

    @RequestMapping(value = "/pubs", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pubs", pubService.listAllPubs());
        return "pubs";
    }

    @RequestMapping("pub/{id}")
    public String showPub(@PathVariable int id, Model model){
        model.addAttribute("pub", pubService.getPubById(id));
        return "pubshow";
    }

    @RequestMapping("pub/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("pub", pubService.getPubById(id));
        return "pubform";
    }

    @RequestMapping("pub/new")
    public String newPub(Model model){
        model.addAttribute("pub", new Pub());
        return "pubform";
    }

    @RequestMapping(value = "pub", method = RequestMethod.POST)
    public String savePub(Pub pub){
        pubService.savePub(pub);
        return "redirect:/pub/" + pub.getIdEnterprise();
    }

    @RequestMapping("pub/delete/{id}")
    public String delete(@PathVariable int id){
        pubService.deletePub(id);
        return "redirect:/pubs";
    }

}
