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

package swrc.io.docklink.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import swrc.io.docklink.R;
import swrc.io.docklink.adapters.MainTypeAdapter;
import swrc.io.docklink.bases.BaseFragment;
import swrc.io.docklink.events.ChangeTypeEvent;
import swrc.io.docklink.models.Type;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainTypeFragment extends BaseFragment
{

    MainTypeAdapter mAdapter;
    List<String> types = new ArrayList<>(10);
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.listView)
    ListView mListView;

    public MainTypeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_type, container, false);

        mTvTitle.setText("影片");

        for (Type typeObj : Type.getAll())
        {
            types.add(typeObj.getName());
        }

        types.add(0, "全部");
        types.add(0, "收藏夹");
        types.add(0, "筛选");
        types.add(0, "搜索");

        mAdapter = new MainTypeAdapter(getActivity(), types);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String item = (String) mAdapter.getItem(position);
                if (item.equals("搜索"))
                {
                    // SearchActivity.open(getActivity()); //TODO
                } else if (item.equals("筛选"))
                {
                    //do something
                } else if (item.equals("收藏夹"))
                {

                } else
                {
                    EventBus.getDefault().post(new ChangeTypeEvent(item));
                }

            }
        });
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
