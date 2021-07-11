package pl.sda.humanresource.web;

import pl.sda.humanresource.api.model.NewWorker;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.humanresource.service.WorkerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/worker")
@AllArgsConstructor
public class WorkerController {

    private WorkerService workerService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public ModelAndView displayWorkerPage(){
        ModelAndView mav = new ModelAndView("workers");
        mav.addObject("workers", workerService.getAllWorkers());
        return mav;
    }


    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView displayAddWorkerPage(){
        ModelAndView mav = new ModelAndView("addWorker");
        mav.addObject("addWorker", new NewWorker());
        return mav;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public String handleAddWorker(@Valid @ModelAttribute NewWorker newWorker, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addWorker";
        }

        workerService.registerWorker(newWorker);

        return "redirect:/worker";
    }

}
