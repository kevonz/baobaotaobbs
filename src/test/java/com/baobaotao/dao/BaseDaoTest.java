/*
 * Created on 13-1-7
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright @2013 the original author or authors.
 */
package com.baobaotao.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.DatabaseUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Description of this file.
 *
 * @author XiongNeng
 * @version 1.0
 * @since 13-1-7
 */
@SpringApplicationContext({"classpath:baobaotao-dao.xml"})
public class BaseDaoTest extends UnitilsJUnit4 {
    protected static final Logger log = LoggerFactory.getLogger(BaseDaoTest.class);
    @Test
    public void goodLuck() {
        log.info("-------good luck-------");
    }

    @Before
    public void before() {
        log.info("----------before test method, flush all data-----");
        // DatabaseUnitils.flushDatabaseUpdates();
        DatabaseUnitils.commitTransaction();
    }
    @After
    public void after() {
        log.info("----------after test method, start new transaction-----");
        DatabaseUnitils.startTransaction();
    }
}
