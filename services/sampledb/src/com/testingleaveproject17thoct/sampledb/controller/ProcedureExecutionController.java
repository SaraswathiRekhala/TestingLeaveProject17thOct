/*Copyright (c) 2018-2019 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.testingleaveproject17thoct.sampledb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import com.testingleaveproject17thoct.sampledb.service.SampledbProcedureExecutorService;

@RestController(value = "Sampledb.ProcedureExecutionController")
@RequestMapping("/sampledb/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {


    @Autowired
    private SampledbProcedureExecutorService procedureService;


}