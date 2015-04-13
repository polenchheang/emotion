package polen.com.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.util.TypedValue
import android.widget.TextView
import android.view.Gravity
import android.support.v4.app.Fragment

/**
 * Created by polen on 3/19/15.
 */
public class CardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        var f1 = FrameLayout(getActivity())
        f1.setLayoutParams(params)
        val margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, getResources().getDisplayMetrics()).toInt()
        val v = TextView(getActivity())
        params.setMargins(margin,margin,margin,margin)
        v.setLayoutParams(params)
        v.setGravity(Gravity.CENTER)
        v.setBackgroundResource(R.mipmap.ic_launcher)
        v.setText("Card ")
        f1.addView(v)
        return f1
    }
}
