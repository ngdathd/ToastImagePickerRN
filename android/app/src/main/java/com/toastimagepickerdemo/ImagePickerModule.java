package com.toastimagepickerdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import csell.com.ngdat.library.imagepicker.features.ImagePicker;

public class ImagePickerModule extends ReactContextBaseJavaModule {
    public ImagePickerModule(@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "ImagePickerModule";
    }

    @ReactMethod
    public void openGallery() {
        ImagePicker.create(getCurrentActivity())
                .folderMode(true) // folder mode (false by default)
                .multi() // multi mode (default mode)
                .limit(6) // max imagesChoose can be selected (99 by default)
                .showCamera(true) // show camera or not (true by default)
                .imageDirectory("csellImages") // directory name for captured image  ("Camera" folder by default)
                .enableLog(false) // disabling log
                .start(); // start image picker activity with request code
    }
}
