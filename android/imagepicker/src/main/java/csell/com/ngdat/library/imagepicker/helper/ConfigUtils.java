package csell.com.ngdat.library.imagepicker.helper;

import android.content.Context;

import csell.com.ngdat.library.imagepicker.R;
import csell.com.ngdat.library.imagepicker.features.ImagePickerConfig;
import csell.com.ngdat.library.imagepicker.features.IpCons;
import csell.com.ngdat.library.imagepicker.features.ReturnMode;
import csell.com.ngdat.library.imagepicker.features.common.BaseConfig;

public class ConfigUtils {

    public static ImagePickerConfig checkConfig(ImagePickerConfig config) {
        if (config == null) {
            throw new IllegalStateException("ImagePickerConfig cannot be null");
        }
        if (config.getMode() != IpCons.MODE_SINGLE
                && (config.getReturnMode() == ReturnMode.GALLERY_ONLY
                || config.getReturnMode() == ReturnMode.ALL)) {
            throw new IllegalStateException("ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!");
        }
        return config;
    }

    public static boolean shouldReturn(BaseConfig config, boolean isCamera) {
        ReturnMode mode = config.getReturnMode();
        if (isCamera) {
            return mode == ReturnMode.ALL || mode == ReturnMode.CAMERA_ONLY;
        } else {
            return mode == ReturnMode.ALL || mode == ReturnMode.GALLERY_ONLY;
        }
    }

    public static String getFolderTitle(Context context, ImagePickerConfig config) {
        final String folderTitle = config.getFolderTitle();
        return ImagePickerUtils.isStringEmpty(folderTitle)
                ? context.getString(R.string.title_folder)
                : folderTitle;
    }

    public static String getImageTitle(Context context, ImagePickerConfig config) {
        final String configImageTitle = config.getImageTitle();
        return ImagePickerUtils.isStringEmpty(configImageTitle)
                ? context.getString(R.string.title_select_image)
                : configImageTitle;
    }

    public static String getDoneButtonText(Context context, ImagePickerConfig config) {
        final String doneButtonText = config.getDoneButtonText();
        return ImagePickerUtils.isStringEmpty(doneButtonText)
                ? context.getString(R.string.done)
                : doneButtonText;
    }
}
