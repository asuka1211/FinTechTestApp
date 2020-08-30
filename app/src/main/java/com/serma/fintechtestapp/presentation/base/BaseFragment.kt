package com.serma.fintechtestapp.presentation.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.serma.fintechtestapp.R
import com.serma.fintechtestapp.data.NetworkRequestState
import com.serma.fintechtestapp.presentation.factory.DaggerViewModelFactory
import javax.inject.Inject

@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
abstract class BaseFragment : Fragment() {

    private lateinit var btnNext: FloatingActionButton
    private lateinit var btnBack: FloatingActionButton
    private lateinit var btnRetry: Button
    private lateinit var img: ImageView
    private lateinit var descTv: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var groupError: Group
    private lateinit var groupContent: Group
    private var lastResponseError = false

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    protected lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        setListeners()
        setObservers()
        initVisibilityForButton()
        initPost()
    }

    private fun initVisibilityForButton() {
        btnBack.visibility = View.INVISIBLE
    }

    private fun buttonVisible(visible: Boolean) {
        if (visible) {
            btnBack.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE
        } else {
            btnBack.visibility = View.GONE
            btnNext.visibility = View.GONE
        }
    }

    private fun initView(view: View) {
        btnNext = view.findViewById(R.id.fragment_content_next_btn)
        btnBack = view.findViewById(R.id.fragment_content_back_btn)
        img = view.findViewById(R.id.fragment_content_img)
        descTv = view.findViewById(R.id.fragment_content_decs_tv)
        progressBar = view.findViewById(R.id.fragment_content_progress_bar)
        groupContent = view.findViewById(R.id.fragment_content_content_group)
        groupError = view.findViewById(R.id.fragment_content_error_group)
        btnRetry = view.findViewById(R.id.fragment_content_retry_btn)
    }

    private fun setListeners() {
        btnNext.setOnClickListener { getNextPost() }
        btnBack.setOnClickListener { viewModel.getPrevious() }
        btnRetry.setOnClickListener { viewModel.getCurrentPost() }
    }

    private fun setObservers() {
        viewModel.post.observe(viewLifecycleOwner) {
            Glide.with(this).load(it.gifUrl).timeout(5000)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        viewModel.errorLoading()
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        descTv.text = it.description
                        return false
                    }
                }).into(img)

        }
        viewModel.isCanGoBack.observe(viewLifecycleOwner) {
            if (it && !lastResponseError) {
                btnBack.visibility = View.VISIBLE
            } else {
                btnBack.visibility = View.INVISIBLE
            }
        }
        viewModel.networkState.observe(viewLifecycleOwner) {
            when (it) {
                NetworkRequestState.LOADING -> progressBar.visibility = View.VISIBLE
                NetworkRequestState.ERROR -> {
                    groupError.visibility = View.VISIBLE
                    groupContent.visibility = View.GONE
                    buttonVisible(false)
                    lastResponseError = true
                }
                NetworkRequestState.SUCCESS -> {
                    if (lastResponseError) {
                        groupError.visibility = View.GONE
                        groupContent.visibility = View.VISIBLE
                        buttonVisible(true)
                        lastResponseError = false
                    }
                }
            }
        }
    }

    private fun initPost() {
        viewModel.getCurrentPost()
    }

    private fun getNextPost() {
        descTv.text = ""
        img.setImageResource(android.R.color.transparent)
        viewModel.getNext()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initViewModule()
    }

    abstract fun initDagger()

    abstract fun initViewModule()
}