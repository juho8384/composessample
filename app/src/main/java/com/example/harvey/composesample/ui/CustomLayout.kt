package com.example.harvey.composesample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.harvey.composesample.R


@Composable
fun CustomLayoutTest() {

        MyColumn(modifier = Modifier.heightIn(max = 50.dp).widthIn(max = 50.dp)) {
            Text(
                text = "hahaha",
                modifier = Modifier
                    .background(colorResource(id = R.color.purple_200))
                    .paddingFromBaseline(top = 24.dp)
            )
            Spacer(modifier = Modifier
                .background(colorResource(id = R.color.design_default_color_error))
                .fillMaxWidth()
                .height(20.dp)
            )
            Text(
                text = "hohoho", modifier = Modifier
                    .background(
                        colorResource(id = R.color.purple_200)
                    )
                    .firstBaselineToTop(11.dp)

            )
        }
}

@Composable
fun MyColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Layout(modifier = modifier, content = content, measurePolicy = { measurables, constraints ->
        val placeables = measurables.map {
            it.measure(constraints)
        }

        var posY = 0

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach {
                it.placeRelative(0, posY)

                posY += it.height * 2
            }
        }

    })
}

fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) =
    layout { measurable: Measurable, constraints: Constraints ->
        val placeable: Placeable = measurable.measure(constraints)
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)


        // 원래 baseLine의 height
        val firstBaseline = placeable[FirstBaseline]

        // 시작점의 y값 =  적용할 padding - baseLineHeight. 기존 baseLine보다 padding이 작을 경우 음수도 가능이나 제약 넘 않음
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {


            placeable.placeRelative(0, placeableY)
        }
    }
