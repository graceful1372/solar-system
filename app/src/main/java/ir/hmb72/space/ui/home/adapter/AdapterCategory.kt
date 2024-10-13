package ir.hmb72.space.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.hmb72.space.R
import ir.hmb72.space.databinding.ItemCategoryHomeBinding
import ir.hmb72.space.data.model.home.CategoryModel
import ir.hmb72.space.utils.base.BaseDiffUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AdapterCategory @Inject constructor(@ApplicationContext private val context:Context) : RecyclerView.Adapter<AdapterCategory.ViewHolder>() {
    private lateinit var binding: ItemCategoryHomeBinding
    private var items = emptyList<CategoryModel>()
    private var selectedItem: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemCategoryHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    inner class ViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryModel) {
            binding.apply {
                nameItem.text = item.name

                //Click
                root.setOnClickListener {
                    selectedItem = adapterPosition
                    notifyDataSetChanged()
                    onItemClickListener?.let {
                        it(item.name)
                    }
                }
                //Change color
                if (selectedItem == adapterPosition){
                    nameItem.setTextColor(ContextCompat.getColor(context , R.color.royalBlue ))
                    underLineView.isVisible = true
                    underLineView.setBackgroundColor(ContextCompat.getColor(context , R.color.royalBlue))
                }else if (selectedItem ==-1){
                    if (adapterPosition ==0){
                        nameItem.setTextColor(ContextCompat.getColor(context , R.color.royalBlue ))
                        underLineView.isVisible = true
                        underLineView.setBackgroundColor(ContextCompat.getColor(context , R.color.royalBlue))
                    }
                } else{

                    nameItem.setTextColor(ContextCompat.getColor(context , R.color.Celeste ))
                    underLineView.isVisible = false
                }
            }


        }
    }

    private var onItemClickListener: ((String) -> Unit)? = null
    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    fun setData(data: List<CategoryModel>) {
        val baseDiffUtil = BaseDiffUtils(items, data)
        val diffUtil = DiffUtil.calculateDiff(baseDiffUtil)
        items = data
        diffUtil.dispatchUpdatesTo(this)
    }
}