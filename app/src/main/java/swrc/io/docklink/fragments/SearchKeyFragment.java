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
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import swrc.io.docklink.R;
import swrc.io.docklink.adapters.SearchKeyAdapter;
import swrc.io.docklink.bases.BaseFragment;
import swrc.io.docklink.events.SearchKeyEvent;
import swrc.io.docklink.ui.views.NoScrollGridView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchKeyFragment extends BaseFragment
{


    @Bind(R.id.tvBack)
    TextView mTvBack;
    @Bind(R.id.tvName)
    EditText mTvName;
    @Bind(R.id.gvKeys)
    NoScrollGridView mGvKeys;
    @Bind(R.id.btnInputBack)
    Button mBtnInputBack;
    @Bind(R.id.btnInputClear)
    Button mBtnInputClear;
    @Bind(R.id.tvTip)
    TextView mTvTip;

    String keys[] = {"A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z", "0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9"};
    SearchKeyAdapter mAdapter;


    public SearchKeyFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_key, container, false);
        ButterKnife.bind(this, view);
        String styledText = "拼音首字母搜索例如：《奔跑吧兄弟》输入<font color='#0069ea'>BPBXD</font>";
        mTvTip.setText(Html.fromHtml(styledText));
        mAdapter = new SearchKeyAdapter(getActivity(), Arrays.asList(keys));
        mGvKeys.setAdapter(mAdapter);
        mGvKeys.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String key = (String) mAdapter.getItem(position);
                String curText = mTvName.getText().toString();
                mTvName.setText(curText + key);
                doSearch(curText + key);
            }
        });

        return view;
    }

    private void doSearch(String key)
    {
        EventBus.getDefault().post(new SearchKeyEvent(key));
    }

    @OnClick(R.id.btnInputBack)
    public void onInputBack(View view)
    {
        String curText = mTvName.getText().toString();
        if(TextUtils.isEmpty(curText))
        {
            doSearch("");
            return;
        }
        curText =(String)curText.subSequence(0,curText.length()-1);
        mTvName.setText(curText);
        doSearch(curText);

    }
    @OnClick(R.id.btnInputClear)
    public void onInputClear(View view)
    {
        mTvName.setText("");
        doSearch("");
    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
