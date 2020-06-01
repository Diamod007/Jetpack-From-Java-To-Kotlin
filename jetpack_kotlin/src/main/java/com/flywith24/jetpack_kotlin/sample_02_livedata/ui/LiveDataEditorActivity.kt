package com.flywith24.jetpack_kotlin.sample_02_livedata.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.flywith24.jetpack_kotlin.R
import com.flywith24.jetpack_kotlin.common_data.APIs
import com.flywith24.jetpack_kotlin.common_data.Configs
import com.kunminx.architecture.ui.BaseActivity
import com.kunminx.architecture.utils.loadImage

/**
 * @author Flywith24
 * @date   2020/5/30
 * time   20:31
 * description
 */
class LiveDataEditorActivity : BaseActivity(R.layout.activity_livedata_detail) {
    /**
     * 不推荐使用 Kotlin Synthetics
     * 可以使用 ViewBinding 和 功能更强大的 DataBinding 来替换 findViewById
     *
     * 本示例尽量只演示单个组件的使用，因此没有使用 ViewBinding 或 DataBinding
     *
     * 详情参考 https://juejin.im/post/5e8ef0bc518825736b749705#heading-17
     */
    private lateinit var mImageView: ImageView
    private lateinit var mTvLocation: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mImageView = findViewById(R.id.iv)
        mTvLocation = findViewById(R.id.tv_locate)

        mImageView.loadImage(APIs.PIC_URL)

        mTvLocation.setOnClickListener {
            startActivityForResult(Intent(this, LiveDataLocationActivity::class.java), Configs.REQUEST_LOCATION_INFO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            Configs.REQUEST_LOCATION_INFO -> {
                val location = data?.getStringExtra(Configs.LOCATION_RESULT)
                mTvLocation.text = location
            }
        }
    }
}