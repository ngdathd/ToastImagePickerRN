package csell.com.ngdat.library.imagepicker.features.common;

import java.util.List;

import csell.com.ngdat.library.imagepicker.model.Folder;
import csell.com.ngdat.library.imagepicker.model.Image;

public interface ImageLoaderListener {
    void onImageLoaded(List<Image> images, List<Folder> folders);

    void onFailed(Throwable throwable);
}
