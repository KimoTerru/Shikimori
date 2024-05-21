package com.dev.shikimori.data.remote.list

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ListApi {
    @Headers(
        value = [
            "User-Agent: Shikimori",
            "Authorization: Bearer {SHIKIMORI_TOKEN}"
        ]
    )
    @GET("/api/users/{id}/anime_rates")
    suspend fun getUserRateAnimeList(
        @Path("id") idUser: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("status") status: String,
        @Query("censored") censored: Boolean
    )//: UserRateList

    @Headers(
        value = [
            "User-Agent: Shikimori",
            "Authorization: Bearer {SHIKIMORI_TOKEN}"
        ]
    )
    @GET("/api/users/{id}/anime_rates")
    suspend fun getUserRateMangaList(
        @Path("id") idUser: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("censored") censored: Boolean
    )//: UserRateList
}