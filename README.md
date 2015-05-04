#Static map

[![Maven](https://img.shields.io/badge/maven-0.1.3-brightgreen.svg)](http://search.maven.org/#artifactdetails%7Ccom.github.d-max%7Cstatic-map%7C0.1.3%7Caar)
[![Blog Post](https://img.shields.io/badge/blog-post-yellow.svg)](http://dybarsky.blogspot.com/2014/08/static-map-library.html)

NOT SUPPORTED ANYMORE!

Google made its own lite mode of google maps in play services v6.5
https://developers.google.com/maps/documentation/android/lite

==========
 
This is standalone android library developed to generate static map images easily. It is based on [Google Static Maps API][4] and provides **sync** and **async** ways of bitmaps generation.

Next features are supported:
* Secure access (https)
* Location (geo position, address)
* Map types (roads, satellite, etc)
* Zoom, scale, image size params
* Markers (without custom icon)

![Example Image1][1] ⠀
![Example Image2][2] ⠀
![Example Image3][3]

###Usage

Google Static Map API documentation is available [here][4]. Please, read it first if you are not familiar with service requirements and differences.
Static-map library available in maven central repository. You can get it using:
```groovy
dependencies {
    compile 'com.github.d-max:static-map:0.1+@aar'
}
```
Javadoc and sources package [classigiers][8] available too.

Use [Config][5] class to set map generation basic params. Example:
```java
Config config = new Config();
config.setImageSize(200, 300)
      .setZoom(10)
      .setAddress("Kyiv");
```
[StaticMap][6] class contais two static methods for map generation. To get map image *synchronously* use like this:
```java
try {
    Bitmap mapImage = StaticMap.requestMapImage(context, config);
} catch (StaticMapException ex) { /* log */ }
```
To get map image *asynchronously*, use another method with [Callback][7] param:
```java
Bitmap mapImage;
Callback callback = new Callback() {
    public void onFailed(int errorCode, String errorMessage) { /* log */ }
    public void onMapGenerated(Bitmap bitmap) { mapImage = bitmap; }
};
StaticMap.requestMapImage(context, config, callback);
```
This method encapsulates AsyncTask class to load image in background.
**Note:** Callback class methods will be invoked in main thread.


###Developed By

Maksym Dybarskyi - http://d-max.info

###License

	The MIT License (MIT)
	Copyright © 2014 Maxim Dybarsky

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the “Software”), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.


[1]: http://maps.google.com/maps/api/staticmap?size=200x200&center=49,31&zoom=4&maptype=sattelite
[2]: http://maps.google.com/maps/api/staticmap?size=200x200&center=50,0&zoom=3&maptype=satellite
[3]: http://maps.google.com/maps/api/staticmap?size=200x200&center=50.4513,30.522&zoom=15&markers=color:blue%7C50.450866,30.522873
[4]: https://developers.google.com/maps/documentation/staticmaps/
[5]: library/src/main/java/dmax/staticmap/Config.java
[6]: library/src/main/java/dmax/staticmap/StaticMap.java
[7]: library/src/main/java/dmax/staticmap/Callback.java
[8]: http://www.gradle.org/docs/current/userguide/dependency_management.html#sub:classifiers
