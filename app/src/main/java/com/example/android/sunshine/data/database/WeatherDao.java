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

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

/**
 * {@link Dao} which provides an api for all data operations with the {@link SunshineDatabase}
 */
@Dao
public interface WeatherDao {
    /**
     * Selects all {@link ListWeatherEntry} entries after a give date, inclusive. The LiveData will
     * be kept in sync with the database, so that it will automatically notify observers when the
     * values in the table change.
     *
     * @param date A {@link Date} from which to select all future weather
     * @return {@link LiveData} list of all {@link ListWeatherEntry} objects after date
     */
    @Query("SELECT id, weatherIconId, date, min, max FROM weather WHERE date >= :date")
    LiveData<List<ListWeatherEntry>> getCurrentWeatherForecasts(Date date);

    /**
     * Selects all ids entries after a give date, inclusive. This is for easily seeing
     * what entries are in the database without pulling all of the data.
     *
     * @param date The date to select after (inclusive)
     * @return Number of future weather forecasts stored in the database
     */
    @Query("SELECT COUNT(id) FROM weather WHERE date >= :date")
    int countAllFutureWeather(Date date);

    /**
     * Gets the weather for a single day
     *
     * @param date The date you want weather for
     * @return {@link LiveData} with weather for a single day
     */
    @Query("SELECT * FROM weather WHERE date = :date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    /**
     * Inserts a list of {@link WeatherEntry} into the weather table. If there is a conflicting id
     * or date the weather entry uses the {@link OnConflictStrategy} of replacing the weather
     * forecast. The required uniqueness of these values is defined in the {@link WeatherEntry}.
     *
     * @param weather A list of weather forecasts to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

    /**
     * Deletes any weather data older than the given day
     *
     * @param date The date to delete all prior weather from (exclusive)
     */
    @Query("DELETE FROM weather WHERE date < :date")
    void deleteOldWeather(Date date);

}
