package white.off.viewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import white.off.viewer.ui.index.IndexFragment

class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.index_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, IndexFragment.newInstance())
                    .commitNow()
        }
    }

}
