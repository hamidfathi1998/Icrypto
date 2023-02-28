package ir.hfathi.icrypto.ui.feature.main.composables

import android.content.Context
import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.ui.theme.CustomGreen
import ir.hfathi.icrypto.ui.theme.CustomRed
import ir.hfathi.icrypto.utils.getCompatDrawable

class ChartScreenViewState {

    fun getLineDataSet(
        lineData: List<Entry>,
        label: String,
        oneDayChange: Double,
        context: Context
    ) =
        LineDataSet(lineData, label).apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            color = getColorStatus(oneDayChange)
            highLightColor = getColorStatus(oneDayChange)
            fillDrawable = getBackground(oneDayChange, context)
            lineWidth = 2f
            setDrawFilled(true)
            setDrawCircles(false)
        }

    private fun getColorStatus(oneDayChange: Double) =
        if (oneDayChange < 0) CustomRed.toArgb() else CustomGreen.toArgb()


    private fun getBackground(
        oneDayChange: Double,
        context: Context
    ) =
        if (oneDayChange < 0) {
            context.getCompatDrawable(R.drawable.background_negative_chart)
        } else context.getCompatDrawable(R.drawable.background_positive_chart)


}