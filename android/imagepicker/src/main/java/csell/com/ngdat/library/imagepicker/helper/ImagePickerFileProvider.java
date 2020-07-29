package csell.com.ngdat.library.imagepicker.helper;

import androidx.core.content.FileProvider;

import csell.com.ngdat.library.imagepicker.features.ImagePickerComponentHolder;

public class ImagePickerFileProvider extends FileProvider {
    @Override
    public boolean onCreate() {
        ImagePickerComponentHolder.getInstance().init(getContext());
        return super.onCreate();
    }
}
