/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.aboutphone;

import android.content.Context;

import com.android.settings.R;

import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

import com.colt.settings.utils.Utils;

public class OTAPreferenceController extends AbstractPreferenceController
                implements PreferenceControllerMixin {

    private static final String KEY_COLT_UPDATES = "colt_updates";
    Context mContext;

    public OTAPreferenceController(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public boolean isAvailable() {
        return Utils.isPackageInstalled(mContext, "org.colt.ota");
    }

    @Override
    public String getPreferenceKey() {
        return KEY_COLT_UPDATES;
    }
}
