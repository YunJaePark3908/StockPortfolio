package com.yjpapp.stockportfolio.constance

import java.util.*

object AppConfig {
    /**
     * Common
     */
    //확장성을 고려하면 나라 코드별로 symbol을 만드는 코드를 집어넣어야 하지만 지금은 한국위주로..
    val moneySymbol: String = Currency.getInstance(Locale.KOREA).symbol
    val GOOGLE_SIGN_CLIENT_ID = "248238742829-c4l2mo77psv2f681sm0lta392hur63fk.apps.googleusercontent.com"
    val NAVER_SIGN_CLIENT_ID = "j9SRSjKtQ1bueHqgd1pv"
    val NAVER_SIGN_CLIENT_SECRET = "5QuEg4cvmA"
    val FACEBOOK_SIGN_APP_ID = "2928940814012749"
    val FACEBOOK_SIGN_PROTOCOL_SCHEME = "fb2928940814012749"

}