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

/**
 * Created by NetHead on 2015/10/25.
 */
public class PhotoResponse
{
    int count;
    List<Photo> photos;
    int total;
    InfoResponse subject;
    int start;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public List<Photo> getPhotos()
    {
        return photos;
    }

    public String getPhotosString()
    {
        StringBuilder res = new StringBuilder();
        for (Photo photo : photos)
        {
            res.append(photo.getImage().hashCode());
            res.append(".jpg");
            res.append(",");
        }
        return res.toString();
    }

    public void setPhotos(List<Photo> photos)
    {
        this.photos = photos;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public InfoResponse getSubject()
    {
        return subject;
    }

    public void setSubject(InfoResponse subject)
    {
        this.subject = subject;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }
}
