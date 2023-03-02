package ir.hfathi.icrypto.model.model.provider

import com.google.gson.Gson
import ir.hfathi.icrypto.model.model.request.CoinArgsType
import ir.hfathi.icrypto.model.model.request.OpType
import ir.hfathi.icrypto.model.model.request.SocketCoinRequestModel
import ir.hfathi.icrypto.model.model.response.stream.BaseStreamResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinPriceResponseModel

class CoinStreamModelConvertor {
    fun get(): String =
        Gson().toJson(
            SocketCoinRequestModel(
                op = OpType.SUBSCRIBE.value,
                args = listOf(
                    CoinArgsType.BTC.value,
                    CoinArgsType.ETH.value,
                    CoinArgsType.DOT.value,
                    CoinArgsType.XRP.value,
                    CoinArgsType.SOL.value,
                    CoinArgsType.MATIC.value,
                    CoinArgsType.LINK.value,
                    CoinArgsType.BNB.value,
                    CoinArgsType.ADA.value,
                )
            )
        )

    fun set(response: String): CoinPriceResponseModel =
        Gson().fromJson(response, BaseStreamResponseModel::class.java).data
}

