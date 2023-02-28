package ir.hfathi.icrypto.model.model.request

enum class CoinArgsType(val value: String) {
    BTC("tickers.BTCUSDT"),
    ETH("tickers.ETHUSDT"),
    XRP("tickers.XRPUSDT"),
    SOL("tickers.SOLUSDT"),
    MATIC("tickers.MATICUSDT"),
    LINK("tickers.LINKUSDT"),
    BNB("tickers.BNBUSDT"),
    ADA("tickers.ADAUSDT"),
    DOT("tickers.DOTUSDT")
}

fun symbolContainStreamCoinArg(symbol: String): Boolean {
    val streamList = listOf(
        "BTC",
        "ETH",
        "XRP",
        "SOL",
        "MATIC",
        "LINK",
        "BNB",
        "ADA",
        "DOT"
    )
    return streamList.contains(symbol)
}