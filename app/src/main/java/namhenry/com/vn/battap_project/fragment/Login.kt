package namhenry.com.vn.battap_project.fragment


import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_login.*
import namhenry.com.vn.battap_project.R
import namhenry.com.vn.battap_project.activity.MainActivity
import namhenry.com.vn.battap_project.activity.switchFragment

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).checkFragment(this)

        btnLogin.setOnClickListener {
            if (edEmailLogin.text.toString().equals("nam")&&edPassWordEmailLogin.text.toString().equals("nam")) {

                switchFragment(RencentReport())
            } else {
                val builder = AlertDialog.Builder(activity)
                builder.setTitle("Đăng nhập thất bại!")
                builder.setMessage("Vui lòng nhập lại email và pasword")
                builder.setPositiveButton("OK")
                { dialog, which ->
                    edEmailLogin.text.clear()
                    edPassWordEmailLogin.text.clear()
                }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }

        }

    }

}
