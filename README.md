Sunshine with Architecture Components
================================
## About
This app is for the [Build an App with Architecture Components Codelab](https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html).

## Starting Classes

Below is a description of the different packages and classes in the starting app code.

### `data` package
Contains all classes related to local and network app data.

##### `data.network` package
All classes related to fetching data from the network.

* The network fetching and parsing functions are all written for you.
* You will not modify the `NetworkUtils`, `OpenWeatherJsonParser` and `WeatherResponse` classes.
* `WeatherNetworkDataSource` manages everything to do with the network. It's a [singleton](https://en.wikipedia.org/wiki/Singleton_pattern). It contains: 
  * `scheduleRecurringFetchWeatherSync()` - Makes a repeating [`JobService`](https://developer.android.com/reference/android/app/job/JobService.html) using [`FirebaseJobDispatcher`](https://developer.android.com/topic/performance/scheduling.html#fjd). This repeating job will eventually sync weather information in the background.
  * `startFetchWeatherService()` - [`IntentService`](https://developer.android.com/reference/android/app/IntentService.html) for doing an immediate fetch of weather data.
  * `fetchWeather()` - Actually gets weather forecast data. This method uses the JSON parsing classes and network classes to make the fetch. It currently doesn't do anything with the fetched weather data.

##### `data.database` package
All classes related to caching the data locally (it's pretty empty right now).
* `WeatherEntry` - A simple Java object representing one day of weather.


### `ui` package
All activities and adapters - anything to do with display.

##### ui.detail package
* `DetailActivity` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) for a single day of forecast.
##### ui.list package
* `MainActivty` - [`Activity`](https://developer.android.com/reference/android/app/Activity.html) for a list of `WeatherEntry` forecasts.
* `ForecastAdapter` - [`RecyclerView.Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html) for displaying the list of `WeatherEntry` forecasts.

### `utilities` package
* You will not modify `SunshineDateUtils` or `SunshineWeatherUtils`.
* `SunshineDateUtils` -  Utility methods for normalizing dates across time zones; this helps us to "round" to the nearest date, so that when you store a date in the database, it always refers to that date at 12:00am, GMT.
* `SunshineWeatherUtils` -  Utility methods related to displaying the weather, such as picking the right image resource to show a cloudy sky or rain.

### AppExectuors class
This class provides a global executor pool. You can learn more about thread pools [here](https://www.youtube.com/watch?v=uCmHoEY1iTM). In short, this class provides an easy and efficient way to run code off of the main thread.

## License
All image and audio files (including *.png, *.jpg, *.svg, *.mp3, *.wav
and *.ogg) are licensed under the CC-BY-NC license. All other files are
licensed under the Apache 2 license. See the LICENSE file for details.
Copyright 2017 Google Inc. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.