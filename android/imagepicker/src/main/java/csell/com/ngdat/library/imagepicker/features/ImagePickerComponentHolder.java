package csell.com.ngdat.library.imagepicker.features;

import android.content.Context;

import csell.com.ngdat.library.imagepicker.features.fileloader.DefaultImageFileLoader;
import csell.com.ngdat.library.imagepicker.features.fileloader.ImageFileLoader;
import csell.com.ngdat.library.imagepicker.features.imageloader.DefaultImageLoader;
import csell.com.ngdat.library.imagepicker.features.imageloader.ImageLoader;

public class ImagePickerComponentHolder {

    private static ImagePickerComponentHolder INSTANCE;
    private Context context;

    /* --------------------------------------------------- */
    /* > End of Singleton */
    /* --------------------------------------------------- */
    private ImageLoader imageLoader;
    private ImageFileLoader imageFileLoader;
    private ImageLoader defaultImageLoader;
    private ImageFileLoader defaultImageFileLoader;

    public static ImagePickerComponentHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImagePickerComponentHolder();
        }
        return INSTANCE;
    }

    public void init(Context context) {
        this.context = context;
    }

    public ImageLoader getImageLoader() {
        if (imageLoader == null) {
            return getDefaultImageLoader();
        }
        return imageLoader;
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    /* --------------------------------------------------- */
    /* > Default */
    /* --------------------------------------------------- */

    public ImageFileLoader getImageFileLoader() {
        if (imageFileLoader == null) {
            return getDefaultImageFileLoader();
        }
        return imageFileLoader;
    }

    public void setImageFileLoader(ImageFileLoader imageFileLoader) {
        this.imageFileLoader = imageFileLoader;
    }

    public ImageFileLoader getDefaultImageFileLoader() {
        if (defaultImageFileLoader == null) {
            defaultImageFileLoader = new DefaultImageFileLoader(context);
        }
        return defaultImageFileLoader;
    }

    public ImageLoader getDefaultImageLoader() {
        if (defaultImageLoader == null) {
            defaultImageLoader = new DefaultImageLoader();
        }
        return defaultImageLoader;
    }
}
