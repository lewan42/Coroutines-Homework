package otus.homework.coroutines

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.squareup.picasso.Picasso
import otus.homework.coroutines.entities.CatEntity

class CatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var catViewModel: CatViewModel? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        findViewById<Button>(R.id.button).setOnClickListener {
            catViewModel?.onInitComplete()
        }
    }

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun populate(cat: CatEntity) {
        findViewById<TextView>(R.id.fact_textView)?.text = cat.text
        findViewById<ImageView>(R.id.cat_photo)?.let {
            Picasso.get().load(cat.catUrl).placeholder(R.drawable.cat_stub).into(it)
        }
    }
}