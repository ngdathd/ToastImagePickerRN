package csell.com.ngdat.library.imagepicker.features;

import java.util.List;

import csell.com.ngdat.library.imagepicker.features.common.MvpView;
import csell.com.ngdat.library.imagepicker.model.Folder;
import csell.com.ngdat.library.imagepicker.model.Image;

public interface ImagePickerView extends MvpView {
    void showLoading(boolean isLoading);

    void showFetchCompleted(List<Image> images, List<Folder> folders);

    void showError(Throwable throwable);

    void showEmpty();

    void showCapturedImage();

    void finishPickImages(List<Image> images);
}
