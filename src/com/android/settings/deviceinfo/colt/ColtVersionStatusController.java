/*
 * Copyright (C) 2018 The ColtOS
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

package com.android.settings.deviceinfo.colt;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.View;

import com.android.settings.R;
import com.android.settings.Utils;

public class ColtVersionStatusController {

    private static final String PROP = "persist.colt.official";
    private static final String TRUE = "true";
    private static final String OFFICIAL = "Official";
    private static final String UNOFFICIAL = "Unofficial";
    private static final int COLT_VERSION_LABEL_ID = R.id.colt_version_status_label;
    private static final int COLT_VERSION_VALUE_ID = R.id.colt_version_status_value;

    private final ColtVersionDialogFragment mDialog;

    ColtVersionStatusController(ColtVersionDialogFragment dialog) {
        mDialog = dialog;
    }

    public void initialize() {
        if(TextUtils.isEmpty(SystemProperties.get(PROP, ""))) {
            mDialog.removeSettingFromScreen(COLT_VERSION_LABEL_ID);
            mDialog.removeSettingFromScreen(COLT_VERSION_VALUE_ID);
        } else if(TextUtils.equals(SystemProperties.get(PROP, "").trim(), TRUE)) {
            mDialog.setText(COLT_VERSION_VALUE_ID, OFFICIAL);
        } else if(!TextUtils.equals(SystemProperties.get(PROP, "").trim(), TRUE)) {
            mDialog.setText(COLT_VERSION_VALUE_ID, UNOFFICIAL);
        }
    }
}
