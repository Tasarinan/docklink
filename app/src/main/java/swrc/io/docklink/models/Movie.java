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

package swrc.io.docklink.models;

import android.text.TextUtils;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import swrc.io.docklink.utils.PinyinUtils;
import swrc.io.docklink.utils.SDCardUtils;

/**
 * Created by NetHead on 2015/10/25.
 */
@Table(name = "Movies")
public class Movie extends Model implements Serializable
{
    @Column(name = "moviePath", unique = true)
    String moviePath;
    @Column(name = "movieId")
    String movieId;
    @Column(name = "movieName")
    String movieName;
    @Column(name = "pinyin")
    String pinyinName;
    @Column(name = "movieCover")
    String movieCover;
    @Column(name = "directors")
    String directors;//
    @Column(name = "casts")
    String casts;
    @Column(name = "genres")
    String genres;
    @Column(name = "year")
    String year;
    @Column(name = "summary")
    String summary;
    @Column(name = "photos")
    String photos;
    String infoPath;
    private InfoResponse infoResponse;

    public Movie()
    {
        super();

    }

    public Movie(String moviePath)
    {
        super();
        this.moviePath = moviePath;
        this.movieName = moviePath.substring(moviePath.lastIndexOf('/') + 1, moviePath.lastIndexOf('.'));
        this.pinyinName = PinyinUtils.getFirstPinyinCharOfChinese(movieName).toUpperCase();
        this.infoPath = getInfoPath();
        String infoFile = infoPath + "/" + movieName + "/" + "info";
        String photoinfoFile = infoPath + "/" + movieName + "/" + "photoinfo";
        try
        {
            if(!new File(infoFile).exists()||!new File(photoinfoFile).exists())
            {
                return;
            }
            InfoResponse infoResponse = new Gson().fromJson(SDCardUtils.readSDFile(infoFile), InfoResponse.class);
            PhotoResponse
        }catch (IOException io)
        {
            io.printStackTrace();
        }

    }
    public static List<Movie> getAll()
    {
        return new Select().from(Movie.class).orderBy("movieName ASC").execute();
    }

    public String getMoviePath()
    {
        return moviePath;
    }

    public void setMoviePath(String moviePath)
    {
        this.moviePath = moviePath;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public void setMovieId(String movieId)
    {
        this.movieId = movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public String getPinyinName()
    {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName)
    {
        this.pinyinName = pinyinName;
    }

    public String getMovieCover()
    {
        return movieCover;
    }

    public void setMovieCover(String movieCover)
    {
        this.movieCover = movieCover;
    }

    public String getCasts()
    {
        return casts;
    }

    public void setCasts(String casts)
    {
        this.casts = casts;
    }

    public String getDirectors()
    {
        return directors;
    }

    public void setDirectors(String directors)
    {
        this.directors = directors;
    }

    public String getGenres()
    {
        return genres;
    }

    public void setGenres(String genres)
    {
        this.genres = genres;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getPhotos()
    {
        return photos;
    }

    public void setPhotos(String photos)
    {
        this.photos = photos;
    }

    public String getInfoPath()
    {
        if (TextUtils.isEmpty(moviePath))
        {
            return null;
        }
        if (!TextUtils.isEmpty(infoPath))
        {
            return infoPath;
        }
        this.infoPath = this.moviePath.substring(0, moviePath.lastIndexOf('/')) + "/info";
        return infoPath;
    }

    public void setInfoPath(String infoPath)
    {
        this.infoPath = infoPath;
    }
}
