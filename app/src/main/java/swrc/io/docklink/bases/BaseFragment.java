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

import android.app.Fragment;
import android.os.Bundle;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import swrc.io.docklink.events.IEventBus;

/**
 * Created by NetHead on 2015/10/24.
 */
public class BaseFragment extends Fragment
{
    protected String TAG = "";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TAG = ((Object) this).getClass().getSimpleName();
        if (this instanceof IEventBus)
        {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (this instanceof IEventBus)
        {
            EventBus.getDefault().unregister(this);
        }
    }
}
