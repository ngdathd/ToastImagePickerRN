package csell.com.ngdat.library.imagepicker.features.camera;

import android.content.Context;
import android.content.Intent;

import csell.com.ngdat.library.imagepicker.features.common.BaseConfig;

public interface CameraModule {
    Intent getCameraIntent(Context context, BaseConfig config);

    void getImage(Context context, Intent intent, OnImageReadyListener imageReadyListener);

    void removeImage();
}
