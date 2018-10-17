/*Copyright (c) 2018-2019 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.testingleaveproject17thoct.salesdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testingleaveproject17thoct.salesdb.Leads;

/**
 * Specifies methods used to obtain and modify Leads related information
 * which is stored in the database.
 */
@Repository("salesdb.LeadsDao")
public class LeadsDao extends WMGenericDaoImpl<Leads, Integer> {

    @Autowired
    @Qualifier("salesdbTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}