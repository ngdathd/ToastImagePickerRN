package csell.com.ngdat.library.imagepicker.features;

import android.content.Context;

import java.util.ArrayList;

import csell.com.ngdat.library.imagepicker.features.cameraonly.CameraOnlyConfig;

import static csell.com.ngdat.library.imagepicker.features.IpCons.MODE_MULTIPLE;

public class ImagePickerConfigFactory {

    public static CameraOnlyConfig createCameraDefault() {
        CameraOnlyConfig config = new CameraOnlyConfig();
        config.setSavePath(ImagePickerSavePath.DEFAULT);
        config.setReturnMode(ReturnMode.ALL);
        return config;
    }

    public static ImagePickerConfig createDefault(Context context) {
        ImagePickerConfig config = new ImagePickerConfig();
        config.setMode(MODE_MULTIPLE);
        config.setLimit(IpCons.MAX_LIMIT);
        config.setShowCamera(true);
        config.setFolderMode(false);
        config.setSelectedImages(new ArrayList<>());
        config.setSavePath(ImagePickerSavePath.DEFAULT);
        config.setReturnMode(ReturnMode.NONE);
        return config;
    }
}
