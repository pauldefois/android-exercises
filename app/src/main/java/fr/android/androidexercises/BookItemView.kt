package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {
    private var mnameTextView: TextView? = null
    private var mpriceTextView: TextView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        mnameTextView = nameTextView
        mpriceTextView = priceTextView
    }

    fun bindView(book: Book) {
        mnameTextView!!.text = book.name
        mpriceTextView!!.text = book.price.toString()
    }
}