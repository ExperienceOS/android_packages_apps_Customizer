/*
 * Copyright (C) 2020 ShapeShiftOS
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

package com.exos.customizerhub.tabs;

import android.os.Bundle;
import android.preference.Preference.OnPreferenceChangeListener;

import androidx.preference.Preference;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.widget.CardPreference;

public class SystemMiscTab extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String ANIMATIONS_CATEGORY = "animations_category";
    private static final String GENERAL_NOTIFICATIONS = "general_notifications";
    private static final String MISCELLANEOUS_CATEGORY = "miscellaneous_category";
    private static final String CHANGELOG_CATEGORY = "changelog";

    private CardPreference mAnimations;
    private CardPreference mGeneral;
    private CardPreference mMiscellaneous;
    private CardPreference mChangelog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.tab_system_misc);

        CardPreference mAnimations = findPreference("animations_category");
        if (!getResources().getBoolean(R.bool.animations_category_isVisible)) {
            getPreferenceScreen().removePreference(mAnimations);
        } else {
            mAnimations = (CardPreference) findPreference(ANIMATIONS_CATEGORY);
        }

        CardPreference mGeneral = findPreference("general_notifications");
        if (!getResources().getBoolean(R.bool.general_notifications_category_isVisible)) {
            getPreferenceScreen().removePreference(mGeneral);
        } else {
            mGeneral = (CardPreference) findPreference(GENERAL_NOTIFICATIONS);
        }

        CardPreference mMiscellaneous = findPreference("miscellaneous_category");
        if (!getResources().getBoolean(R.bool.miscellaneous_category_isVisible)) {
            getPreferenceScreen().removePreference(mMiscellaneous);
        } else {
            mMiscellaneous = (CardPreference) findPreference(MISCELLANEOUS_CATEGORY);
        }

//        CardPreference mChangelog = findPreference("changelog");
//        if (!getResources().getBoolean(R.bool.changelog_category_isVisible)) {
//            getPreferenceScreen().removePreference(mChangelog);
//        } else {
//            mChangelog = (CardPreference) findPreference(CHANGELOG_CATEGORY);
//        }

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CUSTOM_SETTINGS;
    }
}
