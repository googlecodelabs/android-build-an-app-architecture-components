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

package com.example.android.sunshine.data.database;


import java.util.Date;

/**
 * Simplified {@link WeatherEntry} which only contains the details needed for the weather list in
 * the {@link com.example.android.sunshine.ui.list.ForecastAdapter}
 */
public class ListWeatherEntry {

    private int id;
    private int weatherIconId;
    private Date date;
    private double min;
    private double max;

    public ListWeatherEntry(int id, int weatherIconId, Date date, double min, double max) {
        this.id = id;
        this.weatherIconId = weatherIconId;
        this.date = date;
        this.min = min;
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public int getWeatherIconId() {
        return weatherIconId;
    }

    public Date getDate() {
        return date;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
