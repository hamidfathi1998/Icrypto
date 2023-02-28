package ir.hfathi.icrypto.model.model.response

data class BaseStreamResponseModel(
    val topic:String,
    val ts:String,
    val type:String,
    val cs:String,
    val data:CoinPriceResponseModel,
)
