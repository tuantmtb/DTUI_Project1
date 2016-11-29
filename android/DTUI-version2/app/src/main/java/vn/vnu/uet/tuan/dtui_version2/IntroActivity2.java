package vn.vnu.uet.tuan.dtui_version2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;

import vn.vnu.uet.tuan.dtui_version2.ViewPagerAnim.ZoomOutPageTransformer;


/**
 * Created by Admin on 28/11/2016.
 */
public class IntroActivity2 extends AppIntro {
    String colorBar = "#1AA9A9A9";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(IntroFragment.newInstance(R.drawable.themcongviec));
        addSlide(IntroFragment.newInstance(R.drawable.thongbao));
        addSlide(IntroFragment.newInstance(R.drawable.thongke));


        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor(colorBar));

//        setCustomTransformer(new ZoomOutPageTransformer());
        setZoomAnimation();

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}