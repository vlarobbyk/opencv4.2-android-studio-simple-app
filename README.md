# A simple app to use OpenCV 4.5 in Android Studio Bumblebee

This repository has only educational and teaching purposes.

## Description

This repository contains an example of an Android Studio app (for Android) showing how to use OpenCV 4.5 to perform a simple binarization in HSV Color Space.

## Getting Started

### Dependencies

*  [OpenCV 4.5 for Android](https://sourceforge.net/projects/opencvlibrary/files/4.5.0/opencv-4.5.0-android-sdk.zip/download)
* [Android Studio Bumblebee (2021.1.1) Stable ](https://developer.android.com/studio)

### Installing

* Download [Android Studio Bumblebee (2021.1.1) Stable ](https://developer.android.com/studio) and uncompress in any location
* Download  [OpenCV 4.5 for Android](https://sourceforge.net/projects/opencvlibrary/files/4.5.0/opencv-4.5.0-android-sdk.zip/download) and uncompress in any location
* Download this repository

### Executing program

* Update references to OpenCV 4.5. for Android libraries, according to your local paths
* Import the project into Android Studio and Run
* Add your own function according to your needs, following this format:
```c++
extern "C" JNIEXPORT void JNICALL
Java_giiata_vision_opencvhelade_MainActivity_filters(
        JNIEnv* env,
        jobject /* this */,
        jobject bitmapIn,
        jobject bitmapOut,
        jint hMin,
        jint sMin,
        jint vMin,
        jint hMax,
        jint sMax,
        jint vMax) {


    cv::Mat src;
    bitmapToMat(env, bitmapIn, src, false);
    //cv::flip(src, src, 0);
    cv::Mat tmp;
    cv::cvtColor(src, tmp, cv::COLOR_BGR2HSV);
    cv::inRange(tmp, cv::Scalar(hMin, sMin, vMin), cv::Scalar(hMax, sMax, vMax), tmp);

    matToBitmap(env, tmp, bitmapOut, false);
}
```

## Sample video

```none
[![Watch the video](https://i.imgur.com/vKb2F1B.png)](https://drive.google.com/file/d/1XqZ81ux0ReOurZFF8kcrbEGv2wvwFthb/view?usp=sharing)
```

## Authors

Contributors names and contact info

Vladimir Robles-Bykbaev
[@vlarobbyk](https://twitter.com/vlarobbyk)

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under [The GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html) License - see the LICENSE.md file for details

## Acknowledgments

Inspiration:
* [Joe Wong](https://www.youtube.com/watch?v=Sn3YhfY5jqg)
* [The Coding Notebook](https://www.youtube.com/watch?v=Sn3YhfY5jqg)
