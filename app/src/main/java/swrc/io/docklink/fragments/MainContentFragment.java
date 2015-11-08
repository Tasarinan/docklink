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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import swrc.io.docklink.R;
import swrc.io.docklink.adapters.MainContentAdapter;
import swrc.io.docklink.bases.BaseFragment;
import swrc.io.docklink.events.ChangeTypeEvent;
import swrc.io.docklink.events.IEventBus;
import swrc.io.docklink.events.SearchKeyEvent;
import swrc.io.docklink.models.Movie;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainContentFragment extends BaseFragment implements IEventBus
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.textClock)
    TextClock textClock;
    @Bind(R.id.rlTop)
    RelativeLayout rlTop;
    @Bind(R.id.gvContent)
    GridView gvContent;

    MainContentAdapter mAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainContentFragment newInstance(String param1, String param2)
    {
        MainContentFragment fragment = new MainContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainContentFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_content, container, false);
        ButterKnife.bind(this, view);
        gvContent.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Movie movie = (Movie) view.getTag();//TODO Key
                //TODO

            }
        });
        return view;
    }


    @Override
    public void onEvent(Object event)
    {

    }

    public void onEvent(ChangeTypeEvent event)
    {
        gvContent.setNumColumns(5);
        tvTitle.setText(event.getTypeName());
        loadDataByType(event.getTypeName());
    }

    private void loadDataByType(String type)
    {
        if (type.equals("全部"))
        {
            loadData(Movie.getAll());
        } else if (type.equals("收藏夹"))
        {
            loadData(Movie.getAllFromCollect());
        } else
        {
            loadData(Movie.getAllFromType(type));
        }
    }

    public void onEvent(SearchKeyEvent event)
    {
        gvContent.setNumColumns(4);
        if (TextUtils.isEmpty(event.getKey()))
        {
            tvTitle.setText("热门");
        } else
        {
            tvTitle.setText(event.getKey());
        }
        loadDataBySearchKey(event.getKey());
    }

    private void loadDataBySearchKey(String key)
    {
        loadData(Movie.getAllFromSearchKey(key));
    }

    private void loadData(List<Movie> content)
    {
        if (mAdapter == null)
        {
            mAdapter = new MainContentAdapter(getActivity(), content);
            gvContent.setAdapter(mAdapter);
        } else
        {
            mAdapter.setListData(content);
        }
        mAdapter.notifyDataSetChanged();
    }


}
