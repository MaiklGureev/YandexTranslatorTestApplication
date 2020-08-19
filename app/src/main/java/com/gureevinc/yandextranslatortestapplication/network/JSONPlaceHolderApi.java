package com.gureevinc.yandextranslatortestapplication.network;

import com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage.DetectLanguageRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage.DetectLanguageResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate.TranslateRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate.TranslateResponsePOJO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.gureevinc.yandextranslatortestapplication.StaticVariables.HEADER_1;
import static com.gureevinc.yandextranslatortestapplication.StaticVariables.HEADER_2;

public interface JSONPlaceHolderApi {


    @Headers({HEADER_1, HEADER_2})
    @POST("translate/")
    Call<TranslateResponsePOJO> getTranslation(@Body TranslateRequestPOJO translateRequestPOJO);


    @Headers({HEADER_1, HEADER_2})
    @POST("languages/")
    Call<LanguagesResponsePOJO> getLanguages(@Body LanguagesRequestPOJO languagesRequestPOJO);

    @Headers({HEADER_1, HEADER_2})
    @POST("detect/")
    Call<DetectLanguageResponsePOJO> getLanguageCode(@Body DetectLanguageRequestPOJO detectLanguageRequestPOJO);


}
