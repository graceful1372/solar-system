package ir.hmb72.space.ui.home.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.hmb72.space.R
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.databinding.ItemHomeBinding
import ir.hmb72.space.utils.base.BaseDiffUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AdapterMainItem @Inject constructor(@ApplicationContext private val context: Context) :
    RecyclerView.Adapter<AdapterMainItem.ViewHolder>() {
    private lateinit var binding: ItemHomeBinding
    private var items = emptyList<PlanetModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class ViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlanetModel) {
            binding.apply {
                name.text = item.name
                //Change font in pleiades
                if (item.name == context.getString(R.string.Pleiades)) {
                    name.textSize = 17f
                }

            /*    if (item.name == context.getString(R.string.Polaris)) {
                    if (adapterPosition == 0) {
                        // تغییر رنگ پس‌زمینه بک‌گراند
                        val background = view.background as GradientDrawable
                        background.setColor(ContextCompat.getColor(context, R.color.black))
                    }
                }*/


                Glide.with(context)
                    .load(item.imageUrl)
                    .into(imageItem)

                //Click
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item)
                    }
                }


            }
        }
    }

    private var onItemClickListener: ((PlanetModel) -> Unit)? = null
    fun setOnItemClickListener(listener: (PlanetModel) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<PlanetModel>) {
        val baseDiffUtil = BaseDiffUtils(items, data)
        val diffUtil = DiffUtil.calculateDiff(baseDiffUtil)
        items = data
        diffUtil.dispatchUpdatesTo(this)
    }
}