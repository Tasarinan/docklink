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

package swrc.io.docklink.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;

import swrc.io.docklink.R;

/**
 * Created by NetHead on 2015/11/8.
 */
public class MyCheckableTextView extends FrameLayout implements Checkable
{
    private TextView mText;

    public MyCheckableTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        initView(context);
    }

    public MyCheckableTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initView(context);
    }

    public MyCheckableTextView(Context context)
    {
        super(context);
        initView(context);
    }

    private void initView(Context context)
    {
        // 填充布局
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_main_type, this);
        mText = (TextView) v.findViewById(R.id.tvName);
    }

    @Override
    public void setChecked(boolean checked)
    {
        mText.setSelected(checked);
    }

    @Override
    public boolean isChecked()
    {
        return mText.isSelected();
    }

    @Override
    public void toggle()
    {
        if (isChecked())
        {
            setChecked(false);
        } else
        {
            setChecked(true);
        }
    }

    public void setTitle(String text)
    {
        mText.setText(text);
    }
}
