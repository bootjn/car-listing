package com.example.demo;



import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller

public class HomeController {




    @Autowired
    CarRepository carRepository;


    @Autowired
    CateRepository cateRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listCars(Model model) {


        /*Car car = new Car();
        car.setBrand("honda");

        Cate cate = new Cate();
        cate.setCatetype("bicycle");

        car.setCate(cate);

        carRepository.save(car);*/

       // model.addAttribute("cars", carRepository.findAll());




        Car car = new Car();
        car.setBrand("honda");

        Cate cate = new Cate();
        cate.setCatetype("bicycle");

        Set<Cate> cates = new HashSet<Cate>();
        cates.add(cate);

        cate = new Cate();
        cate.setCatetype("tricycle");

        car.setCates(cates);

        carRepository.save(car);

        //model.addAttribute("cars", carRepository.findAll());









        model.addAttribute("cars", carRepository.findAll());
        return "list";
    }



    @GetMapping("/add")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping("/add")
    public String processCar(@Valid @ModelAttribute("car") Car car,
                              @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            System.out.println("Picture is empty");
            return "redirect:/add";
        }
        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            car.setPictureUrl(uploadResult.get("url").toString());





            carRepository.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id));
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id) {
        carRepository.deleteById(id);
        return "redirect:/";
    }

   //




    @GetMapping("/addcategory")
    public String newCate(Model model) {
        model.addAttribute("cate", new Cate());
        return "cateform";
    }

    @PostMapping("/addcategory")
    public String processCate(@Valid  Cate cate
                             ) {



            //cate.setPictureUrl(uploadResult.get("url").toString());





            cateRepository.save(cate);

        return "redirect:/";
    }

    @RequestMapping("/catedetail/{id}")
    public String showCate(@PathVariable("id") long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }

}
