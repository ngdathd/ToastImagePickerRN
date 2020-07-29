package csell.com.ngdat.library.imagepicker.listeners;

import java.util.List;

import csell.com.ngdat.library.imagepicker.model.Image;

public interface OnImageSelectedListener {
    void onSelectionUpdate(List<Image> selectedImage);
}
