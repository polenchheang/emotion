package polen.com.myapplication

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import com.astuetz.PagerSlidingTabStrip
import android.support.v4.view.ViewPager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.activity_main.*


public class MainActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        pager.setAdapter(MyPagerAdapter(getSupportFragmentManager()))
        tabs.setViewPager(pager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    public class MyPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm), PagerSlidingTabStrip.IconTabProvider {
        override fun getPageIconResId(position: Int): Int {
            return ICONS.get(position)
        }

        override fun getItem(position: Int): Fragment? {
            return CardFragment()
        }

        override fun getCount(): Int {
            return TITLES.size()
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return TITLES.get(position)
        }

        val TITLES  = array( "Home", "Account", "Cloud" )

        val ICONS = array(R.mipmap.ic_launcher,R.mipmap.ic_action_accounts,R.mipmap.ic_action_cloud)
    }
}
