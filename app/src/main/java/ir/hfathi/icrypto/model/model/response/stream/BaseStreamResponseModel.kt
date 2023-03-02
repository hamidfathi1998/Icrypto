package ir.hfathi.icrypto.model.model.response.stream

import ir.hfathi.icrypto.model.model.response.coin.CoinPriceResponseModel

data class BaseStreamResponseModel(
    val topic:String,
    val ts:String,
    val type:String,
    val cs:String,
    val data: CoinPriceResponseModel,
)
