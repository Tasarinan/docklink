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

/**
 * Created by NetHead on 2015/10/25.
 */
public class Photo
{
    int photos_count;
    String thumb;
    String desc;
    String album_id;
    String created_at;
    String cover;
    String subject_id;
    String prev_photo;
    String album_url;
    int comments_count;
    int recs_count;
    String id;
    int position;
    String alt;
    String album_title;
    String next_photo;
    String image;
    String icon;

    public int getPhotos_count()
    {
        return photos_count;
    }

    public void setPhotos_count(int photos_count)
    {
        this.photos_count = photos_count;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getThumb()
    {
        return thumb;
    }

    public void setThumb(String thumb)
    {
        this.thumb = thumb;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getAlbum_id()
    {
        return album_id;
    }

    public void setAlbum_id(String album_id)
    {
        this.album_id = album_id;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public String getCover()
    {
        return cover;
    }

    public void setCover(String cover)
    {
        this.cover = cover;
    }

    public String getSubject_id()
    {
        return subject_id;
    }

    public void setSubject_id(String subject_id)
    {
        this.subject_id = subject_id;
    }

    public String getPrev_photo()
    {
        return prev_photo;
    }

    public void setPrev_photo(String prev_photo)
    {
        this.prev_photo = prev_photo;
    }

    public String getAlbum_url()
    {
        return album_url;
    }

    public void setAlbum_url(String album_url)
    {
        this.album_url = album_url;
    }

    public int getComments_count()
    {
        return comments_count;
    }

    public void setComments_count(int comments_count)
    {
        this.comments_count = comments_count;
    }

    public int getRecs_count()
    {
        return recs_count;
    }

    public void setRecs_count(int recs_count)
    {
        this.recs_count = recs_count;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public String getAlt()
    {
        return alt;
    }

    public void setAlt(String alt)
    {
        this.alt = alt;
    }

    public String getAlbum_title()
    {
        return album_title;
    }

    public void setAlbum_title(String album_title)
    {
        this.album_title = album_title;
    }

    public String getNext_photo()
    {
        return next_photo;
    }

    public void setNext_photo(String next_photo)
    {
        this.next_photo = next_photo;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
