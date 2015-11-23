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

package swrc.io.docklink.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import swrc.io.docklink.R;
import swrc.io.docklink.models.Collect;
import swrc.io.docklink.models.Movie;
import swrc.io.docklink.ui.views.NoScrollGridView;
import swrc.io.docklink.utils.BitmapUtils;

public class DetailActivity extends AppCompatActivity
{
    Movie movie;
    @Bind(R.id.ivConer)
    ImageView mIvConer;
    @Bind(R.id.ivConerReflection)
    ImageView mIvConerReflection;
    @Bind(R.id.tvName)
    TextView mTvName;
    @Bind(R.id.textClock)
    TextClock mTextClock;
    @Bind(R.id.textView3)
    TextView mTextView3;
    @Bind(R.id.textView4)
    TextView textView4;
    @Bind(R.id.tvOtherInfo)
    TextView mTvOtherInfo;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.tvSummary)
    TextView mTvSummary;
    @Bind(R.id.btnPlay)
    Button mBtnPlay;
    @Bind(R.id.btnCollect)
    Button mBtnCollect;
    @Bind(R.id.gvPhotos)
    NoScrollGridView mGvPhotos;
    @Bind(R.id.gvMain)
    ScrollView mGvMain;
    @Bind(R.id.directorContainer)
    LinearLayout mDirectorContainer;
    @Bind(R.id.actContainer)
    LinearLayout mActContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        this.movie = (Movie)getIntent().getSerializableExtra("movie_info");
        Bitmap bmpCover = BitmapFactory.decodeFile(movie.getMovieCover());
        this.mIvConerReflection.setImageBitmap(BitmapUtils.createReflectedBitmap(bmpCover,.5f));
        mIvConer.setImageBitmap(bmpCover);
        mTvName.setText(movie.getMovieName());
        fillUserContent(mDirectorContainer, movie.getDirectors());
        fillUserContent(mActContainer, movie.getCasts());

        StringBuilder tag = new StringBuilder();
        for(int i = 0;i<movie.getGenres().length;i++)
        {
            String genre = movie.getGenres()[i];
            tag.append(genre);
            if(i!=movie.getGenres().length-1)
            {
                tag.append(",");
            }
        }
        mTvOtherInfo.setText(String.format(getText(R.string.detail_other_info).toString(),tag.toString(),movie.getYear()));
        mTvSummary.setText(movie.getSummary());


    }
    private void fillUserContent(LinearLayout container, String[] values)
    {
        for(String value:values)
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(30,0,30,0);
            TextView tv = new TextView(this);
            tv.setText(value);
            tv.setTextColor(getResources().getColor(R.color.text_color1));
            tv.setTextSize(18);
            tv.setGravity(Gravity.CENTER);
            tv.setBackgroundResource(R.drawable.detail_tag);
            container.addView(tv);


        }
    }
    private  void setCollectState()
    {
        boolean isCollect = Collect.getById(this.movie.getMovieId())!=null;
        if(isCollect)
        {
            mBtnCollect.setBackgroundResource(R.drawable.selector_detail_collect);
        }

    }
}
