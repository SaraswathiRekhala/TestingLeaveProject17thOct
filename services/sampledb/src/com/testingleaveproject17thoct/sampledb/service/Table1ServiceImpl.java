/*Copyright (c) 2018-2019 fico.com All Rights Reserved.
 This software is the confidential and proprietary information of fico.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with fico.com*/
package com.testingleaveproject17thoct.sampledb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testingleaveproject17thoct.sampledb.Table1;


/**
 * ServiceImpl object for domain model class Table1.
 *
 * @see Table1
 */
@Service("sampledb.Table1Service")
@Validated
public class Table1ServiceImpl implements Table1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table1ServiceImpl.class);


    @Autowired
    @Qualifier("sampledb.Table1Dao")
    private WMGenericDao<Table1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "sampledbTransactionManager")
    @Override
    public Table1 create(Table1 table1) {
        LOGGER.debug("Creating a new Table1 with information: {}", table1);

        Table1 table1Created = this.wmGenericDao.create(table1);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(table1Created);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public Table1 getById(Integer table1Id) {
        LOGGER.debug("Finding Table1 by id: {}", table1Id);
        return this.wmGenericDao.findById(table1Id);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public Table1 findById(Integer table1Id) {
        LOGGER.debug("Finding Table1 by id: {}", table1Id);
        try {
            return this.wmGenericDao.findById(table1Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Table1 found with id: {}", table1Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public List<Table1> findByMultipleIds(List<Integer> table1Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Table1s by ids: {}", table1Ids);

        return this.wmGenericDao.findByMultipleIds(table1Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "sampledbTransactionManager")
    @Override
    public Table1 update(Table1 table1) {
        LOGGER.debug("Updating Table1 with information: {}", table1);

        this.wmGenericDao.update(table1);
        this.wmGenericDao.refresh(table1);

        return table1;
    }

    @Transactional(value = "sampledbTransactionManager")
    @Override
    public Table1 delete(Integer table1Id) {
        LOGGER.debug("Deleting Table1 with id: {}", table1Id);
        Table1 deleted = this.wmGenericDao.findById(table1Id);
        if (deleted == null) {
            LOGGER.debug("No Table1 found with id: {}", table1Id);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), Table1.class.getSimpleName(), table1Id);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "sampledbTransactionManager")
    @Override
    public void delete(Table1 table1) {
        LOGGER.debug("Deleting Table1 with {}", table1);
        this.wmGenericDao.delete(table1);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public Page<Table1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public Page<Table1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service sampledb for table Table1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service sampledb for table Table1 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "sampledbTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}