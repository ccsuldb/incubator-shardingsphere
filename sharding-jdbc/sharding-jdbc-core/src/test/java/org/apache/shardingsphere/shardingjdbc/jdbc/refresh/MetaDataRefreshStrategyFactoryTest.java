/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shardingjdbc.jdbc.refresh;

import org.apache.shardingsphere.shardingjdbc.jdbc.refreh.MetaDataRefreshStrategyFactory;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.AlterIndexStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.AlterTableStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.CreateIndexStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.CreateTableStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.DropIndexStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.DropTableStatementContext;
import org.apache.shardingsphere.sql.parser.binder.statement.ddl.TruncateStatementContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MetaDataRefreshStrategyFactoryTest {
    
    @Mock
    private CreateTableStatementContext createTableStatementContext;
    
    @Mock
    private CreateIndexStatementContext createIndexStatementContext;
    
    @Mock
    private AlterIndexStatementContext alterIndexStatementContext;
    
    @Mock
    private AlterTableStatementContext alterTableStatementContext;
    
    @Mock
    private DropIndexStatementContext dropIndexStatementContext;
    
    @Mock
    private DropTableStatementContext dropTableStatementContext;
    
    @Mock
    private TruncateStatementContext truncateStatementContext;
    
    @Test
    public void assertNewInstance() {
        assertThat(MetaDataRefreshStrategyFactory.newInstance(createTableStatementContext).isPresent(), is(true));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(createIndexStatementContext).isPresent(), is(true));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(alterIndexStatementContext).isPresent(), is(false));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(alterTableStatementContext).isPresent(), is(true));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(dropIndexStatementContext).isPresent(), is(true));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(dropTableStatementContext).isPresent(), is(true));
        assertThat(MetaDataRefreshStrategyFactory.newInstance(truncateStatementContext).isPresent(), is(false));
    }
}

