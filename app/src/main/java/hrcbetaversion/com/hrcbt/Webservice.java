package hrcbetaversion.com.hrcbt;

import hrcbetaversion.com.hrcbt.Response.DiagonsticResponse;
import hrcbetaversion.com.hrcbt.Response.HomeDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {

    @GET("api/ShopByPetVC/getAtHomedata")
    Call<HomeDataResponse> getHomeData();

    @GET("api/ShopByPetVC/getDiagnosticsdata")
    Call<DiagonsticResponse> DIAGONSTIC_RESPONSE_CALL();
}
