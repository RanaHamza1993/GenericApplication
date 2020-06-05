package com.havelisolutions.genericapplication.generics

sealed class SafeApiResponse<T>(
    val data: T? = null,
    val message: String? = null,
    val statusCode: Int? = null
) {
    class Success<T>(data: T? = null, statusCode: Int?) :
        SafeApiResponse<T>(
            data = data,
            statusCode = statusCode
        )

    class Loading<T>(data: T? = null) :
        SafeApiResponse<T>(data)

    class Error<T>(
        data: T? = null,
        message: String?,
        statusCode: Int?
    ) :
        SafeApiResponse<T>(data, message, statusCode)

}