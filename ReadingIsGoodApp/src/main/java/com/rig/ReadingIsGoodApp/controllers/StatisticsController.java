package com.rig.ReadingIsGoodApp.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rig.ReadingIsGoodApp.service.StatisticsService;
import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;
import com.rig.ReadingIsGoodApp.serviceparam.Statistics;

public class StatisticsController {
private final StatisticsService statisticsService;
	
	public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
	
	@GetMapping
    @RequestMapping("/getStatisticsForCustomers")
    public ServiceResponse<List<Statistics>> getStatisticsForCustomers() {
    	ServiceResponse<List<Statistics>> response = statisticsService.getStatisticsForCustomers();
        return response;
	}
}
