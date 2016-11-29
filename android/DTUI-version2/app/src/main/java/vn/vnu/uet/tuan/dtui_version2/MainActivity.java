package vn.vnu.uet.tuan.dtui_version2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import vn.vnu.uet.tuan.dtui_version2.Adapter.TabAdapter;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    TabLayout tabLayout;
    ViewPager pager;
    TabAdapter adapter;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    boolean loadedIntro = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        pager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(pager);


        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (!sharedpreferences.getBoolean("loadedIntro", false)) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, IntroActivity2.class);
                    startActivity(intent);
                }
            });
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("loadedIntro", true);
            editor.commit();
            thread.run();
        }

    }
    /**
     * cai dat ViewPager
     * Tao class TabAdapter de dua vao ViewPager
     * @param pager
     */
    private void setupViewPager(ViewPager pager) {
        adapter = new TabAdapter(getSupportFragmentManager());


        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new LichFragment(), "Lịch");
        adapter.addFragment(new ThongKeFragment(), "Thống kê");

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        tabLayout.addOnTabSelectedListener(this);


        tabLayout.setTabTextColors(ColorStateList.valueOf(-1));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_white_36dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.calendar);
        tabLayout.getTabAt(2).setIcon(R.drawable.piechart);

        //setcustomview cho tap
    }

    //Tab click
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.e("TAB","Click tab " + tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onBackPressed() {
        WebView webView;
        Fragment fragment = adapter.getFrament(0);
        HomeFragment homeFragment = (HomeFragment) fragment;
        webView = homeFragment.getWebView();
        if(webView.canGoBack()){
            webView.goBack();
        }else
            super.onBackPressed();
    }
}
