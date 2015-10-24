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

package swrc.io.docklink.bases;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by NetHead on 2015/10/20.
 * @frome ${date}
 * @TODO Base List Adapter. subclass need implement getView()
 */
public abstract class BaseListAdapter<T> extends BaseAdapter
{
    public Context mContext;
    public LayoutInflater mLayoutInflater;
    public List<T> listData;
    int contentHashCode;

    public BaseListAdapter(Context context, List<T> listData)
    {
        this.mContext = context;
        this.listData = listData;
        this.contentHashCode = context.hashCode();
        mLayoutInflater = LayoutInflater.from(context);
    }

    public List<T> getListData()
    {
        return listData;
    }

    public void setListData(List<T> listData)
    {
        this.listData = listData;
    }

    @Override
    public int getCount()
    {
        return listData == null ? 0 : listData.size();
    }

    @Override
    public Object getItem(int position)
    {

        return listData == null ? null : listData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;

    }

    public int getContentHashCode()
    {

        return contentHashCode;
    }

    public void setContentHashCode(int contentHashCode)
    {

        this.contentHashCode = contentHashCode;
    }


}
