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

package swrc.io.docklink.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import swrc.io.docklink.R;
import swrc.io.docklink.bases.BaseListAdapter;
import swrc.io.docklink.models.Movie;
import swrc.io.docklink.ui.views.ScaledImageView;

/**
 * Created by NetHead on 2015/11/7.
 */
public class MainContentAdapter extends BaseListAdapter<Movie>
{
    public MainContentAdapter(Context context, List<Movie> listData)
    {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        MyViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = mLayoutInflater.inflate(R.layout.item_main_content, null);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (MyViewHolder) convertView.getTag();
        }
        Movie item = (Movie) getItem(position);
        Picasso.with(mContext).load(new File(item.getMovieCover())).fit().centerInside().into(viewHolder.mIvImage);
        viewHolder.mTvName.setText(item.getMovieName());
        convertView.setTag(item);//TODO
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_main_content.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class MyViewHolder
    {
        @Bind(R.id.ivImage)
        ScaledImageView mIvImage;
        @Bind(R.id.tvName)
        TextView mTvName;

        MyViewHolder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
