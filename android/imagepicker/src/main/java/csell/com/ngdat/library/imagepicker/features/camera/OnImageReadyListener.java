package csell.com.ngdat.library.imagepicker.features.camera;

import java.util.List;

import csell.com.ngdat.library.imagepicker.model.Image;

public interface OnImageReadyListener {
    void onImageReady(List<Image> image);
}
