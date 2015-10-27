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

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by NetHead on 2015/10/25.
 */
@Table(name = "Collects")
public class Collect extends Model
{
    @Column(name = "movieId", unique = true)
    String movieId;

    public Collect()
    {
        super();
    }

    public Collect(String movieId)
    {
        this.movieId = movieId;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public void setMovieId(String movieId)
    {
        this.movieId = movieId;
    }

    public static Collect getById(String movieId)
    {
        return new Select().from(Collect.class).where("movieId == ?", movieId).executeSingle();
    }

    public static List<Collect> getAll()
    {
        return new Select().from(Collect.class).execute();
    }
}
