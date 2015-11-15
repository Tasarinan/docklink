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

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okio.BufferedSink;
import okio.Okio;
import swrc.io.docklink.models.Photo;
import swrc.io.docklink.models.PhotoResponse;
import swrc.io.docklink.models.SearchResponse;

/**
 * Created by NetHead on 2015/11/8.
 */
public class DoubanUtil
{

    // static final String downloadPath = "/Users/rayboot/Downloads/info";
    static final String INFO_FILE_NAME = "info";
    static final String PHOTO_INFO_FILE_NAME = "photoinfo";
    static final String apikey = "0df993c66c0c636e29ecbb5344252a4a";
    static final String searchUrl =
            "https://api.douban.com/v2/movie/search?q=%s";
    static final String infoUrl = "https://api.douban.com/v2/movie/subject/%s";
    static final String imageContentUrl =
            "https://api.douban.com/v2/movie/subject/%s/photos?apikey="
                    + apikey
                    + "&count=100";
    static OkHttpClient client = new OkHttpClient();

    public static String doSearch(String name) throws IOException
    {
        String url = String.format(searchUrl, name);
        SearchResponse response = new Gson().fromJson(new DoubanUtil().run(url), SearchResponse.class);
        if (response.getSubjects() != null && response.getSubjects().size() > 0)
        {
            return response.getSubjects().get(0).getId();
        } else
        {
            return null;
        }
    }

    public static String doGetInfo(String movieId) throws IOException
    {
        if (movieId == null || movieId.equals(""))
        {
            return null;
        }
        String url = String.format(infoUrl, movieId);
        String response = new DoubanUtil().run(url);
        System.out.println("response info " + response);
        return response;
    }

    public static void doGetImage(String movieId, String movieName) throws IOException
    {
        if (movieId == null || movieId.equals(""))
        {
            return;
        }
        String url = String.format(imageContentUrl, movieId);
        String photoResponseString = new DoubanUtil().run(url);
        PhotoResponse response =
                new Gson().fromJson(photoResponseString, PhotoResponse.class);

        File downloadDir = checkDownloadPath(movieName);
        writeSDFile(downloadDir.getAbsolutePath() + "/" + PHOTO_INFO_FILE_NAME,
                photoResponseString);

        String coverImgUrl = response.getSubject().getImages().get("large");
        doDownloadImage(coverImgUrl, downloadDir, coverImgUrl.hashCode()
                + ".jpg");

        for (Photo photoObj : response.getPhotos())
        {
            doDownloadImage(photoObj.getImage(), downloadDir, photoObj.getImage().hashCode() + ".jpg");
        }
    }

    static void doDownloadImage(String url, File dir, String fileName)
            throws IOException
    {
        Request request =
                new Request.Builder().url(url).build();

        System.out.println("111111  image url = " + url);
        Response imgResp = client.newCall(request).execute();
        File downloadedFile = new File(dir, fileName);

        BufferedSink sink = Okio.buffer(Okio.sink(downloadedFile));
        sink.writeAll(imgResp.body().source());
        sink.close();
    }

    static File checkDownloadPath(String movieName)
    {
        String sdcardPath = SDCardUtils.getSDCardPath();
        File testbedPath = new File(sdcardPath, "testbed");

        File downloadDir = new File(testbedPath.getAbsolutePath(), movieName);
        if (!downloadDir.exists())
        {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    //写文件
    public static void writeSDFile(String fileName, String write_str)
            throws IOException
    {
        File file = new File(fileName);

        FileOutputStream fos = new FileOutputStream(file);

        byte[] bytes = write_str.getBytes();

        fos.write(bytes);

        fos.close();
    }

    public static void doGet(String name) throws IOException
    {
        String movieId = doSearch(name);
        String movieInfo = doGetInfo(movieId);
        File downloadDir = checkDownloadPath(name);
        writeSDFile(downloadDir.getAbsolutePath() + "/" + INFO_FILE_NAME, movieInfo);
        //download image
        System.out.println("111111   movieId = " + movieId);
        doGetImage(movieId, name);
    }

    String run(String url) throws IOException
    {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

}
