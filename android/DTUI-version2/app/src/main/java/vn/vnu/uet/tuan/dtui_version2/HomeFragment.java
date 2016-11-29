package vn.vnu.uet.tuan.dtui_version2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private WebView webView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        /***
         Hiển thị trong layout acitivity_main.xml
         */
        webView = (WebView) view.findViewById(R.id.home_webview);
        WebSettings webSettings = webView.getSettings();
         /*
         setJavaScriptEnabled hỗ trợ xem code javascript trong trang web
         */
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("http://ueter.xyz/dtui/DTUI_Project1/materialized/");
         /*
         Tải dữ liệu trang thay vì trắng màn hình
         */
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);


        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {

            }
            /*
            Không có mạng sẽ hiển thi thông báo lỗi
            */
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView.loadUrl("file:///android_asset/loi.html");
            }



        });

        return view;
    }

    public WebView getWebView() {
        return webView;
    }
}
