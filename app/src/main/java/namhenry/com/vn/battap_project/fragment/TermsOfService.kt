package namhenry.com.vn.battap_project.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_term_of_service.*
import namhenry.com.vn.battap_project.R

import namhenry.com.vn.battap_project.activity.MainActivity


class TermsOfService : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_term_of_service,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).checkFragment(this)
        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.youtube.com")
        webView.settings.displayZoomControls = true
        webView.settings.builtInZoomControls = true
    }

    inner class MyWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view!!.loadUrl("https://www.youtube.com")
            return true
        }
    }
    }


