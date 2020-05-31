package com.example.sampleproject.home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject.R
import com.example.sampleproject.common.util.Constants
import com.example.sampleproject.common.util.NetworkUtil
import com.example.sampleproject.common.util.SavedPreferences
import com.example.sampleproject.database.DbViewModel
import com.example.sampleproject.home.model.PostResult
import com.example.sampleproject.home.model.UserPostListResponse
import com.example.sampleproject.home.util.UserPostListFactory
import com.example.sampleproject.home.viewModel.UserPostListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mUserPostListViewModel: UserPostListViewModel
    private lateinit var mUserPostListResponse : UserPostListResponse
    private var mDbViewModel: DbViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initializeViews(rootView)
        return rootView
    }

    private fun initializeViews(rootView: View?) {
        mRecyclerView = rootView!!.findViewById(R.id.recycler_view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getUserPostList()
    }

    private fun updateLiveData() {
        mDbViewModel = ViewModelProviders.of(this).get(DbViewModel::class.java)
        mDbViewModel!!.getAllUserPost()?.observe(this,
                Observer<List<PostResult?>?> { postResult -> // update recycler view

                })
    }

    private fun getUserPostList() {
        SavedPreferences.getInstance(requireContext()).setData(Constants.AUTH_KEY, "aRoFeCeFdqZHgJDzLW3yQziUrdQSBNggHW98")

        if(!NetworkUtil.isNetworkAvailable(context)){
            Toast.makeText(context, resources.getString(R.string.dlg_message_no_internet), Toast.LENGTH_SHORT).show()
            return
        }

        mUserPostListViewModel = ViewModelProviders.of(this, UserPostListFactory(
            requireContext(), 1))[UserPostListViewModel::class.java]
        mUserPostListViewModel.init()

        observeProgressBarVisibility()
        mUserPostListViewModel.getUserPostListRepository()?.observe(viewLifecycleOwner, Observer { userPostListResponse ->
            if(userPostListResponse != null) {
                mUserPostListResponse = userPostListResponse
            } else {
                Toast.makeText(context, resources.getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun observeProgressBarVisibility() {
        mUserPostListViewModel.getProgress()?.observe(viewLifecycleOwner, Observer { isProgressVisible ->
            if (isProgressVisible!!) {
                progress_bar_container.visibility = View.VISIBLE
            } else {
                progress_bar_container.visibility = View.GONE
            }
        })
    }
}