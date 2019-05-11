package namhenry.com.vn.battap_project.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recent_report.*
import namhenry.com.vn.battap_project.R
import namhenry.com.vn.battap_project.activity.MainActivity
import namhenry.com.vn.battap_project.activity.switchFragment


class RencentReport : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recent_report,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).checkFragment(this)

    }
}
