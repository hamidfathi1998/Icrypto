package ir.hfathi.icrypto.model.model.response.coin

data class CoinPriceResponseModel(
    var symbol:String = String(),
    var lastPrice:String = String(),
    var highPrice24h:String = String(),
    var lowPrice24h:String = String(),
    var prevPrice24h:String = String(),
    var volume24h:String = String(),
    var turnover24h:String = String(),
    var price24hPcnt:String = String(),
    var usdIndexPrice:String = String(),
)
