package com.tyss.trainingmaintenance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.trainingmaintenance.dto.BatchIdGenerator;
import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.Response;
import com.tyss.trainingmaintenance.service.ServiceDAO;

@RestController
@RequestMapping("/trainingmaintenance")
public class BatchController {
	
	@Autowired
	private ServiceDAO service;
	
	@Autowired
	private BatchIdGenerator generator;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping(path="/batch",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response registerBatch(@RequestBody BatchInfo batch) {
		Response response = new Response();
		
		if(generator.generate(batch)) {
			BatchInfo info = service.addBatch(batch);
			response.setStatusCode(200);
			response.setMessage("Batch has been registered successfully");
			response.setBatchCode(info.getBatchCode());
		}
		else{
			response.setStatusCode(400);
			response.setMessage("Batch registration failed");
		}
		
		return response;
	}

}
