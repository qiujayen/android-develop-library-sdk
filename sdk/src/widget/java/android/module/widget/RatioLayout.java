package android.module.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.develop.sdk.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by jay on 2018/1/18 下午3:15
 */
public final class RatioLayout extends FrameLayout {

    private static final int WIDTH = 0;
    private static final int HEIGHT = 1;

    private final float mWidthRatio;
    private final float mHeightRatio;
    private final int mFixed;

    public RatioLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioLayout);
        mWidthRatio = typedArray.getFloat(R.styleable.RatioLayout_width_ratio, -1);
        mHeightRatio = typedArray.getFloat(R.styleable.RatioLayout_height_ratio, -1);
        mFixed = typedArray.getInt(R.styleable.RatioLayout_fixed, WIDTH);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mWidthRatio != -1 && mHeightRatio != -1) {
            // width/height = mWidthRatio/mHeightRatio
            final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            switch (mFixed) {
                case WIDTH:
                    if (widthMode != MeasureSpec.EXACTLY) {
                        throw new IllegalStateException("layout_width value is not exactly");
                    }
                    final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.round(mHeightRatio / mWidthRatio * widthSize), widthMode);
                    break;
                case HEIGHT:
                    if (heightMode != MeasureSpec.EXACTLY) {
                        throw new IllegalStateException("layout_height value is not exactly");
                    }
                    final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
                    widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.round(mWidthRatio / mHeightRatio * heightSize), heightMode);
                    break;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
