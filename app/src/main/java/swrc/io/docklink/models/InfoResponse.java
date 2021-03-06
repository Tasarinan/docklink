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
public class InfoResponse
{
    Rating rating;
    int reviews_count;
    int wish_count;
    int collect_count;
    String douban_site;
    String year;
    Map<String, String> images;
    String alt;
    String id;
    String mobile_url;
    String title;
    String do_count;
    String seasons_count;
    String schedule_url;
    String episodes_count;
    List<String> genres;
    List<String> countries;
    List<User> casts;
    String current_season;
    String original_title;
    String summary;
    String subtype;
    List<User> directors;
    int comments_count;
    int ratings_count;
    List<String> aka;

    public Rating getRating()
    {
        return rating;
    }

    public void setRating(Rating rating)
    {
        this.rating = rating;
    }

    public int getReviews_count()
    {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count)
    {
        this.reviews_count = reviews_count;
    }

    public int getWish_count()
    {
        return wish_count;
    }

    public void setWish_count(int wish_count)
    {
        this.wish_count = wish_count;
    }

    public int getCollect_count()
    {
        return collect_count;
    }

    public void setCollect_count(int collect_count)
    {
        this.collect_count = collect_count;
    }

    public String getDouban_site()
    {
        return douban_site;
    }

    public void setDouban_site(String douban_site)
    {
        this.douban_site = douban_site;
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

    public String getMobile_url()
    {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url)
    {
        this.mobile_url = mobile_url;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDo_count()
    {
        return do_count;
    }

    public void setDo_count(String do_count)
    {
        this.do_count = do_count;
    }

    public String getSeasons_count()
    {
        return seasons_count;
    }

    public void setSeasons_count(String seasons_count)
    {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url()
    {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url)
    {
        this.schedule_url = schedule_url;
    }

    public String getEpisodes_count()
    {
        return episodes_count;
    }

    public void setEpisodes_count(String episodes_count)
    {
        this.episodes_count = episodes_count;
    }

    public List<String> getGenres()
    {
        return genres;
    }

    public String getGenresString()
    {
        StringBuilder res = new StringBuilder();
        for (String value : genres)
        {
            res.append(value);
            res.append(",");
        }
        return res.toString();
    }

    public void setGenres(List<String> genres)
    {
        this.genres = genres;
    }

    public List<String> getCountries()
    {
        return countries;
    }

    public void setCountries(List<String> countries)
    {
        this.countries = countries;
    }

    public List<User> getCasts()
    {
        return casts;
    }

    public String getCastsString()
    {
        StringBuilder res = new StringBuilder();
        for (User user : casts)
        {
            res.append(user.getName());
            res.append(",");
        }
        return res.toString();
    }

    public void setCasts(List<User> casts)
    {
        this.casts = casts;
    }

    public String getCurrent_season()
    {
        return current_season;
    }

    public void setCurrent_season(String current_season)
    {
        this.current_season = current_season;
    }

    public String getOriginal_title()
    {
        return original_title;
    }

    public void setOriginal_title(String original_title)
    {
        this.original_title = original_title;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
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

    public String getDirectorsString()
    {
        StringBuilder res = new StringBuilder();
        for (User user : directors)
        {
            res.append(user.getName());
            res.append(",");
        }
        return res.toString();
    }

    public void setDirectors(List<User> directors)
    {
        this.directors = directors;
    }

    public int getComments_count()
    {
        return comments_count;
    }

    public void setComments_count(int comments_count)
    {
        this.comments_count = comments_count;
    }

    public int getRatings_count()
    {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count)
    {
        this.ratings_count = ratings_count;
    }

    public List<String> getAka()
    {
        return aka;
    }

    public void setAka(List<String> aka)
    {
        this.aka = aka;
    }


}
