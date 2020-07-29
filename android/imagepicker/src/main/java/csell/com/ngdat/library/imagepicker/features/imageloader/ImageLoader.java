package csell.com.ngdat.library.imagepicker.features.imageloader;

import android.widget.ImageView;

public interface ImageLoader {
    void loadImage(String path, ImageView imageView, ImageType imageType);
}
