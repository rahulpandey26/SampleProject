package com.example.sampleproject.common.util

interface Constants {

    companion object {
        const val BASE_URL = "https://gorest.co.in/public-api/"
        const val POST_LIST = "posts"
        var AUTH_KEY = "authorizationKey"
    }

    interface HttpReqParamKey {
        companion object {
            const val PAGE = "page"
            const val PER_PAGE = "delay"
        }
    }
}