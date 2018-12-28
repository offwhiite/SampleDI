package c.offwhite.novel.infra

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface INarouNovelAPI {

    @GET("{ncode}/{page}")
    fun getNovel(@Path("ncode") ncode : String, @Path("page") page : String) : Call<ResponseBody>
}