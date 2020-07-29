package csell.com.ngdat.library.imagepicker.features.cameraonly;

import android.os.Parcel;
import android.os.Parcelable;

import csell.com.ngdat.library.imagepicker.features.common.BaseConfig;

public class CameraOnlyConfig extends BaseConfig {

    public static final Parcelable.Creator<CameraOnlyConfig> CREATOR = new Parcelable.Creator<CameraOnlyConfig>() {
        @Override
        public CameraOnlyConfig createFromParcel(Parcel source) {
            return new CameraOnlyConfig(source);
        }

        @Override
        public CameraOnlyConfig[] newArray(int size) {
            return new CameraOnlyConfig[size];
        }
    };

    public CameraOnlyConfig() {
    }

    private CameraOnlyConfig(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
