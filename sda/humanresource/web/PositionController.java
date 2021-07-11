package pl.sda.humanresource.web;

import org.springframework.context.annotation.Bean;
import pl.sda.humanresource.api.model.NewWork;
import pl.sda.humanresource.config.WorkTypeConfig;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.humanresource.service.PositionService;
import pl.sda.humanresource.service.WorkerService;
import pl.sda.humanresource.web.model.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/position")
@AllArgsConstructor
//@PreAuthorize("isAuthenticated()")
public class PositionController {

    private PositionService positionService;
    private WorkerService workerService;
    private WorkTypeConfig workTypeConfig;


    @GetMapping
    public ModelAndView displayAddWorkPage() {
        ModelAndView mav = new ModelAndView("addWork");
        mav.addObject("newWork", new NewWork());
        mav.addObject("workers", prepareWorkers());
        mav.addObject("types", prepareTypes());
        return mav;
    }

    @PostMapping
    public String handleAddWork(@ModelAttribute NewWork newWork) {
        positionService.planWork(newWork);
        return "main";
    }

    private List<Dictionary> prepareWorkers() {
        return workerService.getAllWorkers().stream()
                .map(work -> new Dictionary(work.getId().toString(), work.getFirstName() + " " + work.getLastName()))
                .collect(Collectors.toList());
    }

    private List<Dictionary> prepareTypes() {
        return workTypeConfig.getTypes() == null ? new ArrayList() : workTypeConfig.getTypes()
                .stream()
                .map(type -> new Dictionary(type, type.toUpperCase()))
                .collect(Collectors.toList());
//        return workTypeConfig.getTypes()
//                .stream()
//                .map(type -> new Dictionary(type, type.toUpperCase()))
//                .collect(Collectors.toList());
    }

}
