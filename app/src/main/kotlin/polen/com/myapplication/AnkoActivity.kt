package polen.com.myapplication

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import kotlinx.android.anko.*

/**
 * Created by polen on 4/13/15.
 */
public class AnkoActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        verticalLayout {
            padding = dip(30)
            val name = editText {
                hint = "Name"
                textSize = 24f
            }
            val password = editText {
                hint = "Password"
                textSize = 24f
            }
            button("Say Hello") {
                onClick {
                    toast("Hellow, ${name.text} and your password is ${password.text}")
                }
            }
        }
    }
}
