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

import java.util.List;

import swrc.io.docklink.bases.BaseListAdapter;
import swrc.io.docklink.ui.views.MyCheckableTextView;

/**
 * Created by NetHead on 2015/11/8.
 */
public class MainTypeAdapter extends BaseListAdapter<String>
{
    public MainTypeAdapter(Context context, List<String> listData)
    {
        super(context, listData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        String item = (String) getItem(position);

        final MyCheckableTextView singleView = new MyCheckableTextView(mContext);
        singleView.setTitle(item);
        return singleView;
    }

}

