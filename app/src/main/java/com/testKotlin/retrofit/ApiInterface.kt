package com.testKotlin.retrofit

import com.dataClass.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterface {

   /* var register = "register"
    var credit_priority = "credit-priority"
    var contribution_method = "contribution-method"
    var plaid = "plaid"
    var updatePlaid = "plaid/{id}"
    var user_profile = "user-profile"
    var login = "login"
    var check_email = "email-exists"
    var thinload = "ThinSubscriberAPIServlet"
    var partnerToken = "api/token/partner"
    var getUserTokenExperian = "partner-login"
    var startVerification = "Services/VAa3355480854904f1827e045f841cd029/Verifications"
    var checkVerification = "Services/VAa3355480854904f1827e045f841cd029/VerificationCheck"
    var googleplaces = "autocomplete/json"
*/
   /* @FormUrlEncoded
    @POST(register)
    fun callSingUp(
        @Header("Accept") accept: String?,
        @Field("email") email: String?,
        @Field("sec_questions") securityQuestionList: String?,
        @Field("user_name") username: String?,
        @Field("card_number") cardNumber: String?,
        @Field("name") nameonCard: String?,
        @Field("exp_month") expMonth: String?,
        @Field("exp_year") expYear: String?,
        @Field("cvc") cvv: String?,
        @Field("country_code") countryCode: String?,
        @Field("price_id") stripePlanId: String?,
        @Field("first_name") first_name: String?,
        @Field("last_name") last_name: String?,
        @Field("phone_number") phone_number: String?,
        @Field("address") address: String?,
        @Field("city") city: String?,
        @Field("state") state: String?,
        @Field("zip_code") zip_code: String?,
        @Field("password") password: String?,
        @Field("public_key_id") public_key_id: String?,
        @Field("device_token") device_token: String?
    ): Observable<RegistrationResponse?>?

    @POST
    fun callLinkToken(
        @Url url: String?,
        @Header("Content-Type") content_type: String?,
        @Body requestModel: PlaidLinkDetailsRequestModel?
    ): Observable<LinkTokenResponse?>?

    @POST
    fun callExchangeToken(
        @Url url: String?,
        @Header("Content-Type") content_type: String?,
        @Body exchangeTokenRequestmodel: ExchangeTokenRequestmodel?
    ): Observable<ExchangeTokenResponse?>?

    @FormUrlEncoded
    @POST(credit_priority)
    fun setCreditPriority(@Field("option") option: Int): Observable<CreditPriorityResponse?>?

    @FormUrlEncoded
    @POST(contribution_method)
    fun setContributionmethod(@Field("option") option: Int): Observable<ContributionMethodResponse?>?

    @FormUrlEncoded
    @POST(plaid)
    fun storePlaidDetials(
        @Field("account_details") account_details: String?,
        @Field("bank_id") bank_id: String?,
        @Field("bank_name") bank_name: String?,
        @Field("access_token") access_token: String?
    ): Observable<StorePlaidDetailsResponse?>?


    @PUT(updatePlaid)
    fun updatePlaidDetails(
        @Path("id") id: Int,
        @Body updatePlaidDetails: UpdatePlaidDetails?
    ): Observable<UpdatePlaidDetailsResponse?>?

    @GET(plaid)
    fun getUserPlaidDeails(): Observable<GetPlaidDetailsResponse?>?

    @GET(user_profile)
    fun getUserProfile(): Observable<UserProfileResponse?>?*/

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") user_name: String?,
        @Field("password") password: String?
    ): Observable<LoginResponse?>?


}