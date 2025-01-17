package ir.hmb72.space.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CenterZoomLinearLayoutManager(
    context: Context,
    private val mShrinkDistance: Float,
    private val mShrinkAmount: Float
    ) : LinearLayoutManager(context, HORIZONTAL, true) {

        override fun onLayoutCompleted(state: RecyclerView.State?) {
            super.onLayoutCompleted(state)
            scaleChildren()
        }

        override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
            return if (orientation == HORIZONTAL) {
                super.scrollHorizontallyBy(dx, recycler, state).also { scaleChildren() }
            } else {
                0
            }
        }

        private fun scaleChildren() {
            val width = width.toFloat() // استفاده از width / 2f
            val d1 = mShrinkDistance * width + 100f // افزایش فاصله دور شدن آیتم های کناری
            for (i in 0 until childCount) {
                val child = getChildAt(i) as View
                val d = Math.min(d1, Math.abs(width / 2f - (getDecoratedRight(child) + getDecoratedLeft(child)) / 2f))
                val scale = 1f - mShrinkAmount * d / d1
                child.scaleX = scale
                child.scaleY = scale
            }
        }
    }
