package com.havelisolutions.genericapplication.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") @Expose
    private var id: Int = 0,

    @SerializedName("username")
    @Expose
    private val username: String? = null,

    @SerializedName("email")
    @Expose
    private val email: String? = null,

    @SerializedName("website")
    @Expose
    private val website: String? = null
)