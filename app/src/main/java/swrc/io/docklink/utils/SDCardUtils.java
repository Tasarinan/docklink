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

import android.os.Environment;

/**
 * Created by NetHead on 2015/10/24.
 */
public class SDCardUtils
{
    private SDCardUtils()
    {
        /*Cannot be instantiated*/
        throw new UnsupportedOperationException("cannot be instantiated")
    }

    /**
     * Detect the Media SD Card usable
     * @return true if Media card is mounted
     */

    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
