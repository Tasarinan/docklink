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
import android.os.StatFs;
import android.util.Log;

import java.io.File;

/**
 * Created by NetHead on 2015/10/24.
 */
public class SDCardUtils
{
    private SDCardUtils()
    {
        /*Cannot be instantiated*/
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable()
    {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state))
        {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable()
    {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
        {
            return true;
        }
        return false;
    }

    public File getAlbumStorageDir(String albumName)
    {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs())
        {
           // Log.e(LOG_TAG, "Directory not created");
        }
        return file;
    }

    /**
     * Detect the Media SD Card usable
     * @return true if Media card is mounted
     */

    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * Get the file path of SD Card
     *
     * @return
     */
    public static String getSDCardPath()
    {
        if(isSDCardEnable())
        {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        }
        return null;
    }

    /**
     * Get SDK left space(Unit, byte)
     *
     * @return
     */

    public static long getSDCardAllSize()
    {
        if (isSDCardEnable())
        {
            StatFs statfs = new StatFs(getSDCardPath());
            //Get numbers of  free available Blocks
            long availableBlocks = statfs.getAvailableBlocksLong() - 4;
            //Get the size of single data block(Byte)
            long blockSize = statfs.getBlockSizeLong();
            return blockSize * availableBlocks;
        }
        return 0;
    }

    /**
     * Get the left space size of specific file path
     *
     * @param filePath
     * @return capacity of space. can be SD card(External) or Internal(Data)
     */

    public static long getAvailableSpaceByFilePath(String filePath)
    {
        String tempPath = "";
        if (filePath.startsWith(getSDCardPath()))
        {
            tempPath = getSDCardPath();
        } else
        {
            tempPath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs statfs = new StatFs(tempPath);
        long availableBlocks = statfs.getAvailableBlocksLong() - 4;
        return statfs.getBlockSizeLong() * availableBlocks;
    }

    /**
     * Get system root directory
     * @return
     */

    public static String getRootDirectoryPath()
    {
        return Environment.getRootDirectory().getAbsolutePath();
    }


}
