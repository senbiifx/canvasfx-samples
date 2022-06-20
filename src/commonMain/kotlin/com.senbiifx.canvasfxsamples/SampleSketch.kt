package com.senbiifx.canvasfxsamples

import com.senbiifx.canvasfx.core.random
import com.senbiifx.canvasfx.core.sketch
import com.senbiifx.canvasfx.core.Color

val sampleSketch = sketch {

    var angle = 0.0
    val size = 80.0
    val halfSize = size / 2
    val centerX = width / 2
    val centerY = height / 2


    setup {
        fill = Color.WHITE
    }

    draw {

        fillRect(0.0, 0.0, width, height)

        matrix {
            translate(centerX, centerY)
            fill = Color.ORANGE
            rotate(angle)
            fillRect(-halfSize, -halfSize, size, size)
            angle += 1
        }
    }
}

