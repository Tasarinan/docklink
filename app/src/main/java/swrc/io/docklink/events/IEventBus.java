/*
 * Copyright (c) 2015
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ${user} - initial API and implementation
 */

package swrc.io.docklink.events;

/**
 * Created by NetHead on 2015/10/19.
 */
public interface IEventBus {
    void onEvent(Object event);
}
