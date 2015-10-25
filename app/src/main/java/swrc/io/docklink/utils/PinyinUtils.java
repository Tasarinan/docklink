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

package swrc.io.docklink.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by NetHead on 2015/10/25.
 */
public class PinyinUtils
{
    /**
     * Get First PINYIN char of Chinese world. no change for number and Engilish etc.
     *
     * @param chineseStr
     * @return
     */
    public static String getFirstPinyinCharOfChinese(String chineseStr)
    {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chineseStr.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 128)
            {
                try
                {
                    String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (_t != null)
                    {
                        pybf.append(_t[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e)
                {
                    e.printStackTrace();
                }
            } else
            {
                pybf.append(arr[i]);
            }

        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }

    /**
     * Get Pinyin charactor of  Chinese Word. no change other
     *
     * @param chineseStr
     * @return
     * @TODO, return multiple Pinyin
     */

    public static String getPinyinString(String chineseStr)
    {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chineseStr.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 128)
            {
                try
                {
                    pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e)
                {
                    e.printStackTrace();
                }
            } else
            {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString();
    }
}
