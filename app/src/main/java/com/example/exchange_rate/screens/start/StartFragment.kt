package com.example.exchange_rate.screens.start

import android.net.wifi.p2p.WifiP2pManager.ActionListener
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.exchange_rate.data.api.ApiInterface
import com.example.exchange_rate.databinding.FragmentStartBinding
import com.example.exchange_rate.model.UsetRV.*
import com.example.exchange_rate.model.rateAlpha.RateAlpha
import com.github.javafaker.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var binding: FragmentStartBinding
private lateinit var recyclerView: RecyclerView
lateinit var adapter: UserAdapter

class StartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    private val userService: UserService
        get() = (activity?.applicationContext as app).userService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        adapter = StartAdapter()
//        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
//        binding = FragmentStartBinding.inflate(inflater, container, false)
//        recyclerView = binding.rvStart
//        recyclerView.adapter = adapter
//        viewModel.getMoney()
        adapter = UserAdapter(object : UserActionListener {
            override fun UserMove(user: User, moveBy: Int) {
                TODO("Not yet implemented")
            }

            override fun UserDelete(user: User) {
                TODO("Not yet implemented")
            }

            override fun UserDetails(user: User) {
                Toast.makeText(activity?.applicationContext, "User ${user.name}", Toast.LENGTH_SHORT).show()
            }
        })
        binding = FragmentStartBinding.inflate(inflater, container, false)
        recyclerView = binding.rvStart
        recyclerView.adapter = adapter
        userService.addListener(usersListener)
        return binding.root
    }



    private val usersListener: UsersListener = { adapter.users = it }
    override fun onDestroy() {
        super.onDestroy()
        userService.deleteListener(usersListener)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}