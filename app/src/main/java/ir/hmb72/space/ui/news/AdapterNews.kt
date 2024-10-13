package ir.hmb72.space.ui.news

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.hmb72.space.R
import ir.hmb72.space.databinding.ItemCategoryHomeBinding
import ir.hmb72.space.data.model.home.CategoryModel
import ir.hmb72.space.utils.base.BaseDiffUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.databinding.ItemNewsBinding
import ir.hmb72.space.utils.justifyMode
import javax.inject.Inject

class AdapterNews @Inject constructor(@ApplicationContext private val context:Context) : RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    private lateinit var binding: ItemNewsBinding
    private var items = emptyList<PlanetModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.Q)
        fun bind(item: PlanetModel) {
            binding.apply {

                titleNews.text = item.name
                contentNews.text = item.description
                contentNews.justifyMode()

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