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

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import swrc.io.docklink.R;
import swrc.io.docklink.bases.BaseActivity;
import swrc.io.docklink.models.Movie;
import swrc.io.docklink.utils.DoubanUtil;
import swrc.io.docklink.utils.SDCardUtils;

public class SplashActivity extends BaseActivity
{

    @Bind(R.id.tvCurFile)
    TextView tvCurFile;
    String infoPath;
    List<Movie> movielist = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        DownTask task = new DownTask(this);
        task.execute("");
        if(Movie.getAll()==null||Movie.getAll().size() ==0)
        {
            String sdcardPath = SDCardUtils.getSDCardPath();
            if (TextUtils.isEmpty(sdcardPath))
            {
                Toast.makeText(this, "NO SD CARD", Toast.LENGTH_SHORT).show();
                return;
            }
            File infoPath = new File(sdcardPath, "info");
            if (infoPath.exists() && infoPath.isDirectory())
            {
                this.infoPath = infoPath.getAbsolutePath();
            } else
            {
                Toast.makeText(this, "Dont find Info directory", Toast.LENGTH_SHORT).show();
                return;
            }

            File[] files = new File(sdcardPath).listFiles();
            for (File file : files)
            {
                if (!file.isDirectory())
                {
                    tvCurFile.setText(file.getAbsolutePath());
                    Movie movie = new Movie(file.getAbsolutePath());
                    if (movie.isSuccessLoadData())
                    {
                        movielist.add(movie);
                        movie.save();
                    }
                }

            }


        }

        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    class DownTask extends AsyncTask<String, Integer, String>
    {
        ProgressDialog pdialog;
        int hasRead = 0;
        Context mContext;

        public DownTask(Context ctx)
        {
            mContext = ctx;
        }

        @Override
        protected String doInBackground(String... params)
        {
            String name = "生活大爆炸";
            System.out.println(name + "   start");
            try
            {
                DoubanUtil.doGet(name);
                hasRead++;
                publishProgress(hasRead);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println(name + "   end");
            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            pdialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String aVoid)
        {
            pdialog.dismiss();
        }

        @Override
        protected void onPreExecute()
        {
            pdialog = new ProgressDialog(mContext);
            pdialog.setTitle("任务正在执行中");
            pdialog.setMessage("任务执行中，敬请等待......");
            pdialog.setCancelable(false);
            pdialog.setMax(2);
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdialog.setIndeterminate(false);
            pdialog.show();
        }
    }

}
