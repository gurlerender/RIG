package com.rig.ReadingIsGoodApp.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.rig.ReadingIsGoodApp.serviceparam.ServiceResponse;
import com.rig.ReadingIsGoodApp.serviceparam.Statistics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StatisticsService {
	
	public ServiceResponse<List<Statistics>> getStatisticsForCustomers(){
		ServiceResponse<List<Statistics>> response = new ServiceResponse<List<Statistics>>();
		
		
		return response;
	}
}
