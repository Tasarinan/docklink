/*
 * Copyright 2015 NetHead Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * NetHead - initial API and implementation
 */

package swrc.io.docklink.test.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import swrc.io.docklink.utils.PinyinUtils;

import static org.junit.Assert.*;

/**
 * Created by NetHead on 2015/10/25.
 */
public class PinyinUtilsTest
{

    @Before
    public void setUp()
    {

    }
    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testGetFirstSpellCharOfChinese() throws Exception
    {
        String x="复伊者联盟2-.wei威虚空";
        assertEquals(PinyinUtils.getFirstPinyinCharOfChinese(x), "fyzlm2weiwxk");

    }

    @Test
    public void testGetPinyinString() throws Exception
    {

        String x="复伊者联盟2-.wei威虚空";
        assertEquals(PinyinUtils.getPinyinString(x),"fuyizhelianmeng2-.weiweixukong");


    }
}