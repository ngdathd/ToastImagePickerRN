package csell.com.ngdat.library.imagepicker.helper;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class ImagePickerPreferences {

    public static final String PREF_WRITE_EXTERNAL_STORAGE_REQUESTED = "writeExternalRequested";
    public static final String PREF_CAMERA_REQUESTED = "cameraRequested";

    private Context context;

    public ImagePickerPreferences(Context context) {
        this.context = context;
    }

    /**
     * Set a permission is requested
     */
    public void setPermissionRequested(String permission) {
        SharedPreferences preferences = context.getSharedPreferences("ImagePickerPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(permission, true);
        editor.apply();
    }

    /**
     * Check if a permission is requestted or not (false by default)
     */
    public boolean isPermissionRequested(String permission) {
        SharedPreferences preferences = context.getSharedPreferences("ImagePickerPreferences", MODE_PRIVATE);
        return preferences.getBoolean(permission, false);
    }
}
