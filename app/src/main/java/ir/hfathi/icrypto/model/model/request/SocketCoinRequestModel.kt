package ir.hfathi.icrypto.model.model.request

data class SocketCoinRequestModel(
    val op: String,
    val args: List<String>
)
