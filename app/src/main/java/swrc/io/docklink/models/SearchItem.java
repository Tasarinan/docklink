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

import java.util.List;
import java.util.Map;

/**
 * Created by NetHead on 2015/10/25.
 */
public class SearchItem
{
    List<String> genres;
    int collect_count;
    List<User> casts;
    String title;
    String original_title;
    String subtype;
    List<User> directors;
    String year;
    Map<String, String> images;
    String alt;
    String id;

    public List<String> getGenres()
    {
        return genres;
    }

    public void setGenres(List<String> genres)
    {
        this.genres = genres;
    }

    public int getCollect_count()
    {
        return collect_count;
    }

    public void setCollect_count(int collect_count)
    {
        this.collect_count = collect_count;
    }

    public List<User> getCasts()
    {
        return casts;
    }

    public void setCasts(List<User> casts)
    {
        this.casts = casts;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getOriginal_title()
    {
        return original_title;
    }

    public void setOriginal_title(String original_title)
    {
        this.original_title = original_title;
    }

    public String getSubtype()
    {
        return subtype;
    }

    public void setSubtype(String subtype)
    {
        this.subtype = subtype;
    }

    public List<User> getDirectors()
    {
        return directors;
    }

    public void setDirectors(List<User> directors)
    {
        this.directors = directors;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public Map<String, String> getImages()
    {
        return images;
    }

    public void setImages(Map<String, String> images)
    {
        this.images = images;
    }

    public String getAlt()
    {
        return alt;
    }

    public void setAlt(String alt)
    {
        this.alt = alt;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
