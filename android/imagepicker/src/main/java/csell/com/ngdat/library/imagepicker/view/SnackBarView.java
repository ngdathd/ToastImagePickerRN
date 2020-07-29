package csell.com.ngdat.library.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

import csell.com.ngdat.library.imagepicker.R;

public class SnackBarView extends RelativeLayout {

    private static final int ANIM_DURATION = 200;

    private static final Interpolator INTERPOLATOR = new FastOutLinearInInterpolator();

    private TextView txtCaption;
    private Button btnAction;

    public SnackBarView(Context context) {
        this(context, null);
    }

    public SnackBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnackBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.imagepikcer_snackbar, this);
        if (isInEditMode()) {
            return;
        }
        int height = getContext().getResources().getDimensionPixelSize(R.dimen.ef_height_snackbar);
        setTranslationY(height);
        setAlpha(0f);

        int padding = getContext().getResources().getDimensionPixelSize(R.dimen.ef_spacing_double);
        setPadding(padding, 0, padding, 0);

        txtCaption = findViewById(R.id.ef_snackbar_txt_bottom_caption);
        btnAction = findViewById(R.id.ef_snackbar_btn_action);
    }

    public void setText(@StringRes int textResId) {
        txtCaption.setText(textResId);
    }

    public void setOnActionClickListener(@StringRes int textId, final OnClickListener onClickListener) {
        if (textId == 0) {
            textId = R.string.ok;
        }

        btnAction.setText(textId);
        btnAction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                hide(new Runnable() {
                    @Override
                    public void run() {
                        onClickListener.onClick(v);
                    }
                });
            }
        });
    }

    public void show(@StringRes int textResId, OnClickListener onClickListener) {
        setText(textResId);
        setOnActionClickListener(0, onClickListener);

        ViewCompat.animate(this)
                .translationY(0f)
                .setDuration(ANIM_DURATION)
                .setInterpolator(INTERPOLATOR)
                .alpha(1f);
    }

    public void hide() {
        hide(null);
    }

    private void hide(Runnable runnable) {
        ViewCompat.animate(this)
                .translationY(getHeight())
                .setDuration(ANIM_DURATION)
                .alpha(0.5f)
                .withEndAction(runnable);
    }
}
