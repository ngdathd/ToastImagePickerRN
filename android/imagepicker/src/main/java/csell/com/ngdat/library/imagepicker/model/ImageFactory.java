package csell.com.ngdat.library.imagepicker.model;

import java.util.ArrayList;
import java.util.List;

import csell.com.ngdat.library.imagepicker.helper.ImagePickerUtils;

public class ImageFactory {

    public static List<Image> singleListFromPath(String path) {
        List<Image> images = new ArrayList<>();
        images.add(new Image(0, ImagePickerUtils.getNameFromFilePath(path), path));
        return images;
    }
}
