package com.example.exchange_rate.model.UsetRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exchange_rate.R
import com.example.exchange_rate.databinding.ItemMoneyLayoutBinding
import com.example.exchange_rate.databinding.ItemUserLayoutBinding
import com.example.exchange_rate.screens.start.StartAdapter
import com.example.exchange_rate.screens.start.StartFragment

interface UserActionListener {
    fun UserMove(user: User, moveBy: Int)
    fun UserDelete(user: User)
    fun UserDetails(user: User)
}
class UserAdapter(
    private val actionListener: UserActionListener
): RecyclerView.Adapter<UserAdapter.UserViewHolder>(), View.OnClickListener {

    var users :List<User> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class UserViewHolder(val binding: ItemUserLayoutBinding) :RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserLayoutBinding.inflate(inflater,parent,false)
        binding.root.setOnClickListener(this)
        binding.imageviewMore.setOnClickListener(this)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var user = users[position]
        with(holder.binding) {
            holder.itemView.tag = user
            imageviewMore.tag = user
            nameTextview.text = user.name
            companyTextview.text = user.company
            if(user.photo.isNotBlank()) {
                Glide.with(imageview.context)
                    .load(user.photo)
                    .circleCrop()
                    .placeholder(R.drawable.error_image)
                    .error(R.drawable.error_image)
                    .into(imageview)
            }
        }
    }

    override fun onClick(v: View?) {
        val user = v?.tag as User
        when(v?.id) {
            R.id.imageview_more -> {
            }
            else -> {
                actionListener.UserDetails(user)
            }
        }
    }
}