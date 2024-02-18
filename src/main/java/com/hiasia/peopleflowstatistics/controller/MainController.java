package com.hiasia.peopleflowstatistics.controller;

import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import com.hiasia.peopleflowstatistics.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people-flow")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public PersonFlow peopleFlow(@RequestParam String imageUrl, @RequestParam(defaultValue = "false", required = false) String show) throws Exception {
        return mainService.httpGet(imageUrl, show);
    }

    @GetMapping("/last-day-person-number")
    public Object lastDayPersonNumber() {
        return mainService.lastDayPersonNumber();
    }
}
